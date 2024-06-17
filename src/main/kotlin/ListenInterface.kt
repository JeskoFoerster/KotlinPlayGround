package de.thkoeln.kohls.ap2.listen_kommentiert

// Schnittstelle für eine List mit einfachen
// Operationen. Ist noch nicht perfekt.
// Z.B. speichern wir Daten vom Typ Any statt
// einen Typparameter zu ermöglichen, so dass
// in einer Liste nur Elemente eines bestimmten
// Typs gespeichert werden können. Das machen
// wir beim nächsten Mal.

interface SimpleList {

    // fügt das Element e an erste Stelle ein
    fun addFirst( e : Any)

    // fügt das Element e an letzter Stelle ein
    fun addLast( e: Any )

    // liefert das erste Element der Liste zurück
    fun getFirst () : Any

    // liefert das Element an der Indexstelle n zurück
    fun get ( n : Int ) : Any

    // true, wenn e in der Liste vorhanden ist
    fun contains ( e: Any) : Boolean

    // In einem Interface können keine Eigenschaften
    // gespeichert werden. Dennoch können Eigenschaften
    // festgelegt werden: diese müssen dann von der
    // implementierenden Klasse auch bereitgestellt werden
    // Im Prinzip wird hier die Operation festgelegt,
    // dass der Eigenschaftswert empty durch eine isEmpty()
    // Funktion abgefragt wird. Ob der Wert von empty
    // in einem field gespeichert wird oder dynamisch
    // berechnet wird, wird in den implementierenden Klassen
    // festgelegt.
    val empty : Boolean  // ist die Liste leer?

    // Gleiches gilt für die Größe der Liste
    // Bei size ist es tatsächlich eine Designentscheidung
    // in den Unterklassen, ob dieser Wert in einem field
    // gepeichert wird (Vorteil: schnellerer Zugriff,
    // Nachteil: mehr Verwaltungsaufand/Fehlerquellen) oder
    // dynamisch berechnet wird (Nachteil: ggf. lange Laufzeit)
    val size : Int


}