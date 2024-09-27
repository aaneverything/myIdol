package com.example.myidol

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        supportActionBar?.title = ""

        // Set image from drawable resources
        val imageView: ImageView = findViewById(R.id.profile_image)
        imageView.setImageResource(R.drawable.aan)

        // Set text from string resources
        val myString = getString(R.string.namee)
        val textView: TextView = findViewById(R.id.name_text)
        textView.text = myString

        val myString2 = getString(R.string.email)
        val textView2: TextView = findViewById(R.id.email_text)
        textView2.text = myString2


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}