import java.awt.*;

public class SSBadger extends Transporter<Car> {

    /**
     * A ferry
     * @param color
     * @param point
     * @param dir
     * @param capacity
     */
    public SSBadger(Color color, Point point, Direction dir, int capacity){
        super(color, 1000, 10, "SSBadger", point, dir, capacity);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void addLoad(Car car){
        if (!isRampDown()){
            if (getYCord() - car.getXCord() > 1 | getLoadSize() - 1 >= getCapacity())
                System.out.println("Must move car closer");
            else {
                getLoad().add(car);
                car.setXCord(getXCord());
                car.setYCord(getYCord());
            }
        }
        else
            System.out.println("Ramp must be open!");
    }

    @Override
    public Car unload(){
        if (getLoadSize() > 0 && !isRampDown()) {
            Car car = getLoad().getFirst();
            car.setXCord(car.getXCord() + 1); // why?
            car.setYCord(car.getYCord() + 1);
            return car;
        }
        System.out.println("The load is empty");
        return null;
    }

}
