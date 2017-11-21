package jp.co.mitsuhori_y.mpandroidchartsample;

import android.content.Context;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;

/**
 * Created by mitsuhori_y on 2017/11/21.
 */

public class MyLineChart extends LineChart {
    public MyLineChart(Context context) {
        super(context);
    }

    public MyLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLineChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();

        mRenderer = new MyLineChartRenderer(this, mAnimator, mViewPortHandler);
    }
    
}
