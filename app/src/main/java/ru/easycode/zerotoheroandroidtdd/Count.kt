package ru.easycode.zerotoheroandroidtdd

import java.lang.IllegalStateException
import kotlin.text.toInt

interface Count {
    fun increment(number: String): UiState
    fun initial(number: String): UiState
    fun decrement(number: String): UiState

    class Base(private val step: Int, private val max: Int, private val min: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max <= 0) throw IllegalStateException("max should be positive, but was $max")
            if (min < 0) throw IllegalStateException("min should be positive, but was $min")
            if (min > max) throw IllegalStateException("min should be less than max")
            if (max < step) throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val num = number.toInt()
            val text = (num + step).toString()
            return initial(text)
        }

        override fun decrement(number: String): UiState {
            val num = number.toInt()
            val text = (num - step).toString()
            return initial(text)
        }

        override fun initial(number: String): UiState {
            val textToInt = number.toInt()
            return if (textToInt == max
                || textToInt > max
                || textToInt + step > max
            ) UiState.Max(number)
            else if (textToInt == min
                || textToInt < min
                || textToInt - step < min
            ) UiState.Min(number)
            else UiState.Base(number)
        }


    }
}