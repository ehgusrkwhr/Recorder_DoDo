package com.example.dodorecoder

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton

class RecorderButton(context: Context, attrs: AttributeSet) : AppCompatImageButton(context, attrs) {

    init {
        setBackgroundResource(R.drawable.shape_oval_button)
    }


    fun updateStateIcon(state: RecorderState) {
        when (state) {
            RecorderState.BEFORE_RECORDING -> setImageResource(R.drawable.ic_play)
            RecorderState.ON_PLAYING -> setImageResource(R.drawable.ic_stop)
        }
    }

}