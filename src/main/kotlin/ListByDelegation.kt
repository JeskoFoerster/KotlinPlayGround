package de.thkoeln.kohls.ap2.listen_kommentiert

/**
 * Die Klasse ListByDelegation implementiert das
 * SimpleList Interface, d.h. sie stellt alle darin
 * definierten Operationen bereit und implementiert sie.
 * Zu den Operationen gehören Funktionimplementierungen
 * und der Zugriff auf im Interface festgelegte
 * Eigenschaften.
 *
 * by Delegation bedeutet dabei: die Arbeit wird
 * an eine bestehende Implementierung einer Listenstruktur
 * delegiert. Wir nutzen dabei die MutableList, die ja
 * dazu geeignet ist, um eine Liste zu speichern.
 *
 * Warum sollte man dann nicht gleich die MutableList
 * im Client-Code (also hier in der App) verwenden?
 * Das SimpleList Interface reduziert die bereitgestellten
 * Methoden, führt eigene Bezeichner für die Operationen
 * ein und könnte auch zusätzliche Funktionen bereitstellen.
 * Zudem lässt sich im Client-Code die Implementierung
 * der Liste leicht austauschen, wenn nur eine Referenz
 * vom Typ der Schnittstelle verwendet wird.
 *
 * Die folgende Klasse ist "gegen die Schnittstelle"
 * SimpleList implementiert, d.h. sie erfüllt alle
 * Anforderungen der Schnittstelle.
 */

class ListByDelegation : SimpleList {

    // intern delegieren wir die Arbeit an eine
    // MutableList. Dies ist nach außen nicht sichtbar
    // private versteckt die Eigenschaft (kapselt die Eigenschaft)
    // der _ vor data ist eine Namenskonvention für
    // private Eigenschaften, d.h. er ist kein verbindlicher
    // Teil der Syntax.
    private val _data : MutableList <Any> = mutableListOf<Any>()

    override fun addFirst(e: Any) {
        // die MutableList bietet eine add Funktion an,
        // bei der angegeben werden kann, an welcher STelle
        // das Objekt eingefügt werden soll.
        _data.add(0 , e )

        // Aufgepasst: intern verwendet die MutableList ein
        // Array. Beim Einfügen eines Elements am Anfang
        // müssen alle folgenden Elemente im Array verschoben werden
        // Die Laufzeit ist linear zur Größe der Liste, also O(n)

    }

    override fun addLast(e: Any) {
        // Wenn add ohne Index-Parameter augerufen wird,
        // dann wird das Element am Ende eingefügt.
        _data.add (e)

        // Das Element wird im Array an der ersten
        // freien Stelle gespeichert. Da diese Stelle
        // intern bekannt ist (in der MutableList-Impl),
        // ist diese Operation sehr schnell und wird
        // in konstanter Laufzeit ausgevführt, also O(1)

    }

    // Das erste Element ist in der _data List am
    // Index 0 gespeichert. Da wir das Ergebnis
    // mit nur einem einzigen Ausdruck ermitteln können,
    // bietet sich eine Ausdrucksfunktion an, d.h. statt
    // eines Funktionsrumpfs mit {} wird hinter
    // einen = Zeichen direkt der Ausdruck geschrieben.
    // In unserem Fall ist der Ausdruck _data[0]
    override fun getFirst(): Any = _data[0]

    // So würde es mit Funktionsrumpf aussehen:
//    override fun getFirst(): Any
//    {
//        return _data[0]
//    }

    // Wird wieder direkt an _data delegiert:
    override fun get(n: Int): Any = _data[n]

    // _data[n] ist übrigens eine Kurzschreibweise für
    // _data.get(n),  folgende Funktion würde also
    // genauso funktionieren:
    // override fun get(n: Int): Any = _data.get(n)
    // Hintergrundinfo: in Kotlin lässt sich in
    // Klassen festlegen, welche Funktion für einen
    // Operator aufgerufen wird.
    // Der + Operator ruft die .plus(...) Funktion auf
    // Der [] Operator ruft die .get(...) Funktion auf

    // Auch die MutableList kennt ein contains:
    override fun contains(e: Any): Boolean = _data.contains(e)

    // empty ist Eigenschaft, die vom Interface eingefordert wird
    // hier Definieren wir sie als berechnete Eigenschaft.
    // Die Liste ist dann leer, wenn sie keine Element hat, also size == 0 gilt.
    override val empty: Boolean
       get() =  (size == 0)
    // Alternativ:
    // get () = _data.isEmpty()

    // Eigenschaft wird berechntet, indem auf die
    // size-Eigenschaft von _data zugegriffen wird
    override val size: Int
        get() = _data.size


}

// Hinweis: Vielleicht vermissen Sie in dieser Datei
// Algorithmen zur Berechnung der Ergebnisse. Bei
// der Delegation ist es gerade so, dass wir die
// Berechnung an eine andere Klasse delegieren.
// Die Funktionen von MutableList (oder deren
// Oberklassen) übernehmen für uns die Arbeit.