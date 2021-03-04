package production;

import model.vehicle.*;
import model.vehicle.car.Saab95;
import model.vehicle.car.Volvo240;
import model.vehicle.transporter.Scania;

import java.awt.*;

public class VehicleFactory {

    public MotorizedVehicle createVolvo240(Point p) {
        int stockYCord = 0;
        return new Volvo240(Color.red, new Point(p.x, p.y), Direction.WEST);
    }

    public Saab95 createSaab95(Point p) {
        int stockYCord = 100;
        return new Saab95(Color.BLACK, new Point(p.x, p.y), Direction.EAST);
    }

    public Scania createScania(Point p) {
        int stockYCord = 200;
        return new Scania(Color.red, new Point(p.x, p.y), Direction.NORTH, 10);
    }
}
