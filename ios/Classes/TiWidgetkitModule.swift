//
//  TiWidgetkitModule.swift
//  titanium-widget-kit
//
//  Created by Hans Knoechel
//  Copyright (c) 2020 Your Company. All rights reserved.
//

import UIKit
import TitaniumKit

#if !targetEnvironment(macCatalyst)
import WidgetKit
#endif

@objc(TiWidgetkitModule)
class TiWidgetkitModule: TiModule {

  public let testProperty: String = "Hello World"
  
  func moduleGUID() -> String {
    return "4806f1ee-d99b-44b5-9aa4-68c3955d97ce"
  }
  
  override func moduleId() -> String! {
    return "ti.widgetkit"
  }

  @objc(reloadAllTimelines:)
  func reloadAllTimelines(unused: Array<Any>?) {
    #if !targetEnvironment(macCatalyst)
    WidgetCenter.shared.reloadAllTimelines()
    #else
    print("WidgetKit is only available on iOS so far")
    #endif
  }
}
