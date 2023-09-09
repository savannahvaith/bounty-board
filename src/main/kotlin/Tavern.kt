import java.io.File

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"

private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames = setOf("Ironfoot", "FernsWorth", "Baggins", "Downstrider")

private val menuData = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")

private val menuItems = List(menuData.size) { index ->
    val(type, name, price) = menuData[index].split(",")
    name
}

private val menuItemPrices: Map<String, Double> = List(menuData.size) { index ->
    val (_, name, price) = menuData[index].split(",")
    name to price.toDouble()
}.toMap()
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

    // Iterating through a map
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


    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    displayPatronBalances(patronGold)
}


//private fun placeOrder(patronName: String, menuItemName: String){
//    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
//    narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
//}

//Updating values in map values
private fun placeOrder(
    patronName: String,
    menuItemName: String,
    patronGold: MutableMap<String,Double>
){
    val itemPrice = menuItemPrices.getValue(menuItemName)
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    if(itemPrice <= patronGold.getOrDefault(patronName, 0.0)){
        narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
        narrate("$patronName pays $TAVERN_MASTER $itemPrice gold")
        patronGold[patronName] = patronGold.getValue(patronName) - itemPrice
        patronGold[TAVERN_MASTER] = patronGold.getValue(TAVERN_MASTER) + itemPrice
    }else{
        narrate("$TAVERN_MASTER says \"you need more coin for a $menuItemName\"")
    }
}

private fun displayPatronBalances(patronGold: MutableMap<String, Double>){
    narrate("$heroName intuitively knows how much money each patron has")
    patronGold.forEach{ (patron, balance) ->
        narrate("$patron has ${"%.2f".format(balance)} gold")
    }
}