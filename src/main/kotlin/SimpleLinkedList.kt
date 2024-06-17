package de.thkoeln.kohls.ap2.listen_kommentiert

import java.util.NoSuchElementException

// Implementierung der SimpleList als verkettete Liste

class SimpleLinkedList : SimpleList {

    class Node (val data : Any, var next : Node? )

    private var first : Node? = null

    override fun addFirst(e: Any) {
        val newNode = Node(e, first)
        first = newNode
    }

    override fun addLast(e: Any) {
        val newNode = Node(e, null)

        if(empty){
            addFirst(newNode)
        }else {
            var lastNode = getLast()
            lastNode?.next = newNode
        }
    }

    override fun getFirst(): Any {
        return first?.data ?: throw NoSuchElementException("Yeet")
    }

    override fun get(n: Int): Any {
        var count = 0
        var currentNode = first
        while(currentNode != null){
            currentNode = currentNode.next
            if (count == n){
                return currentNode?.data ?: throw NoSuchElementException("Yeet")
            }
        }
        return throw NoSuchElementException("Yeet")
    }

    override fun contains(e: Any): Boolean {
        var currentNode = first
        while(currentNode != null){
            currentNode = currentNode.next
            if (currentNode?.data == e){
                return true
            }
        }
        return false
    }

    fun get2(n: Int): Any {
        var count = 0
        var currentNode = first

        while(currentNode != null && count != n ){
            currentNode = currentNode.next
            count++
        }

        return currentNode?.data ?: NoSuchElementException("Yeet")
    }

    private fun getLast():Node?{

        var currentNode = first
        while(currentNode?.next != null){
            currentNode = currentNode.next
        }
        return currentNode
    }

    override val empty: Boolean
        get() = first == null

    override val size: Int
        get() {
            var count = 0
            var currentNode = first
            while(currentNode != null){
                currentNode = currentNode.next
                count++
            }
            return count
        }
}