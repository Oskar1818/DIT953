package model.interfaces;

import model.vehicle.Direction;

public interface ITransportable {

    void setXCord(double x);

    void setYCord(double y);

    double getXCord();

    double getYCord();

    void setDirection(Direction d);

    Direction getDirection();

    Direction getOppositeDirection(Direction direction);

}
