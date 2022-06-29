package com.example.complexevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var progressStatus = 0
    private var handler = Handler (Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val progressBar: ProgressBar = findViewById(R.id.progressBar2)
        val textView: TextView = findViewById(R.id.textView)
        val editText: EditText = findViewById(R.id.editText)
        val checkBox: CheckBox = findViewById(R.id.checkBox)
        button.setOnClickListener {
            Thread(Runnable {
                handler.post {
                    if (progressStatus < 100) {
                        progressStatus +=10
                        progressBar.progress = progressStatus
                    }
                    if (checkBox.isChecked) {
                        textView.text = editText.text
                    }
                }
            }).start()
        }
    }
}