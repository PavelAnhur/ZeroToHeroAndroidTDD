package ru.easycode.zerotoheroandroidtdd

import java.lang.IllegalStateException
import kotlin.text.toInt

interface Count {
    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max <= 0) throw IllegalStateException("max should be positive, but was $max")
            if (max < step) throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val num = number.toInt()
            val text = (num + step).toString()
            val textToInt = text.toInt()
            val uiState: UiState =
                if (textToInt == max
                    || textToInt > max
                    || textToInt + step > max
                ) UiState.Max(text)
                else UiState.Base(text)
            return uiState
        }
    }
}