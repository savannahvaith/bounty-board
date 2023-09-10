package com.bignerdranch.nyethack

import kotlin.random.Random

// Using Lambdas
//    val narrationModifier: () -> String = {
//        val numExclamationPoints = 3
//        message.uppercase() + "!".repeat(numExclamationPoints)
//    }
//    println(narrationModifier())

    // Adding a message Parameter

//    val narrationModifier: (String) -> String = { message ->
//        val numExclamationPoints = 3
//        message.uppercase() + "!".repeat(numExclamationPoints)
//    }
//    println(narrationModifier(message))

    // Using the IT keyword when we have a single argument as above

//    val narrationModifier: (String) -> String = {
//        val numExclamationPoints = 3
//        it.uppercase() + "!".repeat(numExclamationPoints)
//    }

    // Using type inference

//    val narrationModifier = { message:String ->
//        val numberOfExclamationPoints = 3
//        message.uppercase()+"!".repeat(numberOfExclamationPoints)
//    }

// Effective Lambdas

/*
    var narrationModifier: (String) -> String = { it }
fun narrate(
    message: String
) {
    println(narrationModifier(message))
}
*/
    fun changeNarratorMood() {
        val mood: String
        val modifier: (String) -> String

        when(Random.nextInt(1,4)) {
            1 -> {
                mood = "loud"
                modifier = { message ->
                    val numberOfExclamationPoints = 3
                    message.uppercase()+"!".repeat(numberOfExclamationPoints)
                }
            }
            2 -> {
                mood = "tired"
                modifier = { message ->
                    message.lowercase().replace(" ", "... ")
                }
            }
            3 -> {
                mood = "unsure"
                modifier = { message ->
                    "$message?"
                }
            }
            else -> {
                mood = "professional"
                modifier = { message ->
                    "$message."
                }
            }
        }

        narrationModifier = modifier
        narrate("The narrator begins to feel $mood")
    }


// Defining a function that accepts a function

    var narrationModifier: (String) -> String = { it }
fun narrate(
    message: String,
    modifier: (String) -> String = { narrationModifier(it) }
) {
    println(modifier(message))
}
