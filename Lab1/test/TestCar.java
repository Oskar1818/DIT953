import model.vehicle.Direction;
import model.vehicle.car.Saab95;
import model.vehicle.car.Volvo240;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */

public class TestCar {

    public Volvo240 volvo240;
    public Volvo240 volvo240two;

    public Saab95 saab95;
    public Saab95 saab95two;


    @Before
    public void setUp(){
        volvo240 = new Volvo240(Color.black, new Point(10, 10), Direction.NORTH);
        saab95 = new Saab95(Color.red, new Point(30, 20), Direction.EAST);
        volvo240.setSpeed(10);
        saab95.setSpeed(20);

        volvo240two = new Volvo240(Color.black, new Point(10, 10), Direction.EAST);
        saab95two = new Saab95(Color.red, new Point(30, 20), Direction.NORTH);
        volvo240two.setSpeed(10);
        saab95two.setSpeed(20);
    }

    @Test
    public void checkVolvoName() {
        assertEquals("model.vehicle.car.Volvo240", volvo240.getName());
    }

    @Test
    public void checkSaabName() {
        assertEquals("model.vehicle.car.Saab95", saab95.getName());
    }

    @Test
    public void moveVolvo() {
        volvo240.move();
        assertEquals(20, volvo240.getYCord(), 0);
    }

    @Test
    public void moveSaab () {
        saab95.move();
        assertEquals(50, saab95.getXCord(), 0);
    }


    @Test
    public void checkVolvoGas() {
        volvo240.gas(0.5);
        assertEquals(10.625, volvo240.getSpeed(), 0);
    }

    @Test
    public void checkSaabGas() {
        saab95.gas(3);
        assertEquals(21.25, saab95.getSpeed(), 0);
    }

    @Test
    public void checkVolvoBrake() {
        volvo240.brake(3);
        assertEquals(8.75, volvo240.getSpeed(), 0);
    }

    @Test
    public void checkSaabBrake() {
        saab95.brake(0.1);
        assertEquals(19.875, saab95.getSpeed(), 0);
    }

    @Test
    public void checkVolvo240LeftTurn() {
        for (int i = 0; i < 5; i++)
            volvo240.turnLeft();
        assertEquals(Direction.WEST, volvo240.getDirection());
    }

    @Test
    public void checkVolvo240RightTurn() {
        for (int i = 0; i<5; i++)
            volvo240.turnRight();
        assertEquals(Direction.EAST, volvo240.getDirection());
    }

    @Test
    public void checkSaab95LeftTurn() {
        for (int i=0; i<5; i++)
            saab95.turnLeft();
        assertEquals(Direction.NORTH, saab95.getDirection());
    }

    @Test
    public void checkSaab95RightTurn() {
        for (int i = 0; i < 5; i++)
            saab95.turnRight();
        assertEquals(Direction.SOUTH, saab95.getDirection());
    }


    @Test
    public void checkVolvo240Color() {assertEquals(Color.black.toString(), volvo240.getColor());}

    @Test
    public void checkSaab95Color() {assertEquals(Color.red.toString(), saab95.getColor());}

    @Test
    public void checkVolvo240GetNrDoors() {assertEquals(4, volvo240.getNrDoors());}

    @Test
    public void checkSaab95GetNrDoors() {assertEquals(2, saab95.getNrDoors());}

    @Test
    public void startEngine() {
        volvo240.stopEngine();
        volvo240.startEngine();
        assertEquals(1, volvo240.getSpeed(), 0);
    }

    @Test
    public void checkTurboOn() {
        saab95.setTurboOn();
        assertEquals(true, saab95.isTurboOn());
    }

    @Test
    public void checkTurboOff() {
        saab95.setTurboOff();
        assertEquals(false, saab95.isTurboOn());
    }

    @Test
    public void moveVolvotwo () {
        volvo240two.move();
        assertEquals(20, volvo240two.getXCord(), 0);
    }

    @Test
    public void moveSaabtwo () {
        saab95two.move();
        assertEquals(40, saab95two.getYCord(), 0);
    }

}
