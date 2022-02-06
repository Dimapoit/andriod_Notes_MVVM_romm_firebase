package com.dm_blinov.notes.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dm_blinov.notes.R
import com.dm_blinov.notes.databinding.FragmentStartBinding
import com.dm_blinov.notes.utils.TYPE_ROOM

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    val mBinding get() = _binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        val view = mBinding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    fun initialization() {
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        mBinding.btnRoom.setOnClickListener {
            mViewModel.initDatabase(TYPE_ROOM) {
                findNavController().navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}