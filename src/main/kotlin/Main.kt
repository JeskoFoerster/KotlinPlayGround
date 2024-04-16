fun main() {
    println("Entered Main!")

    //take input
    println("Please enter id of the program:")
    val userInput = readlnOrNull()
    val number = userInput?.toInt()

    //decide what program to run
    when(number) {
        1 -> Test.main()
        2 -> println("Program2")
        else -> println("Unknown id. Please Enter a valid id.")
    }

    println("Main Terminated!")
}