package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvass;
import ro.teamnet.zerotohero.oop.graphicshape.*;

import javax.sound.midi.Soundbank;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class RunApp {

    public static void main(String[] args) {

        Circles obj1 = new Circles();
        Circle obj2 = new Circle();
        System.out.println("This default area is "+ obj1.getAreaPub());
        System.out.println(obj2.toString());
        obj1.getAreaDef();
        Canvass obj3 = new Canvass();
        obj3.paint();
        Shape obj4 = new Circle(10);
        System.out.println("Aria "+obj4.area());
        ShapeBehaviour obj5 = new Square(10);
        System.out.println("Aria este "+obj5.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));



    }
}
