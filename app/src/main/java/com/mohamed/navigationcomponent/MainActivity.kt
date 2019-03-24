package com.mohamed.navigationcomponent

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavDeepLinkBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendFakeNotification()
    }

    private fun sendFakeNotification() {
        // Get an instance of the Notification Manager
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Create a channel for > API 27
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel0", "name", importance)
            notificationManager.createNotificationChannel(channel)
        }

        // Create the argument for the notification. Converted to bundle to pass it in the argument
        val args = BoatDetailsFragmentArgs.Builder(2).build().toBundle()

        // Pending intent with deep link (BoatFragmentArgs was generated previously by safeArgumentGenerator)
        val pendingIntent = NavDeepLinkBuilder(this)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.boatDetailsFragment)
            .setArguments(args)
            .createPendingIntent()

        // Creating the notification
        val notification = Notification.Builder(this)
            .setContentTitle("Now on sale!")
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.speed_boat_blue)
            .setContentIntent(pendingIntent)

        // Set the channel id to the notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification.setChannelId("channel0")
        }

        // Call notify() on the notification manager
        notificationManager.notify(0, notification.build())
    }
}
