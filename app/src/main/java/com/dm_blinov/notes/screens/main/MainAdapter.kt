package com.dm_blinov.notes.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dm_blinov.notes.R
import com.dm_blinov.notes.models.AppNote

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class MainHolder(view: View): RecyclerView.ViewHolder(view){
        val nameNote:TextView = view.findViewById(R.id.item_note_name)
        val textNote:TextView = view.findViewById(R.id.item_note_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
    return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        //Инициализируем поля
        holder.nameNote.text = mListNotes[position].name
        holder.textNote.text = mListNotes[position].text
    }

    override fun getItemCount(): Int {
        return mListNotes.size
    }
    fun setList(list: List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainFragment.onClickItem(mListNotes[holder.absoluteAdapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

}