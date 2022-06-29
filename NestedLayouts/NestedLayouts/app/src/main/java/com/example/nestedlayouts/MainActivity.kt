package com.example.nestedlayouts

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter: Int = 1
    private var currentTextView: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
        val textViews = Array<TextView>(9) { i ->
            findViewById(
                resources.getIdentifier(
                    "textView${i + 1}",
                    "id",
                    packageName
                )
            )
        }
        button.setOnClickListener {
            counter++
            currentTextView = (currentTextView+1)%3

            for (i in textViews.indices){
                if (i%3==currentTextView){
                    textViews[i].text = counter.toString()
                }
                else {
                    textViews[i].text = ""
                }
            }

        }
    }
}