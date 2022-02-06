package com.dm_blinov.notes.screens.addNewNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dm_blinov.notes.R
import com.dm_blinov.notes.databinding.FragmentAddNewNoteBinding
import com.dm_blinov.notes.models.AppNote
import com.dm_blinov.notes.utils.showToast


class AddNewNoteFragment : Fragment() {

    private var fragmentAddNewNote: FragmentAddNewNoteBinding? = null
    private lateinit var mViewModel: AddNewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentAddNewNote = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)

        return fragmentAddNewNote?.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        fragmentAddNewNote?.addNoteButton?.setOnClickListener {
            val name = fragmentAddNewNote?.inputNameNote?.text.toString()
            val text = fragmentAddNewNote?.inputTextNote?.text.toString()

            if(name.isEmpty()){
                showToast(getString(R.string.toast_enter_name))
            } else {
                val note = AppNote(name = name, text = text)
                mViewModel.insert(note){
                    findNavController().navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentAddNewNote = null
    }
}