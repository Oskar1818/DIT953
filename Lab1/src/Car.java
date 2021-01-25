import java.awt.*;

public abstract class Car {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name


    // possibly constructors here, not sure if necessary yet!
    public Car(int d, double ep, double cs, Color c, String n){
        this.nrDoors = d;
        this.enginePower = ep;
        this.currentSpeed = cs;
        this.color = c;
        this.modelName = n;
    }

    public void setModelName(String name){ this.modelName = modelName; }

    public String getModelName(){ return this.modelName; }

    public void setNrDoors(int i){ this.nrDoors = i; }

    public int getNrDoors(){
        return this.nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public void setEnginePower(double enginePower){this.enginePower = enginePower;}

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed){
        currentSpeed = Math.min(speed, this.enginePower);
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        this.color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

}
