package com.udacity.stockhawk.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.udacity.stockhawk.R;
import com.udacity.stockhawk.ui.MainActivity;

import static com.udacity.stockhawk.R.id.widget_empty;
import static com.udacity.stockhawk.R.id.widget_list_view;

/**
 * Implementation of App Widget functionality.
 */
public class StockAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        /*CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.stock_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);*/


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.stock_app_widget);

        // launching main activity when clicking the bar button.
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        //views.setOnClickPendingIntent(R.id.wid,pendingIntent);
        views.setRemoteAdapter(widget_list_view,
                new Intent(context,
                        StockWidgetRemoteViewsService.class));
        views.setEmptyView(R.id.widget_list_view,R.id.widget_empty);
        appWidgetManager.updateAppWidget(appWidgetId, views);

//        Cursor data = context.getContentResolver().query(Contract.Quote.uri,
//                Contract.Quote.QUOTE_COLUMNS,
//                null, null, Contract.Quote.COLUMN_SYMBOL);
//        if (data == null){
//            return;
//        }
//
//        data.close();
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

