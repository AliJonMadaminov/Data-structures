class Deque<T> {
    private val linkedListMy = LinkedListMy<T>()

    fun enqueueFront(elem:T) {
        linkedListMy.add(elem)
    }

    fun enqueueEnd(elem: T) {
        linkedListMy.add(elem)
    }

    fun dequeueFront():T {
        return linkedListMy.removeFirst()
    }

    fun dequeueEnd():T {
        return linkedListMy.remove()
    }

    fun isEmpty() = linkedListMy.size == 0

    fun peekFront() = linkedListMy.get(0)

    fun peekEnd() = linkedListMy.get(linkedListMy.size - 1)
}