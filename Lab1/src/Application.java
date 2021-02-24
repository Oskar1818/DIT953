import java.util.ArrayList;
import java.awt.*;

public class Application {

    public static void main(String[] args){
        VFactory factory = new VFactory();
        ArrayList<MotorizedVehicle> vehicleList = new ArrayList<>();

        vehicleList.add(factory.addVolvo240());
        vehicleList.add(factory.addScania());
        vehicleList.add(factory.addSaab95());

        CarView view = new CarView("CarSim 1.1");
        CarController controller = new CarController(view, vehicleList);
        //controller.addButtonFunctionality();


        controller.timer.start();





    }

}
