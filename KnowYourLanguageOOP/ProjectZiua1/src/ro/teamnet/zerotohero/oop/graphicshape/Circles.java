package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class Circles {

    public double getAreaPub(){
        Circle c = new Circle();
        return  c.area();
    }

    public void getAreaDef(){
        Circle c1 = new Circle();
        c1.fillColour();
        c1.fillColour(2);
        c1.fillColour(43);
    }
}
