package com.dm_blinov.notes.screens.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dm_blinov.notes.R
import com.dm_blinov.notes.databinding.FragmentMainBinding
import com.dm_blinov.notes.databinding.FragmentNoteBinding
import com.dm_blinov.notes.models.AppNote
import com.dm_blinov.notes.screens.main.MainAdapter
import com.dm_blinov.notes.screens.main.MainFragmentViewModel
import com.dm_blinov.notes.utils.APP_ACTIVITY


class NoteFragment : Fragment() {

    private var framentNoteBinding: FragmentNoteBinding? = null
    private lateinit var mViewModel: NoteFragmentViewModel
    private lateinit var mCurrentNote: AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        framentNoteBinding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        val view = framentNoteBinding?.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    fun initialization() {
        //Добавляем кнопку удаления заметки в меню
        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
        framentNoteBinding?.noteName?.text = mCurrentNote.name
        framentNoteBinding?.noteText?.text = mCurrentNote.text
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_delete -> {
                mViewModel.delete(mCurrentNote){
                    findNavController().navigate(R.id.action_noteFragment_to_mainFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        framentNoteBinding = null
    }

}