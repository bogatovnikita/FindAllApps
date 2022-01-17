package com.bogatovnikita.findallapps.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.ActivityMainBinding
import com.bogatovnikita.findallapps.view.main.ButtonFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSwitchCompat()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ButtonFragment.newInstance()).commit()
    }

    private fun initSwitchCompat() {
        binding.switchCompat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}