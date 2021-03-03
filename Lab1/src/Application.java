import controller.CarController;
import production.Production;
import production.VFactory;
import view.CarView;
import view.InfoView;

public class Application {

    public static void main(String[] args){
        VFactory factory = new VFactory();

        Production productionVehicles = new Production();

        productionVehicles.addSaab95(factory.createSaab95());
        productionVehicles.addVolvo240(factory.createVolvo240());
        productionVehicles.addScania(factory.createScania());

        CarView view = new CarView("CarSim 1.1");
        InfoView secondView = new InfoView();
        CarController controller = new CarController(view, productionVehicles);

        productionVehicles.addPositionObserver(view);
        productionVehicles.addInfoObserver(secondView);

        productionVehicles.timer.start();
    }
}
