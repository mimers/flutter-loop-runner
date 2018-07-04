package com.example.flutterlooprunner

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_runner.*

class RunnerActivity : Activity() {
    private val handler = Handler(Looper.getMainLooper())
    private var loop = 0

    private val startRunnable: Runnable = Runnable {
        startActivityForResult(Intent(this, MainActivity::class.java), 1000);
        textView.text = "loop: " + loop++
        handler.postDelayed(restartRunnable, 900)
    }

    private val restartRunnable: Runnable = Runnable {
        finishActivity(1000)
        handler.postDelayed(startRunnable, 300)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runner)
        handler.postDelayed(startRunnable, 500)
    }
}
