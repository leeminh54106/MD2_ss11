package Baitap4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortUp {
    public static void main(String[] args) {
       List<Integer> number = new ArrayList<>(Arrays.asList(6, 2, 4, 15, 5, 16, 7, 1, 9, 10));
        Collections.sort(number);
        System.out.println(number);
//       for (int i = 0; i < number.size(); i++) {
//           for (int j = i + 1; j < number.size(); j++) {
//                if(number.get(i) > number.get(j)){
//                    int temp = number.get(i);
//                    number.set(i, number.get(j));
//                    number.set(j, temp);
//                }
//           }
//       }
//        System.out.println(number);
    }
}
