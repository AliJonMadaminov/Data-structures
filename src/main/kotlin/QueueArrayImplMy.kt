import java.lang.Exception
import java.lang.IndexOutOfBoundsException

class QueueArrayImplMy<T>(private val capacity: Int = 15) {

    private var arr: Array<T> = Array<Any>(capacity, {}) as Array<T>
    private var front: Int = 0
    private var rear: Int = 0

    fun enqueue(elem: T) {
        try {
            arr[rear++] = elem
        } catch (e: IndexOutOfBoundsException) {
            throw Exception("OverFlowException queue has fixed size and is full and you triying to add element queue")
        }
    }

    fun dequeue(): T {
        if (front == rear) throw Exception("Underflow Exception\n You tried to dequeue empty queue")
        return arr[front++]
    }
}