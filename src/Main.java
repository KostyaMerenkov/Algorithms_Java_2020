import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<String> ml = new MyLinkedList<>();
        ml.insertFirst("A");

        for (String s : ml) {
            System.out.println(s);
        }
//        ml.insertFirst("B");
//        ml.insertFirst("C");

    }
}
