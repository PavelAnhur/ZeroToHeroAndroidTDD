package ru.easycode.zerotoheroandroidtdd

import java.lang.IllegalStateException
import kotlin.text.toInt

interface Count {
    fun increment(number: String): String

    class Base(private val step: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
        }

        override fun increment(number: String): String {
            val num = number.toInt()
            return (num + step).toString()
        }
    }
}