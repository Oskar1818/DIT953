import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class SSBadger extends VehicleTransporter<Car> {

    public SSBadger(Color color, Point point, Direction dir, int capacity){
        super(color, 1000, 10, "SSBadger", point, dir, capacity);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void loadTransporter(Car car) {

    }

    @Override
    public void unloadTransporter() {

    }

}
