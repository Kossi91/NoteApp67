package com.example.noteapp67.ui.fragments.note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.noteapp67.App
import com.example.noteapp67.R
import com.example.noteapp67.data.extensions.setBackStackData
import com.example.noteapp67.data.models.NoteModel
import com.example.noteapp67.databinding.FragmentDetailBinding

class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var noteId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        update()
        setupListeners()
    }

    private fun update() {
        arguments?.let {
            noteId = it.getInt("noteId", -1)
        }
        if (noteId != -1) {
            val args = App().getInstance()?.noteDao()?.getNoteById(noteId)
            args?.let { model ->
                binding.etTitle.setText(model.title)
                binding.etDescription.setText(model.description)
            }
        }
    }

    private fun setupListeners() {
        binding.btnAddText.setOnClickListener {
            val etTitle = binding.etTitle.text.toString()
            val etDescription = binding.etDescription.text.toString()
            if (noteId != -1){
                val updateNote = NoteModel(etTitle,etDescription)
                updateNote.id = noteId
                App().getInstance()?.noteDao()?.updateNote(updateNote)
            }else {
                App().getInstance()?.noteDao()?.insertNote(NoteModel(etTitle, etDescription))
            }
            findNavController().navigateUp()
        }
    }
}