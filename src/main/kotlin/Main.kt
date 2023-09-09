// Declaring a compile-time constant

const val HERO_NAME = "Madrigal"

// Chapter 1
/*
fun main() {
    // Re writable Variables
    println("Hello, World!")
    var playerLevel = 4
    // This will not work - due to explicitly type specified as int.
//    var playerLevel: Int = "Thirty-Two"
    println(playerLevel)

    println("The hero embarks on her journey to locate the enchanted sword.")
//    playerLevel = 5
//    playerLevel += 1
    playerLevel++
    println(playerLevel)

    // Read only variables
    println("The hero announces her presence to the world.")
    // Type declaration here is redundant. option + shift + enter to optimise
//    val heroName: String = "Madrigal"
//    val heroName = "Madrigal"
    println(HERO_NAME)

    // Error: Val cannot be reassigned
//    heroName = "Estragon"

}
*/

// Refactoring
/*
 fun main() {
    println("The hero announces her presence to the world.")
    println(HERO_NAME)
    var playerLevel = 4
    println(playerLevel)
    val hasBefriendedBarbarians = true
    val hasAngeredBarbarians = false
    val playerClass = "paladin"
    val quest: String = if (playerLevel == 1) {
        "Meet Mr. Bubbles in the land of soft things."
    } else if (playerLevel in 2..5) {
        // Check whether diplomacy is an option
        val canTalkToBarbarians = !hasAngeredBarbarians &&
                (hasBefriendedBarbarians || playerClass == "barbarian")
            if (canTalkToBarbarians) {
                "Convince the barbarians to call off their invasion."
            } else {
                "Save the town from the barbarian invasions."
            }
    } else if (playerLevel == 6) "Locate the enchanted sword."
    else if (playerLevel == 7) "Recover the long-lost artifact of creation."
    else if (playerLevel == 8)  "Defeat Nogartse, bringer of death and eater of worlds."
    else "There are no quests right now."

    println("The hero approaches the bounty board. It reads $quest")
    println("Time passes...")
    println("The hero returns from her quest.")
    playerLevel += 1
    println(playerLevel)
}

*/

// Using when loops
/*
fun main() {
    println("The hero announces her presence to the world.")
    println(HERO_NAME)
    var playerLevel = 4
    println(playerLevel)
    val hasBefriendedBarbarians = true
    val hasAngeredBarbarians = false
    val playerClass = "paladin"
    val quest: String = when (playerLevel){
    1 -> "Meet Mr. Bubbles in the land of soft things."
    in 2.. 5 -> {
    // Check whether diplomacy is an option
    val canTalkToBarbarians = !hasAngeredBarbarians && (hasBefriendedBarbarians || playerClass == "barbarian")
    if(canTalkToBarbarians) "Convince the barbarians to call off their invasion" else "Save the town from barbarian invasions."
    }
    6 -> "Locate the enchanted sword"
    7 -> "Recover the long-lost artifact of creation"
    8 -> "Defeat Nogartse, bringer of death and eater of worlds"
    else -> "There are no quests right now."
    }

    println("The hero approaches the bounty board. It reads $quest")
    println("Time passes...")
    println("The hero returns from her quest.")
    playerLevel += 1
    println(playerLevel)
}
*/

// Extracting into Functions
//var playerLevel = 5
//fun main() {
//    println("The hero announces her presence to the world.")
//    println(HERO_NAME)
//    println(playerLevel)
//    readBountyBoard()
//    println("Time passes...")
//    println("The hero returns from her quest.")
//    playerLevel += 1
//    println(playerLevel)
//    readBountyBoard()
//}
//
//private fun obtainQuest(
//    playerLevel: Int,
//    playerClass: String = "Paladin",
//    hasBefriendedBarbarians: Boolean = true,
//    hasAngeredBarbarians: Boolean = false,
//): String =  when (playerLevel) {
//        1 -> "Meet Mr. Bubbles in the land of soft things."
//        in 2..5 -> {
//            // Check whether diplomacy is an option
//            val canTalkToBarbarians = !hasAngeredBarbarians && (hasBefriendedBarbarians || playerClass == "barbarian")
//            if (canTalkToBarbarians) "Convince the barbarians to call off their invasion" else "Save the town from barbarian invasions."
//        }
//        6 -> "Locate the enchanted sword"
//        7 -> "Recover the long-lost artifact of creation"
//        8 -> "Defeat Nogartse, bringer of death and eater of worlds"
//        else -> "There are no quests right now."
//    }
//
//private fun readBountyBoard(){
//    println("The hero approaches the bounty board. It reads:")
////    println(obtainQuest(playerLevel, "paladin", true, false))
//    println(obtainQuest(playerLevel))
//}

