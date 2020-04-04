package com.dynamicdudes.noteapp.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note : Note)

    @Query("select * from note order by id desc")
    suspend fun getAllNote() : List<Note>

    @Insert
    suspend fun addMultipleNote(vararg note : Note)

    @Update
    suspend fun updateNote(note : Note)

}