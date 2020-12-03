
public class MyStack<T> {
    private MyOneLinkedList<T> stack = new MyOneLinkedList<>();

    public boolean empty(){
        return stack.isEmpty();
    }

    public T peek() { return stack.getFirst(); }

    public T pop() { return stack.removeFirst(); }

    public T push(T item) { stack.insertFirst(item); return item; }

    public int search(T item) { return stack.indexOf(item); }

}
