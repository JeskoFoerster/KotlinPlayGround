import de.thkoeln.kohls.ap2.listen_kommentiert.SimpleLinkedList

fun main() {
    var linkedList = SimpleLinkedList()

}

class Person(var vorname: String, var nachname:String, alter:Int = 0, var hobbies: List<String>){

    //Klausr/Praktikum! berechnete eigenschaften!
    var alter = alter
        set(alter){
            if(this.alter > alter) throw Exception("Yeet")
            if(this.alter < 0) throw Exception("Yeet")
            field = alter
        }
        get() = field

    var volljährig: Boolean = false
        get() = alter >= 18


    fun gibAlter() = alter

    override fun toString(): String {
        return "$vorname $nachname"
    }

    fun isAdult2() = alter>= 18

    fun has_hobby(potentialHobby:String):Boolean{
        return hobbies.contains(potentialHobby)
    }
}