package com.pradeep.notificationsdemo.demo

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import android.graphics.drawable.BitmapDrawable
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import com.pradeep.notificationsdemo.MainActivity
import com.pradeep.notificationsdemo.R

class DemoNotifications(private val context: Context) {

    private val notificationManager=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(title:String,body:String){

        val intent= Intent(context,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent= PendingIntent.getActivity(
            context,
            1,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notification=NotificationCompat
            .Builder(context,context.getString(R.string.Demo_Notification_ID))
            .setSmallIcon(R.drawable.ic_baseline_adb_24)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(
            1,
            notification
        )
    }

    fun showImageNotification(title:String,body:String){

        val intent= Intent(context,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent= PendingIntent.getActivity(
            context,
            2,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )



        val bigPictureBitmap = ContextCompat.getDrawable(context, R.drawable.wojak)?.toBitmap()
        val bigLargeIconBitmap = ContextCompat.getDrawable(context, R.drawable.wojak)?.toBitmap()
        val bigPictureStyle = NotificationCompat.BigPictureStyle()
            .setBigContentTitle("Foo Big Content Title")
            .setSummaryText("Foo summary text")
            .bigLargeIcon(bigLargeIconBitmap)
            .bigPicture(bigPictureBitmap)






        val notification=NotificationCompat
            .Builder(context,context.getString(R.string.Demo_Notification_ID))
            .setSmallIcon(R.drawable.ic_baseline_adb_24)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
            .setContentIntent(pendingIntent)
            .setStyle(bigPictureStyle)
            .build()

        notificationManager.notify(
            2,
            notification
        )
    }



}