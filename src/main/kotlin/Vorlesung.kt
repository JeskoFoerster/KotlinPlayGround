open class Funiture(
    var color:String = "Brown",
    var material: String = "Wood",
    open var width:Int,
    open var height:Int,
){
    fun move(){
        println("i like to move it move it")
    }
}

class Table(color:String,
    material: String,
    width: Int,
    height: Int,
    legs: Int):Funiture(color, material, width, height){
    override var width = 300
    var legs = legs
        set(value) {
            field = if(value>0) value else 0
        }
    }

class Chair(color:String,
            material: String,
            width: Int,
            height: Int):Funiture(color, material, width, height){
                var legs = 4
                fun sit(){
                    println("sitting")
                }
            }

class Cupboard(color:String,
            material: String,
            width: Int,
            height: Int):Funiture(color, material, width, height){}

fun main(){
    val table = Table("Brown","Wood",40, 120, 5)
    println(table.legs)
    table.legs = -4
    println(table.legs)
    table.move()

}