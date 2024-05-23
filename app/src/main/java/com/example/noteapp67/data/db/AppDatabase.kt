package com.example.noteapp67.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp67.data.db.daos.NoteDao
import com.example.noteapp67.data.models.NoteModel

@Database(entities = [NoteModel::class], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao():NoteDao
}