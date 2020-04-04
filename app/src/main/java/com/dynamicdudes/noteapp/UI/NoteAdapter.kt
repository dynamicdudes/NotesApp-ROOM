package com.dynamicdudes.noteapp.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.dynamicdudes.noteapp.Database.Note
import com.dynamicdudes.noteapp.R
import kotlinx.android.synthetic.main.note_layout.view.*

class NoteAdapter(val notes : List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_layout,parent,false)
        return NoteViewHolder(view)

    }

    override fun getItemCount() : Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.title.text = notes[position].title
        holder.message.text = notes[position].message

        holder.itemView.setOnClickListener(View.OnClickListener {
            val action = HomeFragmentDirections.actionAddNote()
            action.note = notes[position]
            Navigation.findNavController(it).navigate(action)
        })

    }
    class NoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.text_view_title
        val message = itemView.text_view_note
    }

}