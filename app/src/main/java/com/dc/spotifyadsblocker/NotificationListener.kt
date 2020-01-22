package com.dc.spotifyadsblocker

import android.content.Intent
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log


class NotificationListener : NotificationListenerService() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)

        Log.v("Hurray!", "Gotcha!")

        val packageName = sbn?.packageName
        val extras = sbn!!.notification.extras
        val title = extras.getString("android.title")
        val text = extras.getCharSequence("android.text").toString()

        val x=5
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)

    }
}
