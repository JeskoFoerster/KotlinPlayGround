import java.util.Date

open class WorkUnit(val name: String, val decription:String, val deadline: Date, var status: Status = Status.TODO){
    fun changeStatus(status: Status){
        this.status = status
    }

    open fun getSummary():String{
        return "Die Aufgabe ’${name}’ mit der Beschreibung ’${decription}’ muss bis $deadline erledigt\n" +
                "sein . Der aktuelle Status ist $status."
    }
}
class Task( name: String, decription:String,  deadline: Date,  status: Status = Status.TODO, steps:MutableList<String>, estimatedTime:Int) : WorkUnit(name, decription, deadline, status){

    var steps = steps
    var estimatedTime = estimatedTime
        set(value) {field = if (value>0) value else throw Exception("time machine needed")}

    fun addStep(step : String){
        steps.add(step)
    }

    override fun getSummary(): String {
        return "${super.getSummary()} Die Arbeitsschritte sind: ${steps.joinToString(", ")}. Es wird voraussichtlich $estimatedTime Minuten dauern."
    }

}

class Project( name: String,  decription:String,  deadline: Date, var tasks: MutableList<Task>,  status: Status = Status.TODO) :WorkUnit(name, decription, deadline, status) {
    val progress: Double
        get() {
            var done: Int = 0
            for(task in tasks){
                if (task.status == Status.DONE)done++
            }
            return if (tasks.isNotEmpty()) done.toDouble() / tasks.size else 0.0
        }


    override fun getSummary(): String {
        return "${super.getSummary()} Das Projekt beinhaltet ${tasks.size} Aufgaben. Aktuell sind ${progress * 100}% abgeschlossen."
    }

    fun addTask(task:Task){
        if(task.deadline < deadline){
            throw Exception("Deadline der Task darf nicht dach dem Projekt sein!")
        }
        tasks.add(task)
    }
}

enum class Status{
    TODO,
    DONING,
    DONE
}

fun main() {

    val clean = Task("Bad säubern", "nervig", Date(), status = Status.TODO, mutableListOf("Sachen holen", "putzen"), 80)
    val clean2 = Task("Dachboden säubern", "weniger nervig", Date(), status = Status.TODO, mutableListOf("Sachen holen", "Spinnen verschäuschen"), 80)
    clean.estimatedTime = 70
    clean.addStep("wegräumen")

    val cleanProject = Project("clean", "Sauber machen", Date(), mutableListOf(clean, clean2))
    println(cleanProject.tasks[0].steps[2])
    println(cleanProject.progress)
    cleanProject.tasks[0].status = Status.DONE
    println(cleanProject.progress)
}