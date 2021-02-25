import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class VehicleFactory {

    private ArrayList<Vehicle> vehicleList = new ArrayList<>();
    // this class should perhaps not have a list in itself. Instead create a list in the desired class and add cars
    // to it by calling this classes methods.


    public VehicleFactory() {
        vehicleList.add(addVolvo240());
        vehicleList.add(addSaab95());
        vehicleList.add(addScania());

        // vehicleList.add(addMercedesActros());
        // vehicleList.add(addMercedesBlueWonder());
        // vehicleList.add(addSSBadger());
    }

    private Car addVolvo240() {
        return new Volvo240(Color.red, new Point(0,0), Direction.EAST);
    }

    private Car addSaab95() {
        return new Saab95(Color.BLACK, new Point(0,0), Direction.EAST);
    }

    public Transporter addScania() {
        return new Scania(Color.red, new Point(0,0), Direction.EAST, 10);
    }

    // public getVolvo240


//    private Transporter addMercedesActros() {
//        return new MercedesActros(Color.BLACK, new Point(0,0), Direction.EAST);
//    }
//
//    private Transporter addMercedesBlueWonder() {
//        return new MercedesBlueWonder(Color.BLUE, new Point(0,0), Direction.EAST);
//    }
//
//    private Transporter addSSBanger() {
//        return new SSBadger(Color.YELLOW, new Point(0,0), Direction.EAST);
//    }


    public Vehicle randomVehicle() {
        int rnd = new Random().nextInt(vehicleList.size());
        return vehicleList.get(rnd);
    }


}
