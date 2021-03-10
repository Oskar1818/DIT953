package model.vehicle.transporter;

import model.stationary.CommonGoods;
import model.vehicle.Direction;
import model.vehicle.Vehicle;
import point.Point;
import java.awt.Color;


public class Scania extends Transporter<CommonGoods> {

    /**
     *
     * @param color The color of the truck.
     * @param point The coordinates of the transporter, represented as a point (x, y).
     * @param dir The direction at which the transporter is pointing at.
     * @param capacity The maximum amount of goods the transporter can transport.
     */
    public Scania(Color color, Point point, Direction dir, int capacity){
        super(color, 500, 2, "Scania", point, dir, capacity);
        stopEngine();
    }

    private Scania(Color color, Point point, Direction dir, double speed, int capacity){
        super(color, 500, speed, 2, "Scania", point, dir, capacity);
    }

    private Scania(Color color, Point point, Direction dir, double speed, int capacity, boolean state) {
        super(color, 500, speed, 2, "Scania", point, dir, capacity);
        if (state)
            setRampAngle(0);
        else
            setRampAngle(70);
    }

    /**
     * Sets the angle at which the ramp should tilt.
     * @param a The specified angel, which cannot go beyond 70 degrees or beneath 0 degrees.
     */
    public void setRampAngle(double a){
        if (getSpeed() != 0)
            System.out.println("model.vehicle.car.Car must not move!");
        else
            setRamp(Math.max(Math.min(a, 70), 0));
    }

    @Override
    public void addLoad(CommonGoods something) {
        getLoad().add(something);
    } // not immutable yet

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public Vehicle createVehicleWithNewCord(Point point) {
        return new Scania(this.getColor(), point, this.getDirection(), this.getSpeed(), this.getCapacity());
    }

    @Override
    public Vehicle createVehicleWithNewDirection(Direction dir) {
        return new Scania(this.getColor(), this.getPoint(), dir, this.getSpeed(), this.getCapacity());
    }

    @Override
    public Vehicle createVehicleWithNewSpeed(double amount) {
        return new Scania(this.getColor(), this.getPoint(), this.getDirection(), amount, this.getCapacity());
    }

    @Override
    public Vehicle createVehicleWithNewX(double xCord) {
        return new Scania(this.getColor(), new Point(xCord, this.getYCord()),
                this.getDirection(), this.getSpeed(), this.getCapacity());
    }

    @Override
    public Vehicle createVehicleWithNewY(double yCord) {
        return new Scania(this.getColor(), new Point(this.getXCord(), yCord),
                this.getDirection(), this.getSpeed(), this.getCapacity());
    }

    @Override
    public Transporter<CommonGoods> createTransporterWithRampAngel(boolean state) {
        return new Scania(this.getColor(), this.getPoint(),
                this.getDirection(), this.getSpeed(), this.getCapacity(), state);

    }
}
