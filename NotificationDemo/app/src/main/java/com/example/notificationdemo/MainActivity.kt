package com.example.notificationdemo


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val channelID = "com.example.notificationdemo.channel1"
    private var notificationManager: NotificationManager? = null
    private val KEY_REPLY = "key_reply"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel(channelID, "DemoChannel", "It's demo")

        button.setOnClickListener {
            displayNotfication()
        }
    }

    private fun displayNotfication() {
        val notificationId = 33
        val tapResultIntent = Intent(this, SecondActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
                this,
                0,
                tapResultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        val remoteInput: RemoteInput = RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Tell us why you did not complete your course?")
            build()
        }

        val replyAction: NotificationCompat.Action = NotificationCompat.Action.Builder(
                0,
                "REPLY",
                pendingIntent
        ).addRemoteInput(remoteInput)
                .build()


        val detailsIntent = Intent(this, DetailsActivity::class.java)
        val pendingDetailsIntent: PendingIntent = PendingIntent.getActivity(
                this,
                0,
                detailsIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        val detailsAction: NotificationCompat.Action =
                NotificationCompat.Action.Builder(0, "Details", pendingDetailsIntent).build()


        val settingsIntent = Intent(this, SettingsActivity::class.java)
        val pendingSettingsIntent: PendingIntent = PendingIntent.getActivity(
                this,
                0,
                settingsIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        val settingsAction: NotificationCompat.Action =
                NotificationCompat.Action.Builder(0, "Settings", pendingSettingsIntent).build()


        val notification = NotificationCompat.Builder(this@MainActivity, channelID)
                .setContentTitle("Udemy")
                .setContentText("You have one uncompleted course waiting for you.")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(detailsAction)
                .addAction(settingsAction)
                .addAction(replyAction)
                .build()
        notificationManager?.notify(notificationId, notification)

    }

    private fun createNotificationChannel(channelID: String, name: String, channelDescription: String) {
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(channelID, name, importance).apply {
            description = channelDescription
        }
        notificationManager?.createNotificationChannel(channel)

    }

}
