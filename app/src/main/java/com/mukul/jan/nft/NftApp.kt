package com.mukul.jan.nft

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class NftApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}