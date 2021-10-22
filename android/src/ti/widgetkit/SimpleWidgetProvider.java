package ti.widgetkit;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleWidgetProvider extends AppWidgetProvider {


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int count = appWidgetIds.length;

        // get text from app/shared preferences
        String text = "";
        SharedPreferences sharedPref = context.getSharedPreferences("titanium", Context.MODE_PRIVATE);
        String appString = sharedPref.getString("widgetData", "{\"text\":''}");
        try {
            JSONObject appData = new JSONObject(appString);
            text = appData.getString("text");
        } catch (JSONException e) {

        }

        // update all widgets
        for (int i = 0; i < count; i++) {
            int widgetId = appWidgetIds[i];

            // get view
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);

            // set text to text field
            remoteViews.setTextViewText(R.id.textView, text);

            // update ui
            Intent intent = new Intent(context, SimpleWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);

            // send update on click
            //remoteViews.setOnClickPendingIntent(R.id.actionButton, pendingIntent);
            
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }
}
