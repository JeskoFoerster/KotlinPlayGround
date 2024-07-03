fun main(){
    Game.play()
    Game.score = 32
    print(Student.semester)
    print(Student.Administartion.semester)

    throw Yeet()

}
class Animal

object Game{
    var score = 0
    val animals = mutableListOf<Animal>()
    fun play(){}

}

interface Movable{
    fun left()
    fun right()
}

object TheHero:Movable{ //thw
    override fun left() {
        TODO("Not yet implemented")
    }

    override fun right() {
        TODO("Not yet implemented")
    }
}

class Student(val vorname:String, val name:String){
    val matrikelnummer : Int = TODO()
    private var unniqueId : Int = 0
    companion object Administartion{
        private var unniqueId : Int = 0
        fun generateUniqueId() = unniqueId++
        var semester = "SoSe2024"
    }

}

