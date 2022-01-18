package com.bogatovnikita.findallapps.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
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
    ): View {
        _binding = FragmentButtonBinding.inflate(inflater, container, false)
        initSwitchCompat()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageBtn.setOnClickListener {
            activity?.run {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AllAppsFragment.newInstance()).addToBackStack("")
                    .commit()
            }
        }
    }

    companion object {
        fun newInstance() = ButtonFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initSwitchCompat() {
        binding.switchCompat.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.imageIcon.setImageResource(R.drawable.ic_find_white)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.imageIcon.setImageResource(R.drawable.ic_find_black)
            }
        }
    }
}