package model.interfaces;

import model.vehicle.Direction;

public interface ITransportable {

    ITransportable setXCord(double x);

    ITransportable setYCord(double y);

    double getXCord();

    double getYCord();

    ITransportable setDirection(Direction d);

    Direction getDirection();

    Direction getOppositeDirection(Direction direction);

}
