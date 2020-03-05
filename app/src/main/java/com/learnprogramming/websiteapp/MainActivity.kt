package com.learnprogramming.websiteapp

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebSettings.RenderPriority.HIGH
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var mwebView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mwebView = findViewById<View>(R.id.webView) as WebView
        mwebView!!.settings.javaScriptEnabled = true

        mwebView!!.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        val webSettings = mwebView!!.settings
        webSettings.javaScriptEnabled = true
        webSettings.setRenderPriority(HIGH)
        //webSettings.cacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK)
        webSettings.setAppCacheEnabled(true)
        webSettings.domStorageEnabled = true
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSettings.useWideViewPort = true
        webSettings.savePassword = true
        webSettings.saveFormData = true
        webSettings.setEnableSmoothTransition(true)
        mwebView!!.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        mwebView!!.loadUrl("https://developer.android.com/")
    }

    override fun onBackPressed() {
        if (mwebView!!.canGoBack()){
            mwebView!!.goBack()
        }
        else
        {
            super.onBackPressed()
        }
    }
}
