import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import kotlin.jvm.Throws

class LinkedListMy<T> {

    private inner class Node(var data: T? = null, var next: Node? = null) {
    }

    private var head: Node? = null
    private var tail: Node? = null
    private var tailPrev: Node? = null
    var size = 0
        private set


    fun add(element: T) {
        if (head == null) {
            head = Node(data = element, next = tail)
            tail = head
        } else {
            tailPrev = tail
            tail?.next = Node(data = element, next = tail)
            tail = tail?.next
        }

        size++
    }

    fun get(index: Int): T {

        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Linked list has size $size you tried to get element in $index index")
        }

        return if (index == 0) {
            head?.data!!

        } else if (index == size - 1) {
            tail?.data!!

        } else {
            var node: Node? = head?.next

            for (i in 1 until index) {
                node = node?.next!!
            }

            node?.data!!
        }

    }

    fun indexOf(anyObject: T): Int {
        var currentNode = head

        if (anyObject == head?.data) {
            return 0
        } else if (anyObject == tail?.data) {
            return size - 1
        }

        for (i in 1 until size) {
            currentNode = currentNode?.next
            val data = currentNode?.data

            if (data == anyObject) {
                return i
            }
        }
        // argument object is not in the list
        return -1
    }

    fun addFirst(element: T) {
        val node = Node(element)
        node.next = head
        head = node
        size++
    }

    fun remove(): T {
        val data = tail?.data
        tail = tailPrev
        size--

        return data!!
    }

    fun removeFirst(): T {
        if (size == 0) {
            throw  Exception("Underflow Exception")
        }

        val data = head?.data
        head = head?.next
        size--

        return data!!
    }

    fun remove(_object: T) {
        if (_object == head?.data) {
            removeFirst()
            return
        }

        var currentNode: Node? = head?.next
        var prevNode: Node? = null

        while (currentNode != null) {
            if (currentNode.data == _object) {
                prevNode?.next = currentNode.next
                size--
                break
            } else {
                prevNode = currentNode
                currentNode = currentNode.next
            }
        }
    }
}