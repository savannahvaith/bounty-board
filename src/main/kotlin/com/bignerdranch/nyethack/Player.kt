package com.bignerdranch.nyethack
class Player {
    var name = "madrigal"
        get() = field.replaceFirstChar { it.uppercase() }
        private set(value) {
            field = value.trim()
        }
    val title: String
        get() = when {
            name.all { it.isDigit() } -> "The Identifiable"
            name.none { it.isLetter() } -> "The Witness Protection Member"
            name.count {it.lowercase() in "aeiou"} > 4 -> "The Master of Vowels"
            else -> "The renowned Hero"
        }
    fun castFireBall(numFireBalls: Int = 2){
        narrate("A glass of Fireball springs into existence (x$numFireBalls")
    }

    fun changeName(newName: String){
        narrate("$name legally changes their name to $newName")
        name = newName
    }
}