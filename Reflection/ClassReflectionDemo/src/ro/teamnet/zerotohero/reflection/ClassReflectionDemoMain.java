package ro.teamnet.zerotohero.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
class CompanyA {

    String orgName;
    private int x;
    int count;
    List<String> comments;
    Set<String> branches;
    Map<String, String> extra;
}

public class ClassReflectionDemoMain {
    private static int c3 = 1;
    private int c1 = 0;
    private Integer c2 = 1;
    String h = "asda";

    public ClassReflectionDemoMain() {
    }

    public ClassReflectionDemoMain(String h) {
        this.h = h;
    }
    public void desen(){
        System.out.println("Teamnet in the building!!");
    }

    public void desen2(){

    }

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, IllegalArgumentException {
        //TODO get the class for a String object, and print it
	        String x = new String("abcd");
            out.println(x.getClass());

        //TODO get the class of an Enum, and print it
        out.println(Day.SUNDAY.getClass());
        out.println(Enum.class);

        //TODO get the class of a collection, and print it
        LinkedList<String> link = new LinkedList<String>();
        out.println(link.getClass());
        out.println(LinkedList.class);

        //TODO get the class of a primitive type, and print it
        int in = 0;
        out.println(int.class);

        //TODO get and print the class for a field of primitive type

        Field[] fields = CompanyA.class.getDeclaredFields();
        out.println(fields.getClass());
        //TODO get and print the class for a primitive type, using the wrapper class
        Boolean  y = new Boolean(true);
        out.println(Boolean.TYPE);

        //TODO get the class for a specified class name
                try {

            Class cls = Class.forName("java.lang.CompanyA");


            out.println("Class found = " + cls.getName());
            out.println("Package = " + cls.getPackage());
        } catch(ClassNotFoundException ex) {
            out.println(ex.toString());
        }


        //TODO get the superclass of a class, and print it
         NewClass x1 =new NewClass();
        out.println(x1.getClass().getSuperclass());
        //TODO get the superclass of the superclass above, and print it
        SecondClass x2 = new SecondClass();
        out.println(x2.getClass().getSuperclass().getSuperclass());

        //TODO get and print the declared classes within some other class
        ClassReflectionDemoMain cs = new ClassReflectionDemoMain();
        out.println(cs.getClass().getDeclaredClasses());

        //TODO print the number of constructors of a class
        out.println(cs.getClass().getConstructors());

        //TODO get and invoke a public constructor of a class
       // cs.getClass().getConstructor().invoke(cs,"fg");
        cs.getClass().getConstructor(String.class).newInstance("fg");

        //TODO get and print the class of one private field 

        System.out.println(cs.getClass().getDeclaredField("c1"));

        //TODO set and print the value of one private field for an object
       cs.getClass().getDeclaredField("c3").set(cs,34);
        System.out.println("Modificare: " + c3);;

        //TODO get and print only the public fields class
        System.out.println(cs.getClass().getFields());

        //TODO get and invoke one public method of a class
        cs.getClass().getMethod("desen").invoke(cs,null);

        //TODO get and invoke one inherited method of a class
       NewClass ne = new NewClass();
       ne.getClass().getMethod("desen").invoke(ne,null);
		
		//TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
        long v1 = System.currentTimeMillis();
        System.out.println(v1);
        for(int i = 0;i < 100000; i++){
            cs.desen2();
        }
        long v2 = System.currentTimeMillis();
        System.out.println(v2);
        System.out.println("Diferenta metoda clasica : "+(v2-v1));
        //TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
        v1 = System.currentTimeMillis();
        System.out.println(v1);
        for(int i = 0;i < 100000; i++){
            cs.getClass().getMethod("desen2").invoke(cs,null);
        }
        v2 = System.currentTimeMillis();
        System.out.println(v2);
        System.out.println("Diferenta metoda invoke : "+(v2-v1));
		//what do you observe?
		
    }
}
