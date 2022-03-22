package com.example.dodorecoder

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast

class AtmView(context : Context, attrs: AttributeSet) : View(context,attrs){

    companion object {
        private const val LINE_WIDTH = 10F
        private const val LINE_SPACE = 15F
        private const val MAX_AMPLITUDE = Short.MAX_VALUE.toFloat()
        private const val ACTION_INTERVAL = 20L
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.getColor(R.color.teal_200)
        strokeWidth = LINE_WIDTH
        strokeCap = Paint.Cap.ROUND
    }

    private var dWidth : Int = 0
    private var dHeight : Int = 0

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.d("dodo2"," onSizeChanged ")
        dWidth = w
        dHeight = h
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("dodo2"," onDraw ")
        val coordinateY = (dHeight / 2).toFloat()
        val coordinateX = dWidth.toFloat()-500f
        Log.d("dodo2"," coordinateY $coordinateY ")
        Log.d("dodo2"," coordinateX $coordinateX ")
        val lineLength = 500 / MAX_AMPLITUDE * dHeight * 0.8F
        canvas?.drawLine(coordinateX,lineLength,coordinateX,lineLength,paint)
    }
}