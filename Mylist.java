//1.Create a list [1,5,7,2,3]
//2.Print the list
//3.Change element 7 to 6 

import java.util.*;

public class Mylist {
public static void main(String[] args){

    List<Integer> l1=new ArrayList<>();

    l1.add(1);
    l1.add(5);
    l1.add(7);
    l1.add(2);
    l1.add(3);
    System.out.println(l1);

    l1.set(2,6);
    System.out.println(l1);
    }
}


