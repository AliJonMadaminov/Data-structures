import kotlin.Pair;

public class DynamicArrayHome<T> {

    private int capacity = 0;
    private int size = 0;
    private T[] arr;

    public DynamicArrayHome() {
        this(15);
    }

    @SuppressWarnings("Unchecked")
    public DynamicArrayHome(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity" + capacity);
        this.capacity = capacity;
        arr = createArray(this.capacity);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (isNotCorrectIndex(index)) throw new IllegalArgumentException();
        return arr[index];
    }

    public void set(int index, T elem) {
        if (isNotCorrectIndex(index)) throw new IllegalArgumentException();
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        capacity = 15;
        arr = createArray(capacity);
        size = 0;
    }

    public void add(T elem) {
        if (size + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] newArray = createArray(capacity);
            for (int i = 0; i < size; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        arr[size++] = elem;
    }

    public T removeAt(int index) {
        if (isNotCorrectIndex(index)) throw new IndexOutOfBoundsException();
        T data = arr[index];
        T[] newArray = createArray(size - 1);
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) j--;
            else newArray[j] = arr[i];
        }
        arr = newArray;
        capacity = --size;

        return data;
    }

    // did not use removeAt(0) to avoid iteration
    public void remove() {
        if (size > 0) {
            arr[--size] = null;
        }
    }

    private boolean isNotCorrectIndex(int index) {
        return index >= size || index < 0;
    }

    private T[] createArray(int capacity) {
        return (T[]) new Object[capacity];
    }
}
