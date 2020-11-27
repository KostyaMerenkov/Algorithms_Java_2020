import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Time;
import java.util.Random;

public class Main {
    private static final Boolean DEBUG = true;
    public static void main(String[] args) {
        Random r = new Random();

        MyArrayList<Integer> arr = new MyArrayList<>();
        MyArrayList<Integer> arr2 = new MyArrayList<>();
        MyArrayList<Integer> arr3 = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) {
            int t = r.nextInt(100);
            arr.add(t);
            arr2.add(t);
            arr3.add(t);
        }

        //System.out.println(arr);
        double start = System.currentTimeMillis();
        arr.bubbleSort();
        double end = System.currentTimeMillis();

        System.out.println("bubbleSort time: " + (end - start));

        double start2 = System.currentTimeMillis();
        arr2.insertionSort();
        double end2 = System.currentTimeMillis();
        System.out.println("insertionSort time: " + (end2 - start2));

        double start3 = System.currentTimeMillis();
        arr3.selectionSort();
        double end3 = System.currentTimeMillis();
        System.out.println("selectionSort time: " + (end3 - start3));

        arr.selectionSort((a,b)->{return a%10 - b %10;});
        arr.bubbleSort((a,b)->{return a%10 - b %10;});
        arr.insertionSort((a,b)->{return a%10 - b %10;});

    }

}
