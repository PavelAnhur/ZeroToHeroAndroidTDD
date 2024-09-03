package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.changeButton)
        textView = findViewById(R.id.titleTextView)
        button.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
        val hideButton: Button = findViewById(R.id.hideButton)
        hideButton.setOnClickListener {
            textView.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textToSave = textView.text.toString()
        outState.putString("textTitleView", textToSave)
        outState.putInt("textViewVisibility", textView.visibility)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getString("textTitleView")
        textView.visibility = savedInstanceState.getInt("textViewVisibility")
    }
}