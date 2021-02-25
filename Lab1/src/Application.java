import java.util.ArrayList;
import java.awt.*;

public class Application {

    public static void main(String[] args){
        VFactory factory = new VFactory();

        Production productionVehicles = new Production();

        productionVehicles.addSaab95(factory.addSaab95());
        productionVehicles.addVolvo240(factory.addVolvo240());
        productionVehicles.addScania(factory.addScania());


        CarView view = new CarView("CarSim 1.1");
        CarController controller = new CarController(view, productionVehicles);
        //controller.addButtonFunctionality();

        controller.timer.start();

    }

}
