import model.stationary.Workshop;
import model.vehicle.car.Car;
import model.vehicle.Direction;
import model.vehicle.car.Saab95;
import model.vehicle.car.Volvo240;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestWorkshop {

    Workshop<Car> carWS;
    Workshop<Volvo240> volvo240WS;
    Workshop<Saab95> saab95WS;
    Volvo240 volvo240;
    Saab95 saab95;


    @Before
    public void setUp() {
        carWS = new Workshop<>(20, new Point(0,0));
        volvo240WS = new Workshop<>(10, new Point(20,20));
        saab95WS = new Workshop<>(45, new Point(200, 10));
        volvo240 = new Volvo240(Color.green, new Point(0,0), Direction.NORTH);
        saab95 = new Saab95(Color.yellow, new Point(1,1), Direction.NORTH);
    }

    @Test
    public void loadWorkshop() {
        carWS.addVehicle(volvo240);
        assertEquals(carWS.getVehicle(volvo240), volvo240);
    }

    /* Generates a compile error
    @Test
    public void addWrongVehicle() {
        volvo240WS.addVehicle(saab95);
    }

     */



}
