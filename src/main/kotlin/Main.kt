import de.thkoeln.kohls.ap2.listen_kommentiert.SimpleLinkedList

fun main() {
    println("Please enter numbers line by line (enter an empty line to finish):")

    val numbers = mutableListOf<Int>()
    while (true) {
        val line = readLine()
        if (line.isNullOrBlank()) {
            break
        }
        numbers.add(line.toInt())
    }

    var count = 0
    val numberChunks = mutableListOf<MutableList<Int>>()
    var accumulator = mutableListOf<Int>()

    for (number in numbers) {
        accumulator.add(number)
        count++

        if (count == 1000) {
            numberChunks.add(accumulator)
            accumulator = mutableListOf() // Reset accumulator
            count = 0
        }
    }

    // Add the last chunk if it has any remaining numbers
    if (accumulator.isNotEmpty()) {
        numberChunks.add(accumulator)
    }

    for (chunk in numberChunks) {
        val csvString = chunk.joinToString(separator = ",")
        println(csvString)
    }
}

