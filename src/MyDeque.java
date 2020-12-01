import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;
    private int capacity;

    // 0 1 2 3 4
    // 7 5
    // b
    //     e

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T peekBack() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (end == 0) {return list[capacity-1];}
        else return list[end-1];
    }

    public T removeFront() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeBack() {
        T temp = peekBack();
        size--;
        if (end == 0) {
            list[capacity - 1] = null;
            end = capacity - 1;
            return temp;
        } else {
            list[--end] = null;
            return temp;
        }
    }

    public void insertBack(T item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertFront(T item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        size++;
        if (begin == 0) {
            begin = capacity - 1;
            list[begin] = item;
        } else {
            list[--begin] = item;
        }
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int previousIndex(int index) {
        return (index + 1) % list.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(list) + " begin: " + begin + " end: " + end;
    }
}