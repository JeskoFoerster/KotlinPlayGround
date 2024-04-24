fun main() {
    val hobbies:List<String> = listOf("Handball", "Fußball")
    val susi = Person("Susi", "Sonne", 8, hobbies)
    val lars = Person("Lars", "Lustig", -23, hobbies)


    println(lars)
    lars.isAdult()
    lars.has_hobby("Handball")

}

class Person(var vorname: String, var nachname:String, alter:Int = 0, var hobbies: List<String>){

    var alter = alter
        set(alter){
            if(this.alter > alter) throw Exception("Yeet")
            if(this.alter < 0) throw Exception("Yeet")
            field = alter
        }
        get() = field

    var volljährig: Boolean = false
        get() = alter >= 18

        set(value){
            if(alter>18){
                field = true
                alter = 18
            }
        }


    fun gibAlter() = alter

    override fun toString(): String {
        return "$vorname $nachname"
    }

    fun isAdult():Boolean{
        return alter >= 18
    }

    fun isAdult2() = alter>= 18

    fun has_hobby(potentialHobby:String):Boolean{
        return hobbies.contains(potentialHobby)
    }
}