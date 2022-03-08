package com.emotionfactry.counterclient.presentation.main.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emotionfactry.counterclient.R
import com.emotionfactry.counterclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.supportActionBar?.hide()
        this.supportActionBar?.setDisplayShowHomeEnabled(true)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        //setSupportActionBar(binding.mainContent.mainToolbar)
        //window.statusBarColor = Color.TRANSPARENT
    }
}