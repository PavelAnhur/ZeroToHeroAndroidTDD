package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView

interface UiState {

    fun apply(countTextView: TextView, incrementButton: Button)

    data class Base(private val text: String) : UiState {
        override fun apply(
            countTextView: TextView,
            incrementButton: Button
        ) {
            countTextView.text = text
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(
            countTextView: TextView,
            incrementButton: Button
        ) {
            countTextView.text = text
            incrementButton.isEnabled = false
        }
    }
}