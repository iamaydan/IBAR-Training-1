package com.example.notificationdemo

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        receiveInput()
    }

    private fun receiveInput() {
        val KEY_REPLY = "key_reply"
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null) {
            val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            result_text_view.text = inputString

            val channelID = "com.example.notificationdemo.channel1"
            val notificationId = 33

            val repliedNotification = NotificationCompat.Builder(this, channelID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("Submitted")
                .build()
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationId, repliedNotification)


        }
    }
}
