package com.example.noteapp67.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp67.R
import com.example.noteapp67.data.extensions.getBackStackData
import com.example.noteapp67.data.models.NoteModel
import com.example.noteapp67.databinding.FragmentNoteBinding
import com.example.noteapp67.ui.adapter.NoteAdapter
import com.example.noteapp67.utils.PreferenceHelper

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding
    private val noteAdapter = NoteAdapter()
    private val list: ArrayList<NoteModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        getData()
    }

    private fun initialize() {
        binding.rvNote.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun setupListeners() = with(binding) {
//        val preferenceHelper = PreferenceHelper()
//        preferenceHelper.unit(requireContext())
//
//        saveBtn.setOnClickListener {
//            val et = edText.text.toString()
//            preferenceHelper.title = et
//            saveText.text = et
//        }
//        saveText.text = preferenceHelper.title
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment)
        }
    }

    private fun getData(){
        getBackStackData<String>("key"){data->
            val noteModel = NoteModel(data)
            list.add(noteModel)
            noteAdapter.submitList(list)
        }
    }
}