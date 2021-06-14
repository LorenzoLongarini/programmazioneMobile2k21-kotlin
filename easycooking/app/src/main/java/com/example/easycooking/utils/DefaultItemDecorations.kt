package com.example.easycooking.memory.dispensa

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * In questa classe definiamo le specifiche grafiche degli elementi presenti nella recycler view
 *
 */

class DefaultItemDecorator(private val horizontalSpacing:Int, private val verticalSpacing:Int): RecyclerView.ItemDecoration(){
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = horizontalSpacing
        outRect.left = horizontalSpacing
        outRect.top=verticalSpacing
        outRect.bottom=verticalSpacing
    }
}