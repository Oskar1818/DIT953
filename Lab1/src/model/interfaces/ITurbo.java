package model.interfaces;

public interface ITurbo {

    boolean isTurboOn();

    ITurbo setTurboOn();

    ITurbo setTurboOff();

    double getTurboPower();

    ITurbo createVehicleWithTurbo(boolean state);

    ITurbo speedSetter(double speed);

}
