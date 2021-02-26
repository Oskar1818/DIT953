
import java.awt.*;

public class VFactory {

    //public VFactory(){}

    public MotorizedVehicle createVolvo240() {
        return new Volvo240(Color.red, new Point(0,0), Direction.WEST);
    }

    public Saab95 createSaab95() {
        return new Saab95(Color.BLACK, new Point(0,200), Direction.EAST);
    }

    public Scania createScania() {
        return new Scania(Color.red, new Point(0,400), Direction.EAST, 10);
    }

}


// interface Production <- Volvo240 <- Saab95
// Production.move()
