package jp.co.mitsuhori_y.mpandroidchartsample

import android.content.Context
import android.graphics.Canvas
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF

/**
 * Created by mitsuhori_y on 2017/11/21.
 */
class MyMarkerView(context: Context?, layoutResource: Int) : MarkerView(context, layoutResource) {
    val textView: TextView

    init {
        textView = findViewById<TextView>(R.id.textView)
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        textView.setText("" + e?.y)
        super.refreshContent(e, highlight)
    }

    var mOffset: MPPointF? = null

    override fun getOffset(): MPPointF? {

        if (mOffset == null) {
            mOffset = MPPointF(-(getWidth() / 2).toFloat(), -getHeight().toFloat())
        }

        return mOffset
    }

    override fun draw(canvas: Canvas, posX: Float, posY: Float) {
        var y = posY
        if (posY < 200) {
            y = posY + 80
        } else {
            y = posY - 30
        }
        super.draw(canvas, posX, y)
    }

}