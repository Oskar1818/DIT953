import controller.CarController;
import production.ImmutableProduction;
import production.Production;
import view.CarView;
import view.InfoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {

    private static Production production = new Production();
    private static final CarView view = new CarView("CarSim 1.1");
    private static final InfoView secondView = new InfoView();

    final int delay = 50;
    //Timer timer = new Timer(delay, new TimerListener());


    private Application(Production production) {
        Application.production = production;
    }

    private static Application app() { return new Application(production); }

    private void obtainState(Production p) {
        production = p;
    }

    public static void main(String[] args){
        Application app = new Application(production);
        ImmutableProduction production = new ImmutableProduction();
        CarController controller = new CarController(production.getView(), production.getProduction());
        production.getProduction().timer.start();


        /*app().obtainState(production.addSaab95().addScania().addVolvo240().addPositionObserver(view)
                                    .addInfoObserver(secondView));
        app().timer.start();*/
    }

    /*private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            app().obtainState(production.move().collisionDetection());
            controller.addButtonFunctionality(view, production);
            System.out.println(production.getPositions().toString());
            System.out.println(production.getPositions().toString());
            production.notifyPositionObservers(production.getPositions());
            production.notifyInformationObservers(production.getInformation());
            production.getPositions().clear();
            production.getInformation().clear();
        }
    }*/

}
