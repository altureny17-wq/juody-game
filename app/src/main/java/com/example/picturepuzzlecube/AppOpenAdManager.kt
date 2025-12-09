package com.example.picturepuzzlecube

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import java.util.Date

class AppOpenAdManager {

    private var appOpenAd: AppOpenAd? = null
    private var isLoadingAd = false
    var isShowingAd = false

    private var loadTime: Long = 0

    // TODO: REPLACE WITH YOUR REAL APP OPEN AD UNIT ID
    private val AD_UNIT_ID = "ca-app-pub-3940256099942544/9257395921" // Test ID
    private val LOG_TAG = "AppOpenAdManager"

    fun loadAd(context: Context) {
        if (isLoadingAd || isAdAvailable()) {
            return
        }

        isLoadingAd = true
        val request = AdRequest.Builder().build()
        AppOpenAd.load(
            context, AD_UNIT_ID, request,
            object : AppOpenAd.AppOpenAdLoadCallback() {
                override fun onAdLoaded(ad: AppOpenAd) {
                    appOpenAd = ad
                    isLoadingAd = false
                    loadTime = Date().time
                    Log.d(LOG_TAG, "Ad was loaded.")
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    isLoadingAd = false
                    Log.d(LOG_TAG, "Ad failed to load: ${loadAdError.message}")
                }
            })
    }

    private fun isAdAvailable(): Boolean {
        val wasLoadTimeLessThanNHoursAgo = (Date().time - loadTime) < 3600000 * 4
        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo
    }

    fun showAdIfAvailable(activity: Activity) {
        if (isShowingAd) {
            Log.d(LOG_TAG, "The ad is already showing.")
            return
        }

        if (!isAdAvailable()) {
            Log.d(LOG_TAG, "The ad is not ready yet.")
            loadAd(activity)
            return
        }

        appOpenAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                appOpenAd = null
                isShowingAd = false
                Log.d(LOG_TAG, "Ad dismissed fullscreen content.")
                loadAd(activity)
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                appOpenAd = null
                isShowingAd = false
                Log.d(LOG_TAG, "Ad failed to show fullscreen content: ${adError.message}")
                loadAd(activity)
            }

            override fun onAdShowedFullScreenContent() {
                Log.d(LOG_TAG, "Ad showed fullscreen content.")
            }
        }
        isShowingAd = true
        appOpenAd?.show(activity)
    }
}