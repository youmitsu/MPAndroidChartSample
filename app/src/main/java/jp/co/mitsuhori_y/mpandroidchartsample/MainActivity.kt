package jp.co.mitsuhori_y.mpandroidchartsample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import com.github.mikephil.charting.components.IMarker
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.ChartTouchListener
import com.github.mikephil.charting.listener.OnChartGestureListener
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), OnChartGestureListener, OnChartValueSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        show()
    }

    fun getEntries(): ArrayList<Entry> {
        val entries: ArrayList<Entry> = ArrayList()
        for (i in 0..27) {
            if (i % 2 == 0) {
                val w = Weight(Random().nextFloat() * 100, Random().nextFloat() * 20)
                val entry = Entry(i.toFloat(), w.weight)
                entries.add(entry)
            }
        }
        return entries
    }

    fun show() {
        val dataSet = LineDataSet(getEntries(), "Weight")
        dataSet.lineWidth = 5.0.toFloat()
        dataSet.color = Color.MAGENTA
        dataSet.setCircleColor(Color.MAGENTA)
        dataSet.setDrawCircleHole(false)
        dataSet.circleRadius = 5f

        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.setTouchEnabled(true)
        chart.isDragEnabled = true
        chart.isScaleXEnabled = true
        chart.isScaleYEnabled = false
        chart.setPinchZoom(true)
        chart.isDoubleTapToZoomEnabled = false

        chart.setVisibleXRangeMaximum(8.0.toFloat())
        chart.setVisibleXRangeMinimum(1.0.toFloat())
        chart.moveViewToX(999f)
        // chart.centerViewTo(70.0.toFloat(), 12.0.toFloat(), YAxis.AxisDependency.LEFT)

//        val xAxis = chart.xAxis
//        xAxis.axisMaximum = 50.0.toFloat()
//        xAxis.axisMinimum = 40.0.toFloat()

        val marker: IMarker = MyMarkerView(this, R.layout.marker_view)
        chart.marker = marker

        chart.setOnChartValueSelectedListener(this)
        chart.highlightValue(10.toFloat(), 0, true)
        chart.onChartGestureListener = this

        chart.invalidate()
    }

    override fun onNothingSelected() {
        Log.i("NothingSelected", "true")
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        Log.i("ValueSelected", "Entry: ${e.toString()}, Hightlight: ${h.toString()}")
    }

    override fun onChartGestureEnd(me: MotionEvent?, lastPerformedGesture: ChartTouchListener.ChartGesture?) {
        Log.i("GestureEnd", "true")
    }

    override fun onChartFling(me1: MotionEvent?, me2: MotionEvent?, velocityX: Float, velocityY: Float) {
        Log.i("ChartFling", "true")
    }

    override fun onChartSingleTapped(me: MotionEvent?) {
        Log.i("SingleTapped", "true")
    }

    override fun onChartGestureStart(me: MotionEvent?, lastPerformedGesture: ChartTouchListener.ChartGesture?) {
        Log.i("GestureStart", "true")
    }

    override fun onChartScale(me: MotionEvent?, scaleX: Float, scaleY: Float) {
        Log.i("Scale", "true")
    }

    override fun onChartLongPressed(me: MotionEvent?) {
        Log.i("LongPressed", "true")
    }

    override fun onChartDoubleTapped(me: MotionEvent?) {
        Log.i("DoubleTapped", "true")
        show()
    }

    override fun onChartTranslate(me: MotionEvent?, dX: Float, dY: Float) {
        //Log.i("Translate", "true")
    }
}
