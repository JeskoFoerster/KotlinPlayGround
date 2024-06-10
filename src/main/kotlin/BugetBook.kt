fun main(){
    val e1 = Expense("Essen gehen mit Vici", 40.00, SpendingCategory.FOOD, "12.4.2024")
    val e2 = Expense("Investments", 625.0, SpendingCategory.INVESTMENTS, "4.4.2024")
    val g1 = Gain("Gehalt", 580.0, SpendingCategory.OTHER, "1.4.2024")
    val g2 =  Gain("Geschenk", 60.0, SpendingCategory.OTHER, "17.4.2024")

    val bugetBook = BudgetBook("Jesko's Test", mutableListOf(g1, e1, e2))
    bugetBook.addTransAction(g2)
    bugetBook.showExpenses()
}

enum class SpendingCategory{
    FOOD,
    INVESTMENTS,
    OTHER
}

abstract class TransAction(var name:String, var amount: Double, var category: SpendingCategory, var date: String){
    val isImportant: Boolean
        get() = amount > 500

    open fun summerize() = "\"${name}\" wurde am $date getätigt, hat $amount€ gekostet und ist der Kategorie $category zugeordnet."
}
class Expense(name:String, amount: Double, category: SpendingCategory, date: String) : TransAction(name, amount, category, date){
    override fun summerize(): String {
        return "Die Ausgabe ${super.summerize()}"
    }
}

class Gain(name:String, amount: Double, category: SpendingCategory, date: String) : TransAction(name, amount, category, date){
    override fun summerize(): String {
        return "Die Einnahme ${super.summerize()}"
    }
}
class BudgetBook(var name: String = "Mein Haushaltsbuch",val transActions: MutableList<TransAction> = mutableListOf()){
     fun addTransAction (transAction: TransAction) = transActions.add(transAction)

    fun showExpenses(){
        for(transAction in transActions){
            println(transAction.summerize())
        }
    }
}