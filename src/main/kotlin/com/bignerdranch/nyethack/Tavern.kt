package com.bignerdranch.nyethack

import java.io.File
import kotlin.random.Random
import kotlin.random.nextInt

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"

private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames = setOf("Ironfoot", "FernsWorth", "Baggins", "Downstrider")

private val menuData = File("data/tavern-menu-data.txt")
//    .takeIf { it.exists() } // else return null.
    .readText()
    .split("\n")
    .map { it.split(",")}

private val menuItems = menuData.map{ (_, name, _) -> name}

private val menuItemPrices = menuData.associate { (_, name, price) ->
    name to price.toDouble()
}

private val menuItemTypes = menuData.associate { (type, name, _)  ->
    name to type
}


fun visitTavern(){
    /*
    narrate("$heroName enters $TAVERN_NAME")

    val patrons = listOf("Eli", "Mordoc", "Sophie")
    println(patrons[0])

    val eliMessage = if (patrons.contains("Eli")) {
        "$TAVERN_MASTER says: Eli is in the back playing cards"
    } else{
        "$TAVERN_MASTER says: Eli isn't here"
    }
    println(eliMessage)

    val otherMessage = if(patrons.containsAll(listOf("Sophie","Mordoc"))) {
        "$TAVERN_MASTER says: Sophie and Mordoc are seated by the stew kettle"
    }else{
        "$TAVERN_MASTER says: Sophie and Mordoc aren't with eachother right now"
    }

    println(otherMessage)
     */

    // Changing a list's contents

    /*
    narrate("$heroName enters $TAVERN_NAME")
    val patrons = mutableListOf("Eli", "Mordoc", "Sophie")
    println(patrons[0])
    val eliMessage = if (patrons.contains("Eli")) {
        "$TAVERN_MASTER says: Eli is in the back playing cards"
    } else{
        "$TAVERN_MASTER says: Eli isn't here"
    }
    println(eliMessage)
    val otherMessage = if(patrons.containsAll(listOf("Sophie","Mordoc"))) {
        "$TAVERN_MASTER says: Sophie and Mordoc are seated by the stew kettle"
    }else{
        "$TAVERN_MASTER says: Sophie and Mordoc aren't with eachother right now"
    }
    println(otherMessage)

    narrate("Eli leaves the tavern")
    patrons.remove("Eli")
    narrate("Alex enters the tavern")
    patrons.add("Alex")
    println(patrons)
    narrate("Alex (VIP) enter's the tavern")
    patrons[0] = "Alexis"
    println(patrons)

    */

    // Iteration and reading a file.

    /*
    narrate("$heroName enters $TAVERN_NAME")
    val patrons = mutableListOf("Eli", "Mordoc", "Sophie")
    println(patrons[0])
    val eliMessage = if (patrons.contains("Eli")) {
        "$TAVERN_MASTER says: Eli is in the back playing cards"
    } else{
        "$TAVERN_MASTER says: Eli isn't here"
    }
    println(eliMessage)
    val otherMessage = if(patrons.containsAll(listOf("Sophie","Mordoc"))) {
        "$TAVERN_MASTER says: Sophie and Mordoc are seated by the stew kettle"
    }else{
        "$TAVERN_MASTER says: Sophie and Mordoc aren't with eachother right now"
    }
    println(otherMessage)

//    for(patron in patrons){
//        println("Good evening, $patron")
//    }

//    patrons.forEach {
//        println("Good evening, $it")
//    }

    patrons.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index+1} in the line")
        placeOrder(patron, menuItems.random())
    }

    // Reading a file into a list
    menuData.forEachIndexed { index, data ->
        println("$index : $data")

    }
     */

    // Generating random patrons

    /*
    narrate("$heroName enters $TAVERN_NAME")
    narrate("Thee are several items for sale:")
    narrate(menuItems.joinToString())

    val patrons: MutableSet<String> = mutableSetOf()
    while(patrons.size < 10){
        patrons += "${firstNames.random()} ${lastNames.random()}"
    }

    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())
    repeat(3) {
        placeOrder(patrons.random(), menuItems.random())
    }

     */

    // Creating a Map
    /*
    narrate("$heroName enters $TAVERN_NAME")
    narrate("Thee are several items for sale:")
    narrate(menuItems.joinToString())

    val patrons: MutableSet<String> = mutableSetOf()
    val patronGold = mapOf(
        TAVERN_MASTER to 86.00,
        heroName to 4.50
    )
    while(patrons.size < 10){
        patrons += "${firstNames.random()} ${lastNames.random()}"
    }
    println(patronGold)
    println(patronGold["Madrigal"])
    println(patronGold["Taernyl"])
    println(patronGold["Eli"])

    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())
    repeat(3) {
        placeOrder(patrons.random(), menuItems.random())
    }

     */

    // Mutable Map
    /*
    narrate("$heroName enters $TAVERN_NAME")
    narrate("Thee are several items for sale:")
    narrate(menuItems.joinToString())

    val patrons: MutableSet<String> = mutableSetOf()
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.00,
        heroName to 4.50
    )
    while(patrons.size < 5){
        val patronName = "${firstNames.random()} ${lastNames.random()}"
        patrons += patronName
        patronGold += patronName to 6.0
    }

    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())

    println(patronGold)
    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    println(patronGold)


     */

    // Iterating through a map ++ Functional Programming
    /*
    narrate("$heroName enters $TAVERN_NAME")
    narrate("Thee are several items for sale:")
    narrate(menuItems.joinToString())

    val patrons: MutableSet<String> = mutableSetOf()
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.00,
        heroName to 4.50
    )
    while(patrons.size < 5){
        val patronName = "${firstNames.random()} ${lastNames.random()}"
        patrons += patronName
        patronGold += patronName to 6.0
    }

    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())



    /*
      val favouriteItems = patrons.map { getFavouriteMenuItems(it)}
      println("Favourite Items: $favouriteItems")

        we can use a flatmap to flatten the response from
        [[Bite of Lembas Bread], [Pickled Camel Hump, Bite of Lembas Bread], [Iced Boilermaker], [Shirley's Temple, Iced Boilermaker], [Goblet of LaCroix]]
        to:
        [Pickled Camel Hump, Iced Boilermaker, Shirley's Temple, Hard Day's Work Ice Cream, Bite of Lembas Bread, Hard Day's Work Ice Cream, Goblet of LaCroix]
     */

//        val favouriteItems = patrons.flatMap { getFavouriteMenuItems(it)}
//        println("Favourite Items: $favouriteItems")

    // picking a random item
    val itemOfDay = patrons.flatMap { getFavouriteMenuItems(it) }.random()
    narrate("The item of the day is: $itemOfDay")

    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    displayPatronBalances(patronGold)
     */

    // Filtering Data
    /*
    narrate("$heroName enters $TAVERN_NAME")
    narrate("Thee are several items for sale:")
    narrate(menuItems.joinToString())

    val patrons: MutableSet<String> = mutableSetOf()
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.00,
        heroName to 4.50
    )
    while(patrons.size < 5){
        val patronName = "${firstNames.random()} ${lastNames.random()}"
        patrons += patronName
        patronGold += patronName to 6.0
    }

    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())

    val itemOfDay = patrons.flatMap { getFavouriteMenuItems(it) }.random()
    narrate("The item of the day is: $itemOfDay")

    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    displayPatronBalances(patronGold)

    val departingPatrons: List<String> = patrons.filter { patron ->
        patronGold.getOrDefault(patron, 0.0) < 4.0 }

    patrons -= departingPatrons
    patronGold -= departingPatrons

    departingPatrons.forEach { patron -> narrate("$heroName sees $patron departing the tavern")}

    narrate("There are still some patrons in the tavern")
    narrate(patrons.joinToString())

     */

    // Combining Data

    /*
    narrate("$heroName enters $TAVERN_NAME")
    narrate("Thee are several items for sale:")
    narrate(menuItems.joinToString())

    val patrons: MutableSet<String> = firstNames.shuffled()
        .zip(lastNames.shuffled()) { firstName, lastName -> "$firstName $lastName"
        }.toMutableSet()
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.00,
        heroName to 4.50,
//        * is the spread operator
        *patrons.map { it to 6.00}.toTypedArray()
    )
    patrons.forEach {patronName ->
        patronGold += patronName to 6.0
    }

    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())

    val itemOfDay = patrons.flatMap { getFavouriteMenuItems(it) }.random()
    narrate("The item of the day is: $itemOfDay")

    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    displayPatronBalances(patronGold)

    val departingPatrons: List<String> = patrons.filter { patron ->
        patronGold.getOrDefault(patron, 0.0) < 4.0 }

    patrons -= departingPatrons
    patronGold -= departingPatrons

    departingPatrons.forEach { patron -> narrate("$heroName sees $patron departing the tavern")}

    narrate("There are still some patrons in the tavern")
    narrate(patrons.joinToString())
     */

    // Scope Functions
/*
    narrate("$heroName enters $TAVERN_NAME")
    narrate("Thee are several items for sale:")
    narrate(menuItems.joinToString())

    val patrons: MutableSet<String> = firstNames.shuffled()
        .zip(lastNames.shuffled()) { firstName, lastName -> "$firstName $lastName"
        }.toMutableSet()

    val greeting = patrons.firstOrNull()?.let {
        "$it walks over to Madrigal and say's, " +
                "\"Hi I'm $it. Welcome to Kronstadt!\""
    } ?: "Nobody greets Madrigal because the tavern is empty"

    /*
    Another way to write the above - is to use if/else -- alternative to L334 - L337

    val friendlyPatron = patrons.firstOrNull()
    val greeting = if(friendlyPatron != null) {
        "$friendlyPatron walks over to Madrigal and says blahblahblah"
    } else{
        "Nobody greets cause it's empty"
    }
    */

    val tavernPlaylist = mutableListOf("Folk","RnB","Jazz")
    val nowPlaying:String = tavernPlaylist.run {
        shuffle() // shuffles the playlist
        "${first()} is currently playing in the tavern"
    }

    println(greeting + nowPlaying)
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.00,
        heroName to 4.50,
//        * is the spread operator
        *patrons.map { it to 6.00}.toTypedArray()
    )
    patrons.forEach {patronName ->
        patronGold += patronName to 6.0
    }

    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())

    val itemOfDay = patrons.flatMap { getFavouriteMenuItems(it) }.random()
    narrate("The item of the day is: $itemOfDay")

    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    displayPatronBalances(patronGold)

    patrons.filter { patron -> patronGold.getOrDefault(patron,0.0) < 4.0 }
        .also { departingPatrons ->
            patrons -= departingPatrons
            patronGold -= departingPatrons
        }.forEach { patron ->
            narrate("$heroName sees $patron departing the tavern")
        }
    narrate("There are still some patrons in the tavern")
    narrate(patrons.joinToString())

 */

    // Classes

    narrate("${player.name} enters $TAVERN_NAME")
    narrate("Thee are several items for sale:")
    narrate(menuItems.joinToString())

    val patrons: MutableSet<String> = firstNames.shuffled()
        .zip(lastNames.shuffled()) { firstName, lastName -> "$firstName $lastName"
        }.toMutableSet()

    val greeting = patrons.firstOrNull()?.let {
        "$it walks over to Madrigal and say's, " +
                "\"Hi I'm $it. Welcome to Kronstadt!\""
    } ?: "Nobody greets Madrigal because the tavern is empty"

    /*
    Another way to write the above - is to use if/else -- alternative to L334 - L337

    val friendlyPatron = patrons.firstOrNull()
    val greeting = if(friendlyPatron != null) {
        "$friendlyPatron walks over to Madrigal and says blahblahblah"
    } else{
        "Nobody greets cause it's empty"
    }
    */

    val tavernPlaylist = mutableListOf("Folk","RnB","Jazz")
    val nowPlaying:String = tavernPlaylist.run {
        shuffle() // shuffles the playlist
        "${first()} is currently playing in the tavern"
    }

    println(greeting + nowPlaying)
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.00,
        player.name to 4.50,
