package com.example.toasthandler

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mToastTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button_ok)
        button.setOnClickListener {
            val text = "Кнопка ОК!"
            val duration = Toast.LENGTH_SHORT

            val toast = makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.CENTER, 0,0)
            toast.show()
        }

    }
}