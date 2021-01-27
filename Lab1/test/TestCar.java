import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */

public class TestCar {


    public Volvo240 volvo240;
    public Saab95 saab95;

    @Before
    public void setUp(){
        volvo240 = new Volvo240(Color.black, new Point(10, 10));
        saab95 = new Saab95(Color.red, new Point(30, 20));
        volvo240.setCurrentSpeed(10);
        saab95.setCurrentSpeed(20);
    }

   /* @Test
    public void nameCheck(){
        checkName(volvo240);
        checkName(saab95);
    }*/


    @Test
    public void checkVolvoName() {
        assertEquals("Volvo240", volvo240.getModelName());
    }

    @Test
    public void checkSaabName() {
        assertEquals("Saab95", saab95.getModelName());
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
        assertEquals(10.625, volvo240.getCurrentSpeed(), 0);
    }

    @Test
    public void checkSaabGas() {
        saab95.gas(3);
        assertEquals(21.25, saab95.getCurrentSpeed(), 0);
    }

    @Test
    public void checkVolvoBrake() {
        volvo240.brake(3);
        assertEquals(8.75, volvo240.getCurrentSpeed(), 0);
    }

    @Test
    public void checkSaabBrake() {
        saab95.brake(0.1);
        assertEquals(19.875, saab95.getCurrentSpeed(), 0);
    }

    /*@Test
    public void checkVolvo240LeftTurn() {assertEquals();}

    @Test
    public void checkSaab95LeftTurn() {assertEquals();}

    @Test
    public void checkVolvo240RightTurn() {assertEquals();}

    @Test
    public void checkSaab95RightTurn() {assertEquals();}*/


    @Test
    public void checkVolvo240Color() {assertEquals(Color.black.toString(), volvo240.getColor());}

    @Test
    public void checkSaab95Color() {assertEquals(Color.red.toString(), saab95.getColor());}

    @Test
    public void checkVolvo240GetNrDoors() {assertEquals(4, volvo240.getNrDoors());}

    @Test
    public void checkSaab95GetNrDoors() {assertEquals(2, saab95.getNrDoors());}

}
