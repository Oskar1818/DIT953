import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends ICar> {
    private int capacity;
    /*private List<Volvo240> volvoWorkshop = new ArrayList<>();
    private List<Saab95> saabWorkshop = new ArrayList<>(); */
    private List<T> workshop = new ArrayList<>();

    Workshop(int capacity){
        workshop = new ArrayList<>(capacity);
    }

    public void addCar(T car){
        if (workshop.size() < capacity)
            workshop.add(car);
        else
            System.out.println("Workshop is full!");
    }

    public static void main(String[] args){
        Workshop<Volvo240> volvo240Workshop = new Workshop<>(10);
        volvo240Workshop.addCar(new Saab95(Color.BLACK, new Point(10,10), Direction.EAST));

    }
}
