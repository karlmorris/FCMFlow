package edu.temple.fcmapp

import android.app.Application

class MyApplication : Application() {

    var messageCallback: FCMCallback? = null

    interface FCMCallback {
        fun messageReceived(message: String)
    }

    fun registerCallback (callback: FCMCallback?) {
        messageCallback = callback
    }

    fun getCallBack () : FCMCallback? {
        return messageCallback
    }

}