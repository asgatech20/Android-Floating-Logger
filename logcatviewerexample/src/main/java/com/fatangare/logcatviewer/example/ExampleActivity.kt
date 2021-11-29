package com.fatangare.logcatviewer.example

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fatangare.logcatviewer.utils.LogcatViewer

class ExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
    }

    fun onShowLoggerClicked(view: View) {
        LogcatViewer.showLogcatLoggerView(this)
    }

}