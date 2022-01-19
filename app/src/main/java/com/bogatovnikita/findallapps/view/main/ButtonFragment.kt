package com.bogatovnikita.findallapps.view.main

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
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
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSwitchCompat()
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

    private val SHARED_PREFS = "key"
    private fun initSwitchCompat() {
        val sharedPreferences = requireActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        binding.switchCompat.isChecked = sharedPreferences.getBoolean(SHARED_PREFS, false)
        binding.switchCompat.setOnCheckedChangeListener { _, isChecked ->
            val editor = sharedPreferences.edit()
            editor.putBoolean(SHARED_PREFS, isChecked)
            editor.apply()
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}