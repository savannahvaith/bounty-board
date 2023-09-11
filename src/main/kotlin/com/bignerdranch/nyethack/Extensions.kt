import com.bignerdranch.nyethack.Coordinate
import com.bignerdranch.nyethack.Direction
import com.bignerdranch.nyethack.Room

fun String.addEnthusiasm(enthusiasmLevel: Int = 2) = this +"!".repeat(enthusiasmLevel)
val String.numVowels
        get() = count { it.lowercase() in "aeiou"}

fun Room?.orEmptyRoom(name: String  = "the middle of nowhere"): Room = this ?: Room(name)

fun <T> T.print(): T {
    println(this)
    return this
}
operator fun List<List<Room>>.get(coordinate: Coordinate) = getOrNull(coordinate.y)?.getOrNull(coordinate.x)

infix fun Coordinate.move(direction: Direction) = direction.updateCoordinate(this)