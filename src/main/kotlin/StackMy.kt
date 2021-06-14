import java.lang.Exception

class StackMy<T> {

    private var head: Node? = null
    var size:Int = 0
    private set

    private inner class Node(
        val data: T? = null,
        val next: Node? = null
    ) {

    }

    fun push(element: T) {
        if (head == null) {
            head = Node(element)
        } else {
            val newNode = Node(element, head)
            head = newNode
        }
        size++
    }

    fun pop(): T {
        if (head == null) {
            throw Exception("You tried to pop empty stack")
        } else {
            val element = head?.data
            head = head?.next
            size--
            return element!!
        }
    }
}