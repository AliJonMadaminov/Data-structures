class QueueLinkedListImpl<T> {
    private val linkedListMy = LinkedListMy<T>()

    fun enqueue(elem:T) {
        linkedListMy.add(elem)
    }

    fun dequeue():T {
        return linkedListMy.removeFirst()
    }

    fun isEmpty() = linkedListMy.size == 0

    fun peek() = linkedListMy.get(0)
}