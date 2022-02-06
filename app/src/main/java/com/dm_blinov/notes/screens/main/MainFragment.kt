package com.dm_blinov.notes.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dm_blinov.notes.R
import com.dm_blinov.notes.databinding.FragmentMainBinding
import com.dm_blinov.notes.models.AppNote
import com.dm_blinov.notes.utils.APP_ACTIVITY

class MainFragment : Fragment() {

    private var framentMainBinding: FragmentMainBinding? = null
    private lateinit var mViewModel: MainFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter
    private lateinit var mObserverList: Observer<List<AppNote>>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        framentMainBinding = FragmentMainBinding.inflate(layoutInflater, container, false)

        val view = framentMainBinding?.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    fun initialization() {
        mAdapter = MainAdapter()
        mRecyclerView = framentMainBinding?.recyclerView!!
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter.setList(list)
        }
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mViewModel.allNotes.observe(this,mObserverList)
        framentMainBinding?.btnAddNote?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        framentMainBinding = null
        mViewModel.allNotes.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }

    companion object{

        fun onClickItem(note: AppNote) {
            var bundle = Bundle()
            bundle.putSerializable("note", note)
            Navigation.findNavController(APP_ACTIVITY, R.id.nav_host_fragment)
                .navigate(R.id.action_mainFragment_to_noteFragment, bundle)
        }
    }
}
