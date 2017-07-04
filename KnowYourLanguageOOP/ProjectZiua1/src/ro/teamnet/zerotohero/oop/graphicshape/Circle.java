package ro.teamnet.zerotohero.oop.graphicshape;

import com.sun.corba.se.impl.interceptors.PICurrent;


import static java.lang.Math.PI;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 0;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Center= = ("+xPos+","+yPos+") and radius = "+radius;
    }

    public double area() {
        return PI*(radius^2);
    }
    public void fillColour(){
        System.out.println(super.color);
    }

    public void fillColour(int p){
        super.color = p;
        System.out.println("The circle colour is "+super.color);
    }

    public void fillColour(float p){

        super.saturation = p;
    }
}
