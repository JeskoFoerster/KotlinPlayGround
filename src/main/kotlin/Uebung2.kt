enum class Priority {
    HIGH,
    MEDIUM,
    LOW;

    companion object {
        fun fromFactor(factor: Double): Priority {
            return when(factor.toInt()) {
                1 -> HIGH
                2 -> MEDIUM
                3 -> LOW
                else -> throw IllegalArgumentException("Ungültiger Faktor: $factor")
            }
        }
    }
}
open class Unit(
    val title: String,
    val description: String,
    var deadline: Int,
    var status: Status
) {
    protected fun changeStatus(status: Status) {
        this.status = status
    }

    open fun getSummary(): String {
        return "'${title}' mit der Beschreibung '${description}' muss bis in ${deadline} Tag(en) erledigt sein. " +
                "Der aktuelle Status ist ${status}."
    }
}

abstract class Task(
    title: String,
    description: String,
    deadline: Int,
    var steps: List<String>? = null,
    var estimatedTime: Int? = 0,
    status: Status
) : Unit(title, description, deadline, status) {
    init {
        estimatedTime = estimatedTime ?: 0
    }

    override fun getSummary(): String {
        return "Die Aufgabe " + super.getSummary() + " Die Arbeitsschritte sind: ${steps?.joinToString() ?: "Keine"}. " +
                "Es wird voraussichtlich ${estimatedTime} Minuten dauern."
    }

    abstract fun check()
}

class RecurringTask(
    title: String,
    description: String,
    deadline: Int,
    steps: List<String>? = null,
    estimatedTime: Int? = 0,
    status: Status,
    var frequency: Int
) : Task(
    title,
    description,
    deadline,
    steps,
    estimatedTime,
    status
) {
    override fun getSummary(): String {
        return "Die wiederkehrende Aufgabe " + super.getSummary() + " Die Aufgabe wiederholt sich alle ${frequency} Tage."
    }

    override fun check() {
        if (this.deadline < 0) {
            val newDeadline = this.deadline + this.frequency
            if (newDeadline >= 0) {
                this.deadline = newDeadline
                println("Wiederkehrende Aufgabe '${this.title}' ist überfällig und wird neu geplant.")
                println("Neue Deadline für '${this.title}' in ${this.deadline} Tagen.")
            } else {
                throw Exception("Neue Deadline der wiederkehrenden Aufgabe '${title}' nach Deadline des Projekts.")
            }
        }
    }
}

class SingleTask(
    title: String,
    description: String,
    deadline: Int,
    steps: List<String>? = null,
    estimatedTime: Int? = 0,
    status: Status
) : Task(
    title,
    description,
    deadline,
    steps,
    estimatedTime,
    status
) {
    val reminder: Int
        get() {
            val rem = deadline - 2
            return if (rem < 0) 0 else rem
        }

    override fun getSummary(): String {
        return "Die einmalige Aufgabe " + super.getSummary() + " Die Erinnerung ist ${reminder} Tag(e) vor der Deadline."
    }

    override fun check() {
        if (this.reminder == 0) {
            println("Alarm für einmalige Aufgabe '${this.title}'!")
        }
    }
}

class Project(
    name: String,
    description: String,
    deadline: Int,
    var tasks: MutableList<Task>,
    status: Status
) : Unit(name, description, deadline, status) {
    val progress: Double
        get() {
            if (tasks.isNotEmpty()) {
                var count = 0.0
                for (task in tasks) {
                    if (task.status == Status.DONE) count++
                }
                return (count / tasks.size) * 100
            } else {
                return 0.0
            }
        }

    override fun getSummary(): String {
        return "Das Projekt " + super.getSummary() + " Das Projekt beinhaltet ${tasks.size} Aufgaben. " +
                "Aktuell sind ${String.format("%.2f", progress)}% abgeschlossen."
    }

    fun addTask(task: Task) {
        if (task.deadline < this.deadline)
            tasks.add(task)
        else
            throw Exception("Deadline der Aufgabe nach Deadline des Projekts.")
    }

    fun checkTasks() {
        for (task in tasks) {
            task.check()
        }
    }
}

enum class Status {
    TODO,
    DOING,
    DONE
}

fun main() {
    val task1 = SingleTask(
        "Gerichte planen",
        "Die konkreten Mahlzeiten planen",
        6,  // Setting deadline to 6 days from now to demonstrate the reminder
        listOf("Rezepte aussuchen", "Verfügbarkeit an Tagen checken"),
        15,
        Status.DONE
    )

    val task2 = SingleTask(
        "Einkaufsliste schreiben",
        "Die benötigten Lebensmittel aufschreiben",
        2,  // Setting deadline to 2 days from now to trigger the reminder
        listOf("Zutaten aus Rezepten aufschreiben", "Vorräte checken", "Liste anpassen"),
        30,
        Status.DOING
    )

    val task3 = SingleTask(
        "Einkaufen",
        "Alle benötigten Lebensmittel kaufen",
        3,
        listOf("Pfand einpacken", "Zum Supermarkt fahren", "Einkaufen", "Nach Hause fahren", "Einkäufe einräumen"),
        90,
        Status.TODO
    )

    val recurringTask = RecurringTask(
        "Müll rausbringen",
        "Den Müll alle 3 Tage rausbringen",
        -1,  // Setting deadline to -1 days to simulate an overdue recurring task
        listOf("Müllbeutel einsammeln", "Mülltonne rausstellen"),
        10,
        Status.TODO,
        3
    )

    val project = Project(
        "Wocheneinkauf",
        "Essen für die kommende Woche besorgen",
        10,
        mutableListOf(task1, task2, task3, recurringTask),
        Status.DOING
    )

    println(task1.getSummary())
    println(task2.getSummary())
    println(task3.getSummary())
    println(recurringTask.getSummary())
    println(project.getSummary())

    // Check tasks for reminders and updates
    project.checkTasks()
}
