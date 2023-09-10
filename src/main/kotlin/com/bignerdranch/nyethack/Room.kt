package com.bignerdranch.nyethack

open class Room(
    val name: String,
) {
    protected open val status = "Calm"
    fun description():String = "$name (Currently $status)"

    // needs to be declared as open to be able to be extended in TownSquare
    open fun enterRoom() {
        narrate("There is nothing to do here")
    }

}