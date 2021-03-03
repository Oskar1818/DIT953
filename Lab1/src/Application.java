import controller.CarController;
import production.Production;
import production.VFactory;
import view.CarView;
import view.InfoView;

import static production.Production.production;

public class Application {

    public static void main(String[] args){
        VFactory factory = new VFactory();

        //Production productionVehicles = new Production();

        production().addSaab95(factory.createSaab95());
        production().addVolvo240(factory.createVolvo240());
        production().addScania(factory.createScania());

        CarView view = new CarView("CarSim 1.1");
        InfoView secondView = new InfoView();
        CarController controller = new CarController(view);

        production().addObserver(view);
        production().addObserver(secondView);

        production().timer.start();
    }
}