//        * is the spread operator
        *patrons.map { it to 6.00}.toTypedArray()
    )
    patrons.forEach {patronName ->
        patronGold += patronName to 6.0
    }

    narrate("${player.name} sees several patrons in the tavern:")
    narrate(patrons.joinToString())

    val itemOfDay = patrons.flatMap { getFavouriteMenuItems(it) }.random()
    narrate("The item of the day is: $itemOfDay")

    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    displayPatronBalances(patronGold)

    patrons.filter { patron -> patronGold.getOrDefault(patron,0.0) < 4.0 }
        .also { departingPatrons ->
            patrons -= departingPatrons
            patronGold -= departingPatrons
        }.forEach { patron ->
            narrate("${player.name} sees $patron departing the tavern")
        }
    narrate("There are still some patrons in the tavern")
    narrate(patrons.joinToString())

}

/*
private fun placeOrder(patronName: String, menuItemName: String){
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
}

 */

//Updating values in map values
private fun placeOrder(
    patronName: String,
    menuItemName: String,
    patronGold: MutableMap<String,Double>
){
    val itemPrice = menuItemPrices.getValue(menuItemName)
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    if(itemPrice <= patronGold.getOrDefault(patronName, 0.0)){
        val action = when(menuItemTypes[menuItemName]){
            "shandy", "elixr" -> "pours"
            "meal" -> "serves"
            else -> "hands"
        }
        narrate("$TAVERN_MASTER $action $patronName a $menuItemName")
        narrate("$patronName pays $TAVERN_MASTER $itemPrice gold")
        patronGold[patronName] = patronGold.getValue(patronName) - itemPrice
        patronGold[TAVERN_MASTER] = patronGold.getValue(TAVERN_MASTER) + itemPrice
    }else{
        narrate("$TAVERN_MASTER says \"you need more coin for a $menuItemName\"")
    }
}

private fun displayPatronBalances(patronGold: MutableMap<String, Double>){
    narrate("${player.name} intuitively knows how much money each patron has")
    patronGold.forEach{ (patron, balance) ->
        narrate("$patron has ${"%.2f".format(balance)} gold")
    }
}

private fun getFavouriteMenuItems(patron: String): List<String> {
    return when (patron){
        "Alex Ironfoot" -> menuItems.filter { menuItem ->
            menuItemTypes[menuItem]?.contains("dessert") == true
        }
        else -> menuItems.shuffled().take(Random.nextInt(1..2))
    }
}