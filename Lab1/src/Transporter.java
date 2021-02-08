import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The abstract base class for all transporters.
 * @param <T> The parameter type of which transportable object the transporter can transport.
 */

public abstract class Transporter<T extends ITransportable> extends Vehicle implements ITransporter<T>{

    private final int capacity;
    private final Deque<T> load; // The data structure Deque which represents the load
    private double rampAngle;

    /**
     * @param color - The color of a transporter.
     * @param enginePower The engine power of a transporter.
     * @param nrDoors The number of doors on a transporter.
     * @param name The name of a specific transporter.
     * @param p - The coordinates of a transporter, represented as a point (x, y).
     * @param dir - The direction at which a transporter is pointing at.
     * @param capacity - The maximum amount of cars that a transporter can transport.
     */
    public Transporter(Color color, double enginePower, int nrDoors, String name, Point p, Direction dir, int capacity){
        super(color, enginePower, 0, nrDoors, name, p, dir);
        this.capacity = capacity;
        this.load = new ArrayDeque<>(capacity);
        this.rampAngle = 0;
    }

    /**
     * @return returns the ramp angel
     */
    public double getRampAngle() {
        return this.rampAngle;
    }

    /**
     * Turns down the ramp.
     */
    public void setRampDown(){
        rampAngle = 70;
    }

    /**
     * Turns the ramp to 0 degrees.
     */
    public void setRampUp() { rampAngle = 0; }

    public void setRamp(double d) { rampAngle = d; }

    /**
     * @return Returns if the ramp is down or not.
     */
    public boolean isRampDown(){
        return rampAngle == 70;
    }

    /**
     * @return Returns the maximum amount of vehicles the transporter can transport.
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * @return Returns the amount of vehicles in the load.
     */
    public int getLoadSize(){
        return this.load.size();
    }

    private void moveCargo(Direction direction) {
        switch (direction) {
            case EAST ->  { for (T v : load) v.setXCord(v.getXCord() + getSpeed()); }
            case WEST ->  { for (T v : load) v.setXCord(v.getXCord() - getSpeed()); }
            case NORTH -> { for (T v : load) v.setYCord(v.getYCord() + getSpeed()); }
            case SOUTH -> { for (T v : load) v.setYCord(v.getYCord() - getSpeed()); }
        }
    }

    private void turnCargo(Direction direction) {
        switch (direction) {
            case EAST ->  { for (T v : load) v.setDirection(Direction.SOUTH); }
            case WEST ->  { for (T v : load) v.setDirection(Direction.NORTH); }
            case NORTH -> { for (T v : load) v.setDirection(Direction.EAST); }
            case SOUTH -> { for (T v : load) v.setDirection(Direction.WEST); }
        }
    }

    /**
     * @return Returns the load of the specific vehicle type.
     */
    @Override
    public Deque<T> getLoad(){
        return load;
    }

    @Override
    public T unload(){
        return load.getLast();
    }

    /**
     * Moves the transporter and its corresponding load by changing the x- or y -coordinate with its speed.
     */
    @Override
    public void move() {
        if (isRampDown()) {
            System.out.println("Cannot drive with ramp down");
        } else {
           super.move();
           moveCargo(getDirection());
        }
    }


   /**
    * Changes the direction of the car and its corresponding load.
    */
   @Override
   public void turnRight () {
       if (isRampDown()) {
           System.out.println("Cannot drive with ramp down");
       } else {
           super.turnRight();
           turnCargo(getDirection());
       }
   }

   /**
    * Changes the direction of the car and its corresponding load.
    */
   @Override
   public void turnLeft () {
       if (isRampDown()) {
           System.out.println("Cannot drive with ramp down");
       } else {
           super.turnLeft();
           turnCargo(getDirection());
       }
   }
}


