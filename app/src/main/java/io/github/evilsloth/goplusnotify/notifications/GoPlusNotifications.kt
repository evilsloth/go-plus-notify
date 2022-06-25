package io.github.evilsloth.goplusnotify.notifications

import io.github.evilsloth.goplusnotify.R
import io.github.evilsloth.goplusnotify.notifications.listen.NotificationPatterns

object GoPlusNotifications {

    val actionNotifications = listOf(
        GoPlusNotification(
            pattern = NotificationPatterns.POKESTOP_SPINNED,
            text = R.string.pokestop_spinned,
            enabledSettingsKey = "POKESTOP_SPINNED"
        ),
        GoPlusNotification(
            pattern = NotificationPatterns.POKEMON_CAUGHT,
            text = R.string.pokemon_caught,
            enabledSettingsKey = "POKEMON_CAUGHT"
        ),
        GoPlusNotification(
            pattern = NotificationPatterns.POKEMON_FLED,
            text = R.string.pokemon_fled,
            enabledSettingsKey = "POKEMON_FLED"
        ),
        GoPlusNotification(
            pattern = NotificationPatterns.OUT_OF_POKEBALLS,
            text = R.string.out_of_pokeballs,
            enabledSettingsKey = "OUT_OF_POKEBALLS"
        ),
        GoPlusNotification(
            pattern = NotificationPatterns.BAG_FULL,
            text = R.string.bag_full,
            enabledSettingsKey = "BAG_FULL"
        ),
        GoPlusNotification(
            pattern = NotificationPatterns.POKEMON_SPACE_FULL,
            text = R.string.pokemon_space_full,
            enabledSettingsKey = "POKEMON_SPACE_FULL"
        )
    )

    val disconnectNotification = GoPlusNotification(
        pattern = NotificationPatterns.EMPTY,
        text = R.string.disconnected,
        enabledSettingsKey = "DISCONNECTED"
    )

}