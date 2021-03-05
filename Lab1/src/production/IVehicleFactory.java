package production;

import model.interfaces.ITurbo;
import model.vehicle.Direction;
import model.vehicle.MotorizedVehicle;
import model.vehicle.transporter.Transporter;

import java.awt.*;

public interface IVehicleFactory {
    ITurbo createSaab95(Point position, Direction direction);
    MotorizedVehicle createVolvo240(Point position, Direction direction);
    Transporter createScania(Point position, Direction direction);
}
