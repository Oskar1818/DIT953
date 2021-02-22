import java.awt.*;

public abstract class MotorizedVehicle extends Vehicle {
    /**
     * @param color The color of the car.
     * @param enginePower The engine power of the car.
     * @param nrDoors The number of doors the car has.
     * @param name The name of the specific car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     * @param dir The initial direction of the car.
     */
    private double enginePower;

    public MotorizedVehicle(Color color, double speed, double enginePower, int nrDoors, String name, Point point, Direction dir) {
        super(color, speed, nrDoors, name, point, dir);
         this.enginePower = enginePower;
    }

    /**
     * @return Returns the engine power of the car.
     */
    public double getEnginePower(){ return this.enginePower; }

    /**
     * Starts the engine and sets the initial speed to 1.
     */
    public void startEngine(){ setSpeed(1); }

    /**
     * Stops the engine, which makes the car stop.
     */
    public void stopEngine(){ setSpeed(0); }

    @Override
    public void incrementSpeed(double amount){
        setSpeed(Math.min(getSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void setSpeed(double speed){ setSpeed(Math.min(speed, this.enginePower)); }
}
