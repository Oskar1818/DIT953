package production;

import model.interfaces.ITurbo;
import model.vehicle.*;
import model.vehicle.car.Saab95;
import model.vehicle.car.Volvo240;
import model.vehicle.transporter.Scania;
import model.vehicle.transporter.Transporter;

import java.awt.Color;
import point.Point;

public class VehicleFactory implements IVehicleFactory {

    public MotorizedVehicle createVolvo240(Point p, Direction dir) {
        return new Volvo240(Color.red, p, dir);
    }

    public ITurbo createSaab95(Point p, Direction dir) {
        return new Saab95(Color.BLACK, p, dir);
    }

    public Transporter createScania(Point p, Direction dir) {
        return new Scania(Color.red, p, dir, 10);
    }
}
