
open class Medium(
    val title: String,
    var isAvailable: Boolean,
    val genre: Genre
) : Borrowable {
    fun updateAvailability() {
        isAvailable = !isAvailable
    }

    open fun summarize(): String = "$title mit dem Genre $genre ist " + if(isAvailable) "verfügbar"  else "ausgeliehen"
    override fun borrowItem():String {
        if(isAvailable){
            isAvailable = false
            return "Medium kann mitbenommen werden."
        }
        return "Medium kann nicht mitbenommen werden."
    }

    override fun returnItem(): String{
        if(!isAvailable){
            isAvailable = true
            return "Medium kann mitbenommen werden."
        }
        return "Wie das geht nicht..."
    }
}

class Book(
    title: String,
    val author: String,
    val pages: Int,
    isAvailable: Boolean,
    genre: Genre
): Medium(title, isAvailable, genre) {
    override fun summarize(): String = "Das Buch " + super.summarize()

    override fun borrowItem(): String {
        return super.borrowItem() + when(genre){
            Genre.BILDUNG -> "60 Tage frist"
            else -> "30 Tage"
        }
    }
}

class Magazine(
    title: String,
    val issueNo: Int,
    val publication: String,
    isAvailable: Boolean,
    genre: Genre
): Medium(title, isAvailable, genre) {
    override fun summarize(): String = "Das Magazin " + super.summarize()
    fun subscribe(email: String) {
        println("$email hat $title abonniert.")
    }

}

class DVD (
    title: String,
    val director: String,
    val duration: Int,
    val usk: Int,
    isAvailable: Boolean,
    genre: Genre
): Medium(title, isAvailable, genre) {
    override fun summarize(): String = "Die DVD " + super.summarize()
    fun play() {
        println("Play")
    }
    fun pause() {
        println("Pause")
    }

    override fun borrowItem() : String{
        return super.borrowItem() + "usk 12"
    }
}

class Library(
    val name: String,
    var mediaList: MutableList<Medium>
) {
    val availableBooks: Int?
        get() {
            if (mediaList.isEmpty()) {
                return null
            }
            var count = 0
            for (book in mediaList) {
                if (book.isAvailable) {
                    count++
                }
            }
            return count
        }

    fun getAverageBookLength(): Int {
        if (mediaList.isEmpty()) {
            return 0
        }
        var count = 0
        var sum = 0
        for (medium in mediaList) {
            if (medium is Book) {
                sum += medium.pages
                count++
            }
        }
        return sum / count
    }
    fun getAvailableMedia(): List<Medium> {
        var list = mutableListOf<Medium>()
        for (medium in mediaList) {
            if (medium.isAvailable) {
                list.add(medium)
            }
        }
        return list
    }

    fun getAll(): String {

        if (mediaList.isEmpty()) {
            throw Yeet()
        }
        var result = ""
        for (medium in mediaList) {
            when(medium){
                is Book -> result + "${medium.title} ${medium.author} - ${medium.pages}"
                is Magazine -> result + "${medium.publication} ${medium.publication} - ${medium.publication}"
                is DVD -> result + "${medium.title} ${medium.title} - ${medium.title}"
                else -> Yeet()
            }
        }
        return result
    }

    fun addBook(book: Book) {
        mediaList.add(book)
    }
}

interface Borrowable{
    fun borrowItem():String
    fun returnItem():String
}

enum class Genre {
    KRIMI,
    FANTASY,
    HORROR,
    BILDUNG
}

class NoBooksAvailableException(message: String) : Exception(message)

fun main() {
    val book1 = Book("Die Gefährten", "J.R.R. Tolkien", 500, true, Genre.FANTASY)
    val book2 = Book("Die zwei Türme", "J.R.R. Tolkien", 500, false, Genre.FANTASY)
    val book3 = Book("Die Rückkehr des Königs", "J.R.R. Tolkien", 500, true, Genre.FANTASY)
    val magazine = Magazine("National Geographic", 5, "01-01-2024", true, Genre.BILDUNG)
    val dvd = DVD("Das Schweigen der Lämmer", "Jonathan Demme", 118, 16, true, Genre.HORROR)

    val library = Library("Meine Bibliothek", mutableListOf())

    library.addBook(book1)
    library.addBook(book2)

    println("Available books in ${library.name}: ${library.availableBooks}")
    println("Books in ${library.name}: ${library.getAll()}")

    magazine.subscribe("test@mail.de")
    dvd.play()
    dvd.pause()

    println(book1.summarize())
    println(book2.summarize())
    println(book3.summarize())
    println(magazine.summarize())
    println(dvd.summarize())

    library.getAvailableMedia()

    throw Yeet()
}

