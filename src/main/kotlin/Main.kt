import java.lang.StringBuilder

fun main() {
    val linkedListMy = LinkedListMy<String>()
    val stackMy = StackMy<String>()
    val dynamicArray = DynamicArrayHome<String>()
    val doublyLinkedList = DoublyLinkedListHome<String>()
    val queueMy = QueueArrayImplMy<String>()
    val queueLinked = QueueLinkedListImpl<String>()
    val deque = Deque<String>()
    deque.enqueueFront("elem0")
    deque.enqueueFront("elem1")
    deque.enqueueFront("elem2")
    deque.enqueueEnd("elem3")
    deque.enqueueEnd("elem4")

    println(deque.dequeueEnd())
    println(deque.dequeueEnd())
    println(deque.dequeueFront())

}

fun sortString(input: String): String {
    val pairs = createLengthAndWordPairs(input)
    var _pairWithMinLength: Pair<Int, String> = Pair(0, "")
    var minLength = 0
    val result = StringBuilder()
    for (i in 0 until pairs.size) {
        minLength = pairs[0].first

        for (pair in pairs) {
            if (pair.first <= minLength) {
                _pairWithMinLength = pair
                minLength = pair.first
            }
        }

        result.append(_pairWithMinLength.second)
        result.append(' ')
        pairs.remove(_pairWithMinLength)
    }

    return removeDots(result.toString()).lowercase().capitalize() + "."
}

fun createLengthAndWordPairs(input: String): MutableList<Pair<Int, String>> {
    var word = ""
    var lengthtemp = 0
    var lengthAndWord: MutableList<Pair<Int, String>> = mutableListOf()
    for (i in input.indices) {
        if (input[i] == ' ') {
            lengthAndWord.add(Pair(lengthtemp, word))
            word = ""
            lengthtemp = 0
        } else {
            word += input[i]
            lengthtemp++
            if (i == input.length - 1) {
                lengthAndWord.add(Pair(lengthtemp, word))
            }
        }

    }

    return lengthAndWord
}

/*
    returns whether removed dot or not
 */
fun removeDots(s: String): String {
    var resultStr = s
    for (i in s.indices) {
        if (s[i] == '.') {
            resultStr = s.removeRange(i, i + 1)
        }
    }

    return resultStr
}

fun countUniqueChars(stringPair: Pair<String, String>): Pair<Int, Int> {
    var sameCharsCount = 0
    for (i in stringPair.first.indices) {
        if (stringPair.second.contains(stringPair.first[i])) {
            sameCharsCount++
        }
    }
    stringPair.apply {
        return first.length - sameCharsCount to second.length - sameCharsCount
    }
}
//10, 2, 5, 3