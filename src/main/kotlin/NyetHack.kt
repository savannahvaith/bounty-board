var heroName: String = ""
fun main(){
    // Functions
//    narrate("A Hero enters the town of Kronstadt. What's their name?") { message ->
//        // Prints in yellow
//        "\u001b[33;1m$message\u001b[0m"
//    }
//    // Require to prevent issues
////    val heroName = readLine() ?: ""
//    val heroName = readLine()
//    require(heroName != null && heroName.isNotEmpty()){
//        "The hero must have a name"
//    }
//
//    changeNarratorMood()
//    narrate("$heroName, ${createTitle(heroName)} heads to the town square")

    // Lists and Sets
    heroName = promptHeroName()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
    visitTavern()
}

private fun createTitle(name: String): String{
    return when{
        name.all { it.isDigit() } -> "The Identifiable"
        name.none { it.isLetter() } -> "The Witness Protection Member"
        name.count {it.lowercase() in "aeiou"} > 4 -> "The Master of Vowels"
        else -> "The renowned Hero"
    }
}

private fun promptHeroName(): String{
    narrate("A hero enters the town of Kronstadt. What's their name?"){ message ->
        // Prints in yellow
        "\u001b[33;1m$message\u001b[0m"
    }
    println("Madrigal")
    return "Madrigal"
}