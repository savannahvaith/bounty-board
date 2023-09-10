package com.bignerdranch.nyethack
//val player = Player("Jason", "Jacksonville", 100, false)
//val player = Player("Jason")

// Late Int Variable - initialise later
lateinit var player: Player
fun main(){

    // Functions
    /*
    narrate("A Hero enters the town of Kronstadt. What's their name?") { message ->
        // Prints in yellow
        "\u001b[33;1m$message\u001b[0m"
    }
    // Require to prevent issues
//    val heroName = readLine() ?: ""
    val heroName = readLine()
    require(heroName != null && heroName.isNotEmpty()){
        "The hero must have a name"
    }

    changeNarratorMood()
    narrate("$heroName, ${createTitle(heroName)} heads to the town square")

     */

    // Lists and Sets
    /*
    heroName = promptHeroName()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
    visitTavern()
     */

    // Classes
    /*
    narrate("${player.name} is ${player.title} ")
    player.changeName("aurelia")
    narrate("${player.name}, ${player.title} heads to the town square ")
    visitTavern()
    player.castFireBall()

     */

    // Calling the primary constructor
    // Late initialisation of name
    narrate("Welcome to NyetHack!")
    val playerName = promptHeroName()
    player = Player(playerName)
    player.prophesize()

    // instantiate the class
    var currentRoom: Room = Tavern()

    val mortality = if(player.isImmortal) "an immortal" else "a mortal"

    narrate("${player.name}, of ${player.homeTown} ${player.title}, is in the ${currentRoom.description()}")
    narrate("${player.name}, $mortality has ${player.healthPoints} health points  ")
    currentRoom.enterRoom()
//    visitTavern()
    player.castFireBall()
    player.prophesize()
}

// Moved to Player Class
/*
private fun createTitle(name: String): String{
    return when{
        name.all { it.isDigit() } -> "The Identifiable"
        name.none { it.isLetter() } -> "The Witness Protection Member"
        name.count {it.lowercase() in "aeiou"} > 4 -> "The Master of Vowels"
        else -> "The renowned Hero"
    }
}

 */

private fun promptHeroName(): String{
    narrate("A hero enters the town of Kronstadt. What's their name?"){ message ->
        // Prints in yellow
        "\u001b[33;1m$message\u001b[0m"
    }
//    val input = readLine()
//    require(input !=null && input.isNotEmpty()) {
//        "The hero must have a name"
//    }
//    return input
    return "Madrigal"
}