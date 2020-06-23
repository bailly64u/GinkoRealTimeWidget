package com.louis.app.ginkorealtimewidget.util

import android.util.Log
import kotlin.system.measureTimeMillis

class L {
    companion object {
        fun v(message: String, clue: String = "Default") {
            Log.v("________$clue _______", message)
        }

        fun e(throwable: Throwable) {
            Log.e("_______________", throwable.message)
        }

        fun thread(currentMethod: String) {
            Log.e("________Running $currentMethod in thread________", Thread.currentThread().name)
        }

        fun timestamp(methodName: String, doThings: () -> Unit) {
            val timestamp = measureTimeMillis(doThings)
            Log.v("________Time to execute $methodName ________", timestamp.toString())
        }
    }
}
