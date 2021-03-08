package production;

import model.interfaces.ITurbo;
import model.vehicle.MotorizedVehicle;
import model.vehicle.transporter.Transporter;

import java.util.ArrayList;

public interface IProduction {

    IProduction move();
    IProduction gas(int amount);
    IProduction brake(int amount);
    IProduction turboOn();
    IProduction turboOff();
    IProduction liftBed();
    IProduction lowerBed();
    IProduction startAll();
    IProduction stopAll();
}
