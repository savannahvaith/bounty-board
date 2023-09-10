package com.bignerdranch.nyethack

import kotlin.system.exitProcess

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
    /*
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

     */

    // Using Objects etc.
    narrate("Welcome to NyetHack!")
    val playerName = promptHeroName()
    player = Player(playerName)

    Game.play()
}

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

object Game{

    private val worldMap = listOf(
        listOf(TownSquare(), Tavern(), Room("Back Room")),
        listOf(MonsterRoom("A Long Corridor"), Room("A Generic Room")),
        listOf(MonsterRoom("The Dungeon"))
    )
    private var currentRoom: Room = worldMap[0][0]
    private var currentPosition = Coordinate(0, 0)
    init {
        narrate("Welcome, adventurer")
        val mortality = if (player.isImmortal) "an immortal" else "a mortal"
        narrate("${player.name}, $mortality, has ${player.healthPoints} health points")
    }

    private class GameInput(arg: String? ){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }
        fun processCommand() = when (command.lowercase()){
            "fight" -> fight()
            "move" -> {
                val direction = Direction.values()
                    .firstOrNull {it.name.equals(argument, ignoreCase = true)}
                if(direction != null) move(direction) else narrate("Idk what direction that is")
            }
            else -> narrate("I'm not sure what you're trying to do.")
        }
    }

    fun play() {
        while (true) {
            narrate("${player.name}, of ${player.homeTown} ${player.title}, is in the ${currentRoom.description()}")
            currentRoom.enterRoom()
            print("> Enter your command: ")
            GameInput(readLine()).processCommand()
        }
    }

    fun move(direction: Direction) {
        val newPosition = direction.updateCoordinate(currentPosition)
        val newRoom = worldMap.getOrNull(newPosition.y)?.getOrNull(newPosition.x)
        if (newRoom != null) {
            narrate("The hero moves ${direction.name}")
            currentPosition = newPosition
            currentRoom = newRoom
        } else {
            narrate("You cannot move ${direction.name}")
        }
    }

    fun fight() {
        val monsterRoom = currentRoom as? MonsterRoom
        val currentMonster = monsterRoom?.monster
        if (currentMonster == null) {
            narrate("There's nothing to fight here")
            return }
        while (player.healthPoints > 0 && currentMonster.healthPoints > 0) {
            player.attack(currentMonster)
            if (currentMonster.healthPoints > 0) {
                currentMonster.attack(player)
            }
            Thread.sleep(1000)
        }
        if (player.healthPoints <= 0) {
            narrate("You have been defeated! Thanks for playing")
            exitProcess(0)
        } else {
            narrate("${currentMonster.name} has been defeated")
            monsterRoom.monster = null
        }
    }

}