fun main() {

    println("Entered Main!")

    //take input
    println("Please enter id of the program:")
    val userInput: String = readln()
    val number : Int = userInput.toInt()

    //decide what program to run
    when(number) {
        1 -> Test.main()
        2 -> println("Program2")
        else -> println("Unknown id. Please Enter a valid id.")
    }

    println("Main Terminated!")
}