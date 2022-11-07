package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val b=intent.getStringExtra("link")
        Log.d("intent", "onCreate: "+b)

        val url=b

        web.webViewClient = WebViewClient()
        url?.let { web.loadUrl(it) }
    }
}