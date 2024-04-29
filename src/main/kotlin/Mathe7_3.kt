import kotlin.random.Random

fun main() {
    val mathMap = mutableMapOf<Int, Int>()

    val numberOfRuns = 50000000
    for (i in 0 until numberOfRuns) {
        val dice1 = Random.nextInt(1, 7)
        val dice2 = Random.nextInt(1, 7)
        val dice3 = Random.nextInt(1, 7)
        val sum = dice1 + dice2 + dice3
        val counter = mathMap[sum] ?: 0
        mathMap[sum] = counter + 1
    }

    // Order the map by values in descending order
    val sortedMap = mathMap.entries.sortedByDescending { it.key }

    // Print the results
    for ((sum, count) in sortedMap) {
        println("$sum: ${count*100/numberOfRuns.toDouble()}")
    }
}