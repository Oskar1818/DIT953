import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class TestTransport {

    public Scania scania;
    public MercedesActros carTransport;
    public Volvo240 volvo240;
    public Saab95 saab95;

    @Before
    public void setUp() {
        scania = new Scania(Color.red, new Point(0,0), Direction.WEST, 10);
        //scania.setSpeed(10);
        carTransport = new MercedesActros(Color.blue, new Point(0,0), Direction.NORTH, 20);
        volvo240 = new Volvo240(Color.green, new Point(0,0), Direction.NORTH);
        saab95 = new Saab95(Color.yellow, new Point(1,1), Direction.NORTH);


    }

    @Test
    public void CheckScaniaMove() {
        scania.setSpeed(0);
        scania.setRampAngle(10);
        assertEquals(0, scania.getXCord(),0);
    }

    @Test
    public void CheckScaniaMove2() {
        scania.move();
        assertEquals(-10, scania.getXCord(),0);
    }

    @Test
    public void TestSetBedAngle() {
        scania.stopEngine();
        scania.setRampAngle(90);
        assertEquals(70, scania.getRampAngle(), 0);
    }

    @Test
    public void TestIsRampDown() {
        scania.setSpeed(20);
        assertEquals(false, scania.isRampDown());
    }

    @Test
    public void checkMercedesActrosMove() {
        carTransport.setRampDown();
        carTransport.setSpeed(20);
        carTransport.move();
        assertEquals(0, carTransport.getYCord(), 0);
    }

    @Test
    public void loadMercedesActros() {
        carTransport.addLoad(volvo240);
        assertEquals(carTransport.unload(), volvo240);
    }

    @Test
    public void orderOfUnloadingMercedes() {
        carTransport.addLoad(volvo240);
        carTransport.addLoad(saab95);
        assertEquals(carTransport.unload(), saab95);
    }

    // Generates compile time error
    /*@Test
    public void dontLoadYourself() {
        carTransport.addLoad(carTransport);
    }
*/

    @Test
    public void doesTheCarFollowItsTransporter() {
        carTransport.addLoad(volvo240);
        carTransport.gas(1);
        carTransport.move();
        assertEquals(carTransport.getYCord(), volvo240.getYCord(), 0);
    }

}

