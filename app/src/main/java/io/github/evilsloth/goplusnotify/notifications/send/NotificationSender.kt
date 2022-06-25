package io.github.evilsloth.goplusnotify.notifications.send

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import io.github.evilsloth.goplusnotify.R
import io.github.evilsloth.goplusnotify.notifications.GoPlusNotification

private const val CHANNEL_ID = "7843"

class NotificationSender constructor(private val context: Context) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    init {
        createNotificationChannel()
    }

    fun send(notification: GoPlusNotification) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(context.getString(R.string.app_name))
            .setContentText(context.getText(notification.text))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setTimeoutAfter(10000)

        with(NotificationManagerCompat.from(context)) {
            notify(1234, builder.build())
        }

    }

    private fun createNotificationChannel() {
        val name = context.getString(R.string.notification_channel_name)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance)
        notificationManager.createNotificationChannel(channel)
    }

}