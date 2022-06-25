package io.github.evilsloth.goplusnotify.notifications

import io.github.evilsloth.goplusnotify.settings.SettingsRepository

class GoPlusNotification(
    private val pattern: Regex,
    val text: Int,
    private val enabledSettingsKey: String
) {

    fun matches(sourceText: String): Boolean {
        return pattern.matches(sourceText)
    }

    fun isEnabled(settingsRepository: SettingsRepository): Boolean {
        return settingsRepository.isNotificationEnabled(enabledSettingsKey)
    }

    fun setEnabled(settingsRepository: SettingsRepository, enabled: Boolean) {
        settingsRepository.setNotificationEnabled(enabledSettingsKey, enabled)
    }

}