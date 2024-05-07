import java.util.Date

open class WorkUnit(){

}
class Task(val name: String, val decription:String, val deadline: Date, steps:MutableList<String>, estimatedTime:Int,var status: Status = Status.TODO) {

    var steps = steps
    var estimatedTime = estimatedTime
        set(value) {field = if (value>0) value else throw Exception("time machine needed")}


    fun addStep(step : String){
        steps.add(step)
    }
}

class Project(val name: String, val decription:String, val deadline: Date, var tasks: List<Task>, status: Status = Status.TODO) {
    val progress: Double
        get() {
            var done: Int = 0
            for(task in tasks){
                if (task.status == Status.DONE)done++
            }
            return if (tasks.isNotEmpty()) done.toDouble() / tasks.size else 0.0
        }
}

enum class Status{
    TODO,
    DONING,
    DONE
}

fun main() {

    val clean = Task("Bad säubern", "nervig", Date(), mutableListOf("Sachen holen", "putzen"), 80)
    val clean2 = Task("Dachboden säubern", "weniger nervig", Date(), mutableListOf("Sachen holen", "Spinnen verschäuschen"), 80)
    clean.estimatedTime = 70
    clean.addStep("wegräumen")

    val cleanProject = Project("clean", "Sauber machen", Date(), mutableListOf(clean, clean2))
    println(cleanProject.tasks[0].steps[2])
    println(cleanProject.progress)
    cleanProject.tasks[0].status = Status.DONE
    println(cleanProject.progress)
}