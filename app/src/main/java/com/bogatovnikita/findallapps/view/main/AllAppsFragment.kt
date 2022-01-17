package com.bogatovnikita.findallapps.view.main

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.FragmentAllAppsBinding
import com.bogatovnikita.findallapps.databinding.FragmentButtonBinding

class AllAppsFragment : Fragment() {
    private var _binding: FragmentAllAppsBinding? = null
    private val binding: FragmentAllAppsBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllAppsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = AllAppsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}