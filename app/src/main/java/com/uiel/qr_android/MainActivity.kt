package com.uiel.qr_android

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.uiel.qr_android.ui.theme.QRAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QRAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        AndroidView(
                            modifier = Modifier.fillMaxSize().weight(1f),
                            factory = {
                                WebView(it).apply {
                                    webViewClient = WebViewClient()
                                    settings.javaScriptEnabled = true
                                    settings.setSupportMultipleWindows(true)
                                    settings.javaScriptCanOpenWindowsAutomatically = true
                                    settings.domStorageEnabled = true

                                    loadUrl(BuildConfig.TERMS_URL)
                                }
                            },
                            update = {
                                it.loadUrl(BuildConfig.TERMS_URL)
                            },
                        )
                        BannersAds()
                    }
                }
            }
        }
    }
}
