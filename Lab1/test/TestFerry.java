import model.vehicle.Direction;
import model.vehicle.transporter.SSBadger;
import model.vehicle.car.Saab95;
import model.vehicle.car.Volvo240;
import org.junit.Before;
import org.junit.Test;
import point.Point;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestFerry {

    SSBadger ferry;
    Volvo240 volvo240;
    Saab95 saab95;


    @Before
    public void setUp() {
        volvo240 = new Volvo240(Color.green, new Point(400,400), Direction.NORTH);
        saab95 = new Saab95(Color.yellow, new point.Point(399,399), Direction.NORTH);
        ferry = new SSBadger(Color.cyan, new point.Point(400, 400), Direction.SOUTH, 200);
    }

    @Test
    public void checkMoveFerry() {
        ferry.gas(1);
        ferry.move();
        assertEquals(390, ferry.getYCord(), 0);
    }

    @Test
    public void doesTheLoadFollowTheFerry() {
        ferry.addLoad(volvo240);
        ferry.addLoad(saab95);
        ferry.gas(1);
        ferry.move();
        assertEquals(ferry.getYCord() * 2,volvo240.getYCord() + saab95.getYCord(), 0 );

    }

    @Test
    public void checkDistanceBetweenLoadAndFerry() {
        volvo240.setXCord(1);
        ferry.addLoad(volvo240);
        assertFalse(ferry.getLoadSize() > 0);
    }

    @Test
    public void checkQueueInFerry() {
        ferry.addLoad(volvo240); // first in
        ferry.addLoad(saab95); // last in
        assertEquals(ferry.unload(), volvo240);
    }
}
