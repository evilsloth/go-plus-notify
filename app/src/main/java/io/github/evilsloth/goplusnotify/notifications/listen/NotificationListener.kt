package io.github.evilsloth.goplusnotify.notifications.listen

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import io.github.evilsloth.goplusnotify.notifications.GoPlusNotifications
import io.github.evilsloth.goplusnotify.notifications.send.NotificationSender
import io.github.evilsloth.goplusnotify.settings.SettingsRepository

private const val GO_PACKAGE_NAME = "com.nianticlabs.pokemongo"

class NotificationListener : NotificationListenerService() {

    private lateinit var notificationSender: NotificationSender
    private lateinit var settingsRepository: SettingsRepository

    override fun onCreate() {
        notificationSender = NotificationSender(applicationContext)
        settingsRepository = SettingsRepository(applicationContext)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        if (sbn?.packageName == GO_PACKAGE_NAME) {
            val notificationText = sbn.notification.extras.getString("android.text") ?: ""

            GoPlusNotifications.actionNotifications
                .filter { it.isEnabled(settingsRepository) }
                .filter { it.matches(notificationText) }
                .forEach { notificationSender.send(it) }
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        if (sbn?.packageName == GO_PACKAGE_NAME) {
            val notificationText = sbn.notification.extras.getString("android.text") ?: ""

            if (isGoNotification(notificationText)) {
                notificationSender.send(GoPlusNotifications.disconnectNotification)
            }
        }
    }

    private fun isGoNotification(notificationText: String): Boolean {
        return GoPlusNotifications.actionNotifications.any { it.matches(notificationText) } or
                GoPlusNotifications.disconnectNotification.matches(notificationText)
    }
}