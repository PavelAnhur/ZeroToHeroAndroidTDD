package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.countTextView)
        val incrementButton = findViewById<View>(R.id.incrementButton)
        incrementButton.setOnClickListener {
            textView.text =
                (Count.Base(step = 2).increment(number = textView.text.toString())).toString()
        }
    }
}