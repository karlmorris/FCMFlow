package edu.temple.fcmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity(), MyApplication.FCMCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance()
            .token.addOnSuccessListener { Log.d("Current token", it) }


        FirebaseMessaging.getInstance()
            .subscribeToTopic("convoyId")

        (application as MyApplication).registerCallback(this)

    }

    override fun messageReceived(message: String) {
        Log.d("Message in activity", message)
    }

    override fun onDestroy() {
        super.onDestroy()

        (application as MyApplication).registerCallback(null)
    }
}