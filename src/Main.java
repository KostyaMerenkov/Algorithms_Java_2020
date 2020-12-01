import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverseWord("Привет!"));

        MyDeque<Integer> myDeque = new MyDeque<>(5);
        myDeque.insertBack(1);
        myDeque.insertBack(3);
        myDeque.insertBack(5);
        System.out.println(myDeque.toString());
        myDeque.insertFront(8);
        myDeque.insertFront(0);
        System.out.println(myDeque.toString());
        myDeque.removeBack();
        myDeque.removeFront();
        System.out.println(myDeque.toString());
    }


    public static String reverseWord(String str) {
        Stack<Character> stack = new Stack<>();
        char[] array = str.toCharArray();
        for (int i = 0; i<array.length; i++) {
            stack.add(array[i]);
        }
        String answer = "";
        while (!stack.isEmpty()) {
            answer = answer + stack.pop();
        }
        return answer;
    }


}
