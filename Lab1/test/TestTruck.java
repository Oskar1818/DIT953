import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class TestTruck {

    public Scania scania;

    @Before
    public void setUp() {
        scania = new Scania(Color.red, new Point(0,0), Direction.WEST, 10);
        scania.setSpeed(10);
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
}

