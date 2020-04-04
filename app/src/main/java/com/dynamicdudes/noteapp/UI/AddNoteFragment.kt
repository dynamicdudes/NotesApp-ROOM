package com.dynamicdudes.noteapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.dynamicdudes.noteapp.Database.Note
import com.dynamicdudes.noteapp.Database.NoteDatabase

import com.dynamicdudes.noteapp.R
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch


class AddNoteFragment : BaseFragment() {

    private var note : Note? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            note = AddNoteFragmentArgs.fromBundle(it).note
            edit_text_title.setText(note?.title)
            edit_text_message.setText(note?.message)
        }


        button_save.setOnClickListener{ view ->

            val noteTitle = edit_text_title.text.toString()
            val noteMessage = edit_text_message.text.toString()

            if(noteTitle.isEmpty()){
                edit_text_title.also {
                    it.error = "NULL POINTER"
                    it.requestFocus()
                }
                return@setOnClickListener
            }

            if(noteMessage.isEmpty()){
                edit_text_message.also {
                    it.error = "NULL POINTER"
                    it.requestFocus()
                }
                return@setOnClickListener
            }

            launch {
                val note = Note(noteTitle,noteMessage)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    it.toast("Note Saved")

                    val action = AddNoteFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view).navigate(action)

                }
            }
        }
    }


}
