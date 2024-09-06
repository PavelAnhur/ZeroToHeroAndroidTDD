package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var incrementButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countTextView = findViewById<TextView>(R.id.countTextView)
        incrementButton = findViewById<Button>(R.id.incrementButton)
        val count = Count.Base(step = 2, max = 4)
        incrementButton.setOnClickListener {
            val uiState = count.increment(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        val incButtonState = incrementButton.isEnabled
        outState.putBoolean("incButtonState", incButtonState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val incButtonState = savedInstanceState.getBoolean("incButtonState")
        incrementButton.isEnabled = incButtonState
    }
}