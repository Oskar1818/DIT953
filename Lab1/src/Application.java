import java.util.ArrayList;
import java.awt.*;

public class Application {

    public static void main(String[] args){
        VFactory factory = new VFactory();

        Production productionVehicles = new Production();

        productionVehicles.addSaab95(factory.createSaab95());
        productionVehicles.addVolvo240(factory.createVolvo240());
        productionVehicles.addScania(factory.createScania());


        CarView view = new CarView("CarSim 1.1");
        CarController controller = new CarController(view, productionVehicles);
        //controller.addButtonFunctionality();

        controller.timer.start();

    }

}
