package Baitap5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delete {
    public static void main(String[] args) {
    List<Integer> number = new ArrayList<>(Arrays.asList(1,8,5,7,6,9,4));
    List<Integer> number2 = new ArrayList<>();
    for(Integer e:number){
        if(e%2 != 0){
            number2.add(e);
        }
    }
        System.out.println(number2);
    }
}
