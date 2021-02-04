import java.awt.*;
import java.util.ArrayList;

public class Workshop<T extends Vehicle>{ // implements ILoader/IStore
    private final int capacity;
    private final ArrayList<T> workshop;

    Workshop(int capacity){
        this.capacity = capacity;
        workshop = new ArrayList<>(capacity);
    }

    public void addVehicle(T vehicle){
        if (workshop.size() < capacity)
            workshop.add(vehicle);
        else
            System.out.println("CarWorkshop is full!");
    }

    public T getVehicle(T vehicle){ // the car should be specified... But how do you get something that you don't necessarily have a name on.
        int i = workshop.indexOf(vehicle);
        if (i != -1)
            return workshop.get(i);
        else
            return null;
    }

    /* not sure if necessary
    public void removeVehicle(){

    }
    */

    public int getCapacity(){ return capacity; }

    public static void main(String[] args){
        Workshop<Volvo240> volvo240CarWorkshop = new Workshop<>(10);
        Volvo240 volvo240 = new Volvo240(Color.BLACK, new Point(10,10), Direction.EAST);
        volvo240CarWorkshop.addVehicle(volvo240);
        //volvo240CarWorkshop.addCar(new Saab95(Color.BLACK, new Point(10,10), Direction.EAST));
        // Generates a compile error ^, which is what we want.

        Workshop<Car> carWorkshop = new Workshop<>(20);
        Saab95 saab95 = new Saab95(Color.BLACK, new Point(10,10), Direction.EAST);
        carWorkshop.addVehicle(saab95);
        carWorkshop.addVehicle(volvo240);
    }
}
