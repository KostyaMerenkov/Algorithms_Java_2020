
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();

        map.put(5,"five");
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(2,"two two");

//        System.out.println(map);
//        System.out.println(map.get(2));

//        map.deleteMin();
        System.out.println(map);
        System.out.println(map.size());

        map.delete(5);
        System.out.println(map);
        System.out.println(map.size());

        ArrayList<MyTreeMap> trList = new ArrayList<>();



        for (int i = 0; i < 20; i++) {
            MyTreeMap<Integer, String> t1 = new MyTreeMap<>();
            Random r = new Random();
            r.setSeed(System.currentTimeMillis());
            while (t1.getMaxHeight()<7)
            {
                int temp = (r.nextInt(200) - 100);
                t1.put(temp, Integer.toString(temp));
                //System.out.println(tree);
                //System.out.println("new num " + temp + " tree height = "+tree.getMaxHeight());
            }
            System.out.println(t1.isBalanced());
        }

        
    }
}
