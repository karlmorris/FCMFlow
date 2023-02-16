package edu.temple.fcmapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage

class FCMService : FirebaseMessagingService() {


    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("New token received", token)
        // store token locally
        // set a flag stating token not sent to server
        // register token with server
        // if success, change flag
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val myMessage = message.data.get("payload").toString()


        (application as MyApplication).getCallBack()?.run {
            messageReceived(myMessage)
        }

    }


}