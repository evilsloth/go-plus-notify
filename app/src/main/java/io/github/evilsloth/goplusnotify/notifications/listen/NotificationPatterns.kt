package io.github.evilsloth.goplusnotify.notifications.listen

object NotificationPatterns {

    val POKESTOP_SPINNED = Regex("^You received \\d+ items? from the PokéStop.$")
    val POKEMON_CAUGHT = Regex("^You caught a Pokémon!$")
    val POKEMON_FLED = Regex("^The Pokémon fled!$")
    val OUT_OF_POKEBALLS = Regex("^You're out of Poké Balls.$")
    val BAG_FULL = Regex("^Your Bag is full, so you couldn't receive any items.$")
    val POKEMON_SPACE_FULL = Regex("^Your have no more room for Pokémon.$")
    val EMPTY = Regex("^$")

}