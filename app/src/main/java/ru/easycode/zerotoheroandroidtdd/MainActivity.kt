package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(step = 2, max = 4, min = 0)

    private lateinit var uiState: UiState
    private lateinit var textView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        decrementButton = findViewById(R.id.decrementButton)
        incrementButton = findViewById(R.id.incrementButton)

        incrementButton.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView, incrementButton, decrementButton)
        }
        decrementButton.setOnClickListener {
            uiState = count.decrement(textView.text.toString())
            uiState.apply(textView, incrementButton, decrementButton)
        }

        if (savedInstanceState == null) {
            uiState = count.initial(textView.text.toString())
        }
        uiState = count.initial(textView.text.toString())
        uiState.apply(textView, incrementButton, decrementButton)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(UI_STATE, uiState as Serializable?)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(UI_STATE, UiState::class.java) as UiState
        uiState.apply(textView, incrementButton, decrementButton)
    }

    companion object {
        private const val UI_STATE = "uiState"
    }
}