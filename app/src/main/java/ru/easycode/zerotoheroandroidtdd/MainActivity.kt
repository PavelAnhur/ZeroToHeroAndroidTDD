package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var rootLayout: LinearLayout
    private lateinit var removeButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        removeButton = findViewById(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)
        rootLayout = findViewById(R.id.rootLayout)
        removeButton.setOnClickListener {
            rootLayout.removeView(textView)
            removeButton.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("rootLayoutChildCount", rootLayout.childCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val childCount = rootLayout.childCount
        val rootLayoutChildCount = savedInstanceState.getInt("rootLayoutChildCount")
        if (childCount != rootLayoutChildCount) {
            rootLayout.removeView(textView)
        }
        removeButton.isEnabled = false
    }
}