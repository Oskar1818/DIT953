import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> {
    private int capacity;
    private ArrayList<T> workshop;

    Workshop(int capacity){
        this.capacity = capacity;
        workshop = new ArrayList<>(capacity);
    }

    public void addCar(T car){
        if (workshop.size() < capacity)
            workshop.add(car);
        else
            System.out.println("Workshop is full!");
    }

    public T getCar(T car){ // the car should be specified... But how do you get something that you don't necessarily have a name on.
        int i = workshop.indexOf(car);
        if (i != -1)
            return workshop.get(i);
        else
            return null;
    }

    public int getCapacity(){ return capacity; }

    public static void main(String[] args){
        Workshop<Volvo240> volvo240Workshop = new Workshop<>(10);
        Volvo240 volvo240 = new Volvo240(Color.BLACK, new Point(10,10), Direction.EAST);
        volvo240Workshop.addCar(volvo240);
        //volvo240Workshop.addCar(new Saab95(Color.BLACK, new Point(10,10), Direction.EAST));
        // Generates a compile error ^, which is what we want.
        volvo240Workshop.getCar(volvo240);

        Workshop<Car> carWorkshop = new Workshop<>(20);
        Saab95 saab95 = new Saab95(Color.BLACK, new Point(10,10), Direction.EAST);
        carWorkshop.addCar(saab95);
        carWorkshop.addCar(volvo240);
    }
}
