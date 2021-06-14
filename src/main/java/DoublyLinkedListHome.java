public class DoublyLinkedListHome<T> {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node {
        T data;
        Node prev;
        Node next;

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(T data) {
        if (head == null) {
            head = tail = new Node(data, null, null);
        } else {
            addLast(data);
        }
        size++;
    }

    private void removeLast() {
        tail.prev = tail;
        tail.next = null;
        size--;
    }

    private void addLast(T data) {
        Node newNode = new Node(data, tail, null);
        tail.next = newNode;
        tail = newNode;
    }

    public T get(int index) {
        if (indexIsNotValid(index)) throw new IndexOutOfBoundsException();
        if (index < size / 2) {
            return traverseFromHead(index);
        } else {
            return traverseFromTail(index);
        }

    }

    private T traverseFromHead(int index) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (index == i) {
                return currentNode.data;
            } else {
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    //traverses from last element to element at given index
    private T traverseFromTail(int index) {
        Node currentNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (index == i) {
                return currentNode.data;
            } else {
                currentNode = currentNode.prev;
            }
        }
        return null;
    }

    public boolean indexIsNotValid(int index) {
        return index >= size || index < 0;
    }
}
