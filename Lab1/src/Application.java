import controller.CarController;
import production.Production;
import view.CarView;
import view.InfoView;

public class Application {

    public static void main(String[] args){

        Production productionVehicles = new Production();

        productionVehicles.addSaab95();
        productionVehicles.addVolvo240();
        productionVehicles.addScania();

        CarView view = new CarView("CarSim 1.1");
        InfoView secondView = new InfoView();
        CarController controller = new CarController(view, productionVehicles);

        productionVehicles.addPositionObserver(view);
        productionVehicles.addInfoObserver(secondView);
        productionVehicles.timer.start();
    }
}
