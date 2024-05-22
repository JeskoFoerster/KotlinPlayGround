fun main(){

}


class Library(val name: String, val books:MutableList<Book> = mutableListOf()){

    var avaliableBooks : Int? = null
        get() = if(books.count { it.isAvaiable } == 0) null else books.count { it.isAvaiable }

    fun addBook(book: Book) = books.add(book)

    fun getAll(){
        if(books.size == 0) throw Exception("Yeet")
        for (book in books){
            println(book.title)
        }
    }
}

abstract class Media(val title:String, var isAvaiable: Boolean, val genre: Genre){
    fun summarize() = "${title} mit dem Genre ${genre} ist ${avaiablebilityState}"

    val avaiablebilityState:String
        get() = if (isAvaiable) "verfügbar" else "ausgeliehen"

    fun updateAvailability() {
        isAvaiable = !isAvaiable
    }
}

class Book(title:String, var pages:Int, var author:String, genre: Genre, isAvaiable:Boolean = true): Media(title, isAvaiable, genre){
    override fun toString() = "Das Buch ${super.toString()}"
}
class Magazine(
    title: String,
    val issueNo: Int,
    val publication: String,
    isAvailable: Boolean,
    genre: Genre
): Media(title, isAvailable, genre) {
    override fun toString() = "Das Magazin ${super.summarize()}"
    fun subscribe(email: String) {
        println("$email hat $title abonniert.")
    }
}
class DVD(
    title: String,
    val director: String,
    val duration: Int,
    val usk: Int,
    isAvailable: Boolean,
    genre: Genre
): Media(title, isAvailable, genre)  {

    override fun toString() = "Die DVD ${super.summarize()}"
    fun play() {
        println("Play")
    }
    fun pause() {
        println("Pause")
    }
}

enum class Genre{
    FANTASY,
    HORROR,
    BILDUNG
}