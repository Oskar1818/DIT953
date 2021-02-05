import java.awt.*;

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

    /**
     * Sets the angle at which the ramp should tilt.
     * @param a The specified angel, which cannot go beyond 70 degrees or beneath 0 degrees.
     */
    public void setRampAngle(double a){
        if (getSpeed() != 0)
            System.out.println("Car must not move!");
        else
            setRampAngle(Math.max(Math.min(a, 70), 0));
    }

    @Override
    public void addLoad(CommonGoods something) {
        getLoad().add(something);
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
