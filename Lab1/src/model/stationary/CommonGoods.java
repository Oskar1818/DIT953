package model.stationary;

import model.interfaces.ITransportable;
import model.vehicle.Direction;

public class CommonGoods implements ITransportable {
    @Override
    public CommonGoods setXCord(double x) {
        return null;
    }

    @Override
    public CommonGoods setYCord(double y) {
        return null;
    }

    @Override
    public double getXCord() {
        return 0;
    }

    @Override
    public double getYCord() {
        return 0;
    }

    @Override
    public CommonGoods setDirection(Direction d) {
        return null;
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public Direction getOppositeDirection(Direction direction) {
        return null;
    }
}
