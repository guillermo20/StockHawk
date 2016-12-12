package com.udacity.stockhawk.utils;

import android.content.Context;

import com.github.mikephil.charting.components.MarkerView;

/**
 * Created by guillermo on 12/11/16.
 */

public class XYMarkerView extends MarkerView {
    public XYMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
    }
    /*private TextView tvContent;
    private IAxisValueFormatter xAxisValueFormatter;

    private DecimalFormat format;

    public XYMarkerView(Context context, IAxisValueFormatter xAxisValueFormatter) {
        super(context, R.layout.custom_marker_view);

        this.xAxisValueFormatter = xAxisValueFormatter;
        tvContent = (TextView) findViewById(R.id.tvContent);
        format = new DecimalFormat("###.0");
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        tvContent.setText("x: " + xAxisValueFormatter.getFormattedValue(e.getX(), null) + ", y: " + format.format(e.getY()));

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }*/
}
