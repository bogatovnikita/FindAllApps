package com.bogatovnikita.findallapps.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.ActivityMainBinding
import com.bogatovnikita.findallapps.view.main.ButtonFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ButtonFragment.newInstance()).commit()
    }


}