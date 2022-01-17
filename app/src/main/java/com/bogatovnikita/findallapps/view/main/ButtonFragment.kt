package com.bogatovnikita.findallapps.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.FragmentButtonBinding

class ButtonFragment : Fragment() {

    private var _binding: FragmentButtonBinding? = null
    private val binding: FragmentButtonBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = ButtonFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}