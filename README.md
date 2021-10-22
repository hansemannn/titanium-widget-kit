# Titanium iOS / Android Widgets

Use the iOS 14+ WidgetKit and Android Widget API's in Titanium. iOS Note: You can create widgets without this module. This one is only
necessary for advanced widget communication, e.g. triggering a widget refresh from the companion app.

## Requirements

- [x] iOS 14+
- [x] Android 5+

## Example

```js
import TiWidgetKit from 'ti.widgetkit';

TiWidgetKit.reloadAllTimelines();
```

## License

MIT

## Author

Hans Knöchel (iOS)
Michael Gangolf (Android)
