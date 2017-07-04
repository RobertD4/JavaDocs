package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class Shape extends AbstractShape  implements ShapeBehaviour {

    protected int color;
    protected float saturation;

    public double area(){
       return 0;
    }

    public void setColor(int color){
        this.color=color;
    }

    public int getColor(){
        return color;
    }

    private void setSaturation(float saturation){
        this.saturation=saturation;
    }

    private float getSaturation(){
        return saturation;
    }

}
