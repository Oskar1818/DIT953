import java.awt.*;

public class MercedesActros extends VehicleTransporter<Car> {

    public MercedesActros(Color color, Point point, Direction dir, int capacity){
        super(color, 725, 2, "MercedesActros", point, dir, capacity);
        stopEngine();
    }

    @Override
    public void loadTransporter(Car vehicle){
        if (!isRampOpen())
            System.out.println("Ramp must be open!");
        else{
            if (getYCord() - vehicle.getXCord() > 1 | getLoadSize() - 1 >= getCapacity())
                System.out.println("Must move car closer");
            else {
                addLoad(vehicle);
                vehicle.setXCord(getXCord());
                vehicle.setYCord(getYCord());
            }
        }
    }

    @Override
    public void unloadTransporter(){

    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    // could probably be moved to super class

}
