import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestWorkshop {

    Workshop<Car> carWS;
    Volvo240 volvo240;
    Saab95 saab95;

    @Before
    public void setUp() {
        carWS = new Workshop<>(20, new Point(0,0));
        volvo240 = new Volvo240(Color.green, new Point(0,0), Direction.NORTH);
        saab95 = new Saab95(Color.yellow, new Point(1,1), Direction.NORTH);
    }

    @Test
    public void loadWorkshop() {
        carWS.addVehicle(volvo240);
        assertEquals(carWS.getVehicle(volvo240), volvo240);
    }



}
