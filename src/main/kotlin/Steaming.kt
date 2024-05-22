import java.net.ProtocolFamily

abstract class Subsciption(){
    abstract val benefits : List<String>
    abstract fun calcPrice(): Double
}

interface Subscribable{
    val benefits : List<String>
    fun calcPrice(): Double
}

class FreeTrail(): Subscribable{
    override val benefits: List<String>
        get() = listOf("Werbung", "720p")

    override fun calcPrice(): Double {
        return 0.0
    }
}

class SinglePlan(val paymentInterval: PaymentInterval) : Subscribable{
    override val benefits: List<String>
        get() = listOf("Downloads")

    override fun calcPrice(): Double {
        val paymentIntervalMonth = when(paymentInterval){
            PaymentInterval.MONTHLY -> 1
            PaymentInterval.QUATERLY -> 3
            PaymentInterval.YEARLY -> 12
        }
        return 15.0 * (1-paymentIntervalMonth/100)
    }
}

class FamilyPlan(val familyMembers: List<String>):Subscribable{
    override val benefits: MutableList<String>
        get() {
            val result = mutableListOf("4k", "max 7 user")
            if(familyMembers.size >= 5){
                result.add("Bilder")
            }
            return result
        }

    override fun calcPrice(): Double {
        return 50.0
    }
}

data class Customer(val name :String, val id:String, var subscription: Subscribable)

class SteamingService(val name:String, val customers: MutableList<Customer>) {

    fun foo() {
        var trail = 0
        var single = 0
        var fam = 0



        for (customer in customers) {
            when (customer.subscription) {
                is FreeTrail -> trail++
                is SinglePlan -> single++
                is FamilyPlan -> fam++
            }
        }
    }
}

enum class PaymentInterval{
    MONTHLY,
    QUATERLY,
    YEARLY
}
fun main(){
    val sp = SinglePlan(PaymentInterval.YEARLY)
    println(sp.benefits)

    val c = Customer("Max", "2ed4", sp)
    println(c)
}