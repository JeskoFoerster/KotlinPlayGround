data class Hurray(val str1: String, val int2: Int)

class Adress(val street:String, val number:Int)
fun main(){
    /*
    val test : Hurray = Hurray("test", 2)
    println(test)
    val(name, value ) = test
    println("Name: $name Wert: $value")

    // Create a mutable array of integers
    val mutableArray = mutableListOf<Int>()

    // Add elements to the mutable array
    mutableArray.add(1)
    mutableArray.add(2)
    mutableArray.add(3)

    // Print the mutable array
    println("Mutable Array: $mutableArray")


    var addresse1 : Adress = Adress("Steinstraße", 1)
    println(addresse1)
    println("${addresse1.street} and ${addresse1.number}")

    var address2 = addresse1
    address2.number == 2

    println(addresse1.number)
    println(address2.number)


    val zahl1 = 1.0
    val zahl2 = 4
    val bigger = if (zahl1 > zahl2) "Hi" else zahl2
    println(bigger::class)


    val w = "100".toDouble()
    println(w)

    val test : Hurray = Hurray("test", 2)
    println(test)
    val(name, value ) = test
    println("Name: $name Wert: $value")
    hurray()
    investment()
    val word:String = sortAlphabetic()
    println(word)
    testList()
    */
}

fun hurray(){
    for(i in 1..100){
        if(i % 3==0 || i % 7==0){
            println("Hurray")
        }else{
            println(i)
        }
    }
}

fun investment(){
    println("Enter your investment:")
    var input: String = readln()
    val startCapital = input.toDouble()

    println("Enter your annual return in percent(7% == 0.07):")
    input = readln()
    val annualReturn = input.toDouble()

    var capital: Double = startCapital
    while(capital<2*startCapital){
        capital += capital * annualReturn
        println(capital)
    }
}

fun sortAlphabetic():String{
    println("Enter 2 Words:")
    var input = readln()
    val firstWord = input.toString()
    input = readln()
    val secWord = input.toString()

    //possible to lift return out, but I'm not comfortable with this.
    if(firstWord < secWord){
        return firstWord
    }
    else{
        return secWord
    }
}

fun testList(){
    val comics = listOf("Test", "Test1")
    println(comics[1])
}
