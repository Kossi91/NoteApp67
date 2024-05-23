package com.example.noteapp67.interfaces

import com.example.noteapp67.data.models.NoteModel

interface OnClickItem {

    fun onLongClick(noteModel: NoteModel)

    fun onClick(noteModel: NoteModel)
}