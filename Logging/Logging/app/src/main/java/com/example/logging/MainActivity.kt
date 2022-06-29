package com.example.logging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import timber.log.Timber
import timber.log.Timber.Forest.plant

private const val TAG = "From EditText"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plant(Timber.DebugTree())

        val editText: EditText = findViewById(R.id.editText)

        val buttonL: Button = findViewById(R.id.button_log)
        buttonL.setOnClickListener {

               Log.v(TAG, editText.text.toString())
            }

        val buttonT: Button = findViewById(R.id.button_timber)
        buttonT.setOnClickListener {

            Timber.v(editText.text.toString())
        }

    }
}