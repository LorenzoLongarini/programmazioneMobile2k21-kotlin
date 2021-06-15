package com.example.easycooking.utils
import android.content.Context
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * questa classe astratta viene utilizzata per eliminare, scorrendo verso sinistra, gli elementi nella dispensa,
 * nella lista della spesa e le ricette inserite dagli utenti loggati
 */

abstract class SwipeToDelete(context: Context, dragDir:Int,swipeDir:Int): ItemTouchHelper.SimpleCallback(dragDir,swipeDir,) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        TODO("Not yet implemented")
    }
}