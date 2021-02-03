import java.awt.*;

public class MercedesActros extends VehicleTransporter<Car> {

    public MercedesActros(Color color, Point point, Direction dir, int capacity){
        super(color, 725, 2, "MercedesActros", point, dir, capacity);
        stopEngine();
    }

    @Override
    public void loadTransporter(Car car){
        if (isRampOpen()){
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
    public void unloadTransporter(){
        if (getLoadSize() > 0 && isRampOpen())
            unload();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    // could probably be moved to super class

}
