import java.awt.*;

public class Volvo240 extends Car implements Movable {

    public final static double trimFactor = 1.25;
    
    public Volvo240(){
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
    }


    @Override
    public void move() {
    }

    @Override
    public void turnLeft() {
    }

    @Override
    public void turnRight() {
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    @Override
    public void gas(double amount) {
    }

    @Override
    public void brake(double amount) {
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}
