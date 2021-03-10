package production;

import model.interfaces.ITurbo;
import model.vehicle.MotorizedVehicle;
import model.vehicle.transporter.Transporter;

import java.util.ArrayList;

public interface IProduction {

    void move();
    void gas(int amount);
    void brake(int amount);
    void turboOn();
    void turboOff();
    void liftBed();
    void lowerBed();
    void startAll();
    void stopAll();
}
