package production;

import model.vehicle.*;
import model.vehicle.car.Saab95;
import model.vehicle.car.Volvo240;
import model.vehicle.transporter.Scania;

import java.awt.*;

public class VFactory {

    //public production.VFactory(){}

    public MotorizedVehicle createVolvo240() {
        return new Volvo240(Color.red, new Point(0,0), Direction.WEST);
    }

    public Saab95 createSaab95() {
        return new Saab95(Color.BLACK, new Point(0,200), Direction.EAST);
    }

    public Scania createScania() {
        return new Scania(Color.red, new Point(0,400), Direction.NORTH, 10);
    }

}


// interface production.Production <- model.vehicle.car.Volvo240 <- model.vehicle.car.Saab95
// production.Production.move()
