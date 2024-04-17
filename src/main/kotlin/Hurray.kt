
fun main(){
    hurray()
    investment()
    val word:String = sortAlphabetic()
    println(word)
    testList()
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