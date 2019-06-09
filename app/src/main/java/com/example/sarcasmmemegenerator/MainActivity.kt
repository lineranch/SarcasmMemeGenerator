package com.example.sarcasmmemegenerator

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var enterText: TextView
    lateinit var clipboard: ClipboardManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterText = findViewById(R.id.enterText)

        clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    }

    fun copyText(view: View) {
        val message: String = enterText.text.toString().toLowerCase()
        var result: StringBuilder = StringBuilder(message)

        for (i in 0..message.length - 1) {
            if (i % 2 != 0)
                result.setCharAt(i, result.get(i).toUpperCase())

        }
        val clip = ClipData.newPlainText("text", result)
        clipboard.primaryClip = clip

        displayToast("Copied")
    }

    fun displayToast(message: String) {
        var toast: Toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.show()
    }
}
