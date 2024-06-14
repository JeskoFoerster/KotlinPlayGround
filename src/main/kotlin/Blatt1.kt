import java.util.Date
/*
open class WorkUnit(val name: String, val description: String, val deadline: Date, var status: Status = Status.TODO) {
    fun changeStatus(status: Status) {
        this.status = status
    }

    open fun getSummary(): String {
        return "Die Aufgabe ’${name}’ mit der Beschreibung ’${description}’ muss bis $deadline erledigt sein. Der aktuelle Status ist $status."
    }
}

class Task(
    name: String,
    description: String,
    deadline: Date,
    status: Status = Status.TODO,
    steps: MutableList<String>? = null,
    estimatedTime: Int? = null
) : WorkUnit(name, description, deadline, status) {

    var steps: MutableList<String>? = steps
    var estimatedTime: Int? = estimatedTime
        set(value) {
            field = if (value == null || value > 0) value else throw Exception("time machine needed")
        }

    fun addStep(step: String) {
        if (steps == null) {
            steps = mutableListOf()
        }
        steps?.add(step)
    }

    override fun getSummary(): String {
        val stepsDescription = steps?.joinToString(", ") ?: "keine"
        val estimatedTimeDescription = estimatedTime?.toString() ?: "unbekannt"
        return "${super.getSummary()} Die Arbeitsschritte sind: $stepsDescription. Es wird voraussichtlich $estimatedTimeDescription Minuten dauern."
    }
}

class Project(
    name: String,
    description: String,
    deadline: Date,
    var tasks: MutableList<Task>,
    status: Status = Status.TODO
) : WorkUnit(name, description, deadline, status) {
    val progress: Double
        get() {
            var done: Int = 0
            for (task in tasks) {
                if (task.status == Status.DONE) done++
            }
            return if (tasks.isNotEmpty()) done.toDouble() / tasks.size else 0.0
        }

    override fun getSummary(): String {
        return "${super.getSummary()} Das Projekt beinhaltet ${tasks.size} Aufgaben. Aktuell sind ${progress * 100}% abgeschlossen."
    }

    fun addTask(task: Task) {
        if (task.deadline > deadline) {
            throw Exception("Deadline der Task darf nicht nach dem Projekt sein!")
        }
        tasks.add(task)
    }
}

enum class Status {
    TODO,
    DOING,
    DONE
}

fun main() {
    val clean = Task("Bad säubern", "nervig", Date(), status = Status.TODO, steps = mutableListOf("Sachen holen", "putzen"), estimatedTime = 80)
    val clean2 = Task("Dachboden säubern", "weniger nervig", Date(), status = Status.TODO, steps = mutableListOf("Sachen holen", "Spinnen verscheuchen"), estimatedTime = 80)
    clean.estimatedTime = 70
    clean.addStep("wegräumen")

    val cleanProject = Project("clean", "Sauber machen", Date(), mutableListOf(clean, clean2))
    println(cleanProject.tasks[0].steps?.get(2) ?: "Keine weiteren Schritte")
    println(cleanProject.progress)
    cleanProject.tasks[0].status = Status.DONE
    println(cleanProject.progress)
}
*/



