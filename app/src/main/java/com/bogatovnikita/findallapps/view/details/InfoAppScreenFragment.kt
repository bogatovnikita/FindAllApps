package com.bogatovnikita.findallapps.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogatovnikita.findallapps.databinding.FragmentInfoAppScreenBinding

class InfoAppScreenFragment() : Fragment() {

    private var _binding: FragmentInfoAppScreenBinding? = null
    private val binding: FragmentInfoAppScreenBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentInfoAppScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = InfoAppScreenFragment()
    }



}