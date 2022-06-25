package io.github.evilsloth.goplusnotify.settings

import android.content.Context
import android.content.SharedPreferences

private const val PREF_STORE_NAME = "GoPlusNotify"

class SettingsRepository(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_STORE_NAME, Context.MODE_PRIVATE)

    fun isNotificationEnabled(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun setNotificationEnabled(key: String, enabled: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(key, enabled)
            .apply()
    }

}