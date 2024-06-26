package Baitap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lonhon3{
    public static void main(String[] args) {
        String str = "Rikkei Academy để nông dân biết code";
        String[] tr1 = str.split(" ");
        List<String> arr = new ArrayList<>(Arrays.asList(tr1));
        for(String e:arr){
            if(e.length()>3){
                System.out.println(e);
            }
        }
    }

}
