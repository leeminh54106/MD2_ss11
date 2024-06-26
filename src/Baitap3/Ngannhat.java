package Baitap3;

import java.util.*;

public class Ngannhat {
    public static void main(String[] args) {
        String str = "Rikkei Academy để nông dân biết code";
        String[] str2 = str.split(" ");
        List<String> arr= new ArrayList<>(Arrays.asList(str2));
        String min = Collections.min(arr,Comparator.comparing(String::length));
        System.out.println( min);

    }
}
