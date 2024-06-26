package Baitap1;

import java.util.*;

public class MyList <E> {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        System.out.println(myList);

        System.out.println(Collections.max((myList)));

        Collections.reverse(myList);

        System.out.println(myList);

        Collections.sort(myList);
        System.out.println(myList);

        List<Integer> myList2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        myList.addAll(myList2);
        System.out.println(myList);
    }
}
