import kotlin.random.Random

fun main(){
    val numbers = listOf(45,6,56,90)
    val max = numbers.maxOf { it }

    val cities = listOf("Hamburg", "köln")
    val bigCity = cities.maxOf { it.length }

    testPredicate {it % 3 == 0}

    loop (7,{println("Hi") })
    println(calc{x:Int, y:Int -> x+y})
    println(calc{x, y -> x-y})

    val c1 = City()

    c1.filter { p:Person -> p.income }
    c1.filter { p:Person -> p.size.toInt() }

}

fun calc(func: (Int, Int)-> Int):Int{

    val a = 5
    val b = 9
    return func(a,b)
}

fun addition(a:Int, b:Int):Int{
    return a+b
}

fun execute(codeSnipet: ()->Unit){
    codeSnipet()
}

fun testPredicate(predicate: (((((Int)))))->Boolean){
    for (i in 0..99){
        if (predicate(i)){
            println("Trifft zu!")
        }
    }
}

fun loop(round :Int = 1, code: ()->Unit) {
    for(i in 0..round-1) code()
}

class Person(val name:String, val income: Int, val size:Double, val home: Apartment)

data class Apartment(val squaremeter:Int)

class City(){
    val person1 = Person("Paul", 8900,6.8, Apartment(4543))
    val person2 = Person("Paul2", 9000,7.8, Apartment(454))
    val person3 = Person("Paul3", 900,5.8, Apartment(453))
    val citizens = mutableListOf<Person>(person1, person2, person3)
    fun richesPerson():Person{
        //code
        return citizens[0]
    }

    fun filter(cond: (Person)->Int):Person{
        var potentialMax = citizens[0]
        for(itr in citizens) if(cond(itr) > cond(potentialMax)) potentialMax = itr
        return potentialMax
    }


}