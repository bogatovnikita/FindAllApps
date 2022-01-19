package com.bogatovnikita.findallapps.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogatovnikita.findallapps.R

class InfoAppScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_app_screen, container, false)
    }

    companion object {
        fun newInstance() = InfoAppScreenFragment()
    }
}