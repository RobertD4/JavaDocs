package exercise.exercise0;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {
    ArrayList<Integer> list;
    public Exercise0(){
         list = new ArrayList<Integer>();
         list.add(2);
         list.add(2);
    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it



        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        Iterator<Integer> it = list.iterator();
        System.out.println("Lista este formata din: ");
        while(it.hasNext()){
            Integer li = it.next();
            System.out.print(li+" ");
        }
        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        System.out.println();
        System.out.println("Lista cu for normal este: ");
        for (int i=0;i<list.size(); i++){
           Integer h =  list.get(i);
            System.out.print(h+" ");
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.println();
        System.out.println("Lista cu foreach este: ");
        for (Integer l : list) {
            System.out.print(l+" ");
        }

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 ex1 = new Exercise0();
        ex1.iterateThroughList();
    }
}
