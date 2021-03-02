import controller.CarController;
import production.Production;
import production.VFactory;
import view.CarView;

import static production.Production.production;

public class Application {

    public static void main(String[] args){
        VFactory factory = new VFactory();

        //Production productionVehicles = new Production();

        production().addSaab95(factory.createSaab95());
        production().addVolvo240(factory.createVolvo240());
        production().addScania(factory.createScania());

        CarView view = new CarView("CarSim 1.1");
        CarController controller = new CarController(view, production());

        production().addObserver(view);
        production().timer.start();
    }
}
