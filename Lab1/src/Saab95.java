import java.awt.*;

public class Saab95 extends Car implements Movable{

    public boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    @Override
    public void move() {
    }

    @Override
    public void turnLeft() {
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }


}
