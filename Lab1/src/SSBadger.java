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
        if (isRampOpen()) {
            if (getYCord() - car.getXCord() > 1 | getLoadSize() - 1 >= getCapacity())
                System.out.println("Must move car closer");
            else {
                addLoad(car);
                car.setXCord(getXCord());
                car.setYCord(getYCord());
            }
        }
        else
            System.out.println("Ramp must be open!");

    }

    @Override
    public void unloadTransporter() {

    }

}
