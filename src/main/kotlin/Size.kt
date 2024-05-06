fun main(){
    //client code
    val tableHight = Size()
    tableHight.cm = -23.6
    tableHight.inch = 23.6
    println("Höhe: ${tableHight.cmAsString}")
}
class Size() {

    var badNumbers = 0
        private set(value) {
            field = value
        }
        get() {
            return  field
        }
    var cm : Double = 0.0
        set(value: Double) {
            if (value <  0.0){
                badNumbers++
                field = -value
            }
            field = value

        }
        get() {
            return field
        }

    // berechnetes Feld: wichtig für abfragen!
    var inch : Double
        set(value: Double){
            this.cm = value * 2.54
        }

        get(): Double {
            return this.cm / 2.54
        }
    val cmAsString: String
        get() {
            return "$cm cm"
        }
}