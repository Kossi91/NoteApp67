package com.example.noteapp67.ui.fragments.note

import android.os.Bundle
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnAddText.setOnClickListener {
            val etTitle = binding.etTitle.text.toString()
            val etDescription = binding.etDescription.text.toString()
            App().getInstance()?.noteDao()?.insertNote(NoteModel(etTitle, etDescription))
            findNavController().navigateUp()
        }
    }
}