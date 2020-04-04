package com.dynamicdudes.noteapp.Database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note(
    var title : String,
    var message : String
) : Serializable{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}