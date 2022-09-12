package com.pradeep.notificationsdemo

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()

        //practice set
        createDemoNotification()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel=NotificationChannel(
                CounterNotificationService.COUNTER_CHANNEL_ID,
                "Counter",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description="This is used for increment counter notification."

            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createDemoNotification(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel= NotificationChannel(
                getString(R.string.Demo_Notification_ID),
                "Demo Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description="This is a demo channel to work on notifications."
            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}