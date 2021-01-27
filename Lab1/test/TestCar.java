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
        volvo240.setCurrentSpeed(10);
        volvo240.move();
        assertEquals(20, volvo240.getYCord(), 0);
    }

    @Test
    public void moveSaab () {
        saab95.setCurrentSpeed(20);
        saab95.move();
        assertEquals(40, saab95.getYCord(), 0);
    }


    //@Test
    //public void checkGas() {assertEquals(1, )}


    @Test
    public void checkVolvo240Color() {assertEquals("black", volvo240.getColor());}

    @Test
    public void checkSaab95Color() {assertEquals("red", saab95.getColor());}



}