// Strings
/*
var playerLevel = 0
fun main() {
    println("$HERO_NAME announces her presence to the world")
    println("What level is $HERO_NAME ?")
    val playerLevelInput = readLine()!!
    playerLevel = if (playerLevelInput.matches("""\d+""".toRegex())) {
        playerLevelInput.toInt()
    } else {
        1 }
    println("$HERO_NAME's level is: $playerLevel")
    readBountyBoard()
    println("Time passes...")
    println("$HERO_NAME returns from her quest.")
    playerLevel += 1
    println(playerLevel)
    readBountyBoard()
}

private fun obtainQuest(
    playerLevel: Int,
    playerClass: String = "Paladin",
    hasBefriendedBarbarians: Boolean = true,
    hasAngeredBarbarians: Boolean = false,
): String =  when (playerLevel) {
    1 -> "Meet Mr. Bubbles in the land of soft things."
    in 2..5 -> {
        // Check whether diplomacy is an option
        val canTalkToBarbarians = !hasAngeredBarbarians && (hasBefriendedBarbarians || playerClass == "barbarian")
        if (canTalkToBarbarians) "Convince the barbarians to call off their invasion" else "Save the town from barbarian invasions."
    }
    6 -> "Locate the enchanted sword"
    7 -> "Recover the long-lost artifact of creation"
    8 -> "Defeat Nogartse, bringer of death and eater of worlds"
    else -> "There are no quests right now."
}

private fun readBountyBoard(){
    println(
        """
        |$HERO_NAME approaches the bounty board. It reads:
        | "${obtainQuest(playerLevel).replace("Nogartse", "xxxxxxxx")}" """.trimMargin()
    )
}
*/

// Nullability
var playerLevel = 0
fun main() {
    println("$HERO_NAME announces her presence to the world")
    println("What level is $HERO_NAME ?")
    playerLevel = readLine()?.toIntOrNull() ?: 0
    println("$HERO_NAME's level is: $playerLevel")
    readBountyBoard()
    println("Time passes...")
    println("$HERO_NAME returns from her quest.")
    playerLevel += 1
    println(playerLevel)
    readBountyBoard()
}

private fun obtainQuest(
    playerLevel: Int,
    playerClass: String = "Paladin",
    hasBefriendedBarbarians: Boolean = true,
    hasAngeredBarbarians: Boolean = false,
): String? {
    // using preconditions
//    require(playerLevel > 0) {
//        "The player's level must be at least 1."
//    }
    // Using custom classes
    if (playerLevel <= 0) {
        throw InvalidPlayerLevelException()
    }

    return when(playerLevel){
        1 -> "Meet Mr. Bubbles in the land of soft things."
        in 2..5 -> {
            // Check whether diplomacy is an option
            val canTalkToBarbarians = !hasAngeredBarbarians && (hasBefriendedBarbarians || playerClass == "barbarian")
            if (canTalkToBarbarians) "Convince the barbarians to call off their invasion" else "Save the town from barbarian invasions."
        }
        6 -> "Locate the enchanted sword"
        7 -> "Recover the long-lost artifact of creation"
        8 -> "Defeat Nogartse, bringer of death and eater of worlds"
        else -> null
}
}

private fun readBountyBoard(){
    // Option 1. Safe Calls (?)
    /*
    val quest: String? = obtainQuest(playerLevel)
    val censoredQuest = quest?.replace("Nogartse", "xxxxxxxx")
    if (censoredQuest != null) {
        println(
            """
         |$HERO_NAME approaches the bounty board. It reads:
         | "$censoredQuest"
            """.trimMargin()
        )
    }
    */

    // Option 2a. Using Let
    /*
    val quest: String? = obtainQuest(playerLevel)
    val censoredQuest = quest?.replace("Nogartse", "xxxxxxxx")
    censoredQuest?.let {
        println(
            """
         |$HERO_NAME approaches the bounty board. It reads:
         | "$censoredQuest"
            """.trimMargin()
        )
    }
    */

    // Option 2b. Using Let Refactored
    /*
    val quest: String? = obtainQuest(playerLevel)
    val message: String = quest?.replace("Nogartse", "xxxxxxxx")
        ?.let { censoredQuest ->
            """
         |$HERO_NAME approaches the bounty board. It reads:
         | "$censoredQuest"
            """.trimMargin()
    } ?: "$HERO_NAME approaches the board, but it's blank."
    println(message)

    */

    // Option 3. Try Catch
    /*
    try {
        val quest: String? = obtainQuest(playerLevel)
        val message: String = quest?.replace("Nogartse", "xxxxxxxx")
            ?.let { censoredQuest ->
                """
         |$HERO_NAME approaches the bounty board. It reads:
         | "$censoredQuest"
            """.trimMargin()
            } ?: "$HERO_NAME approaches the board, but it's blank."
        println(message)

    } catch (e: Exception){
        println("$HERO_NAME can't read what's on the bounty board.")
    }
    */

    // Option 4. Using try/catch as an expression
    val message: String = try {
        val quest: String? = obtainQuest(playerLevel)
        quest?.replace("Nogartse", "xxxxxxxx")
            ?.let { censoredQuest ->
                """
         |$HERO_NAME approaches the bounty board. It reads:
         | "$censoredQuest"
            """.trimMargin()
            } ?: "$HERO_NAME approaches the board, but it's blank."
    } catch (e: Exception){
        "$HERO_NAME can't read what's on the bounty board."
    }
    println(message)
}

// Custom Exceptions
class InvalidPlayerLevelException() :
    IllegalArgumentException("Invalid player level (must be at least 1).")