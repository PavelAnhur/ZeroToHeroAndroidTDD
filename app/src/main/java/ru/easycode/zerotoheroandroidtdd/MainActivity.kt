package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.actionButton)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)


        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = VISIBLE
            button.postDelayed({
                                   textView.visibility = VISIBLE
                                   progressBar.visibility = View.GONE
                                   button.isEnabled = true
                               }, 3000)
        }
    }
}