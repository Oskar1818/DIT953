package production;

import controller.CarController;
import view.CarView;
import view.InfoView;

public final class ImmutableProduction {

    private final CarView view = new CarView("CarSim 1.1");
    private final InfoView secondView = new InfoView();
    private final Production production = new Production();

    public ImmutableProduction() {
        init();
        new CarController(view, production);
    }

    private void init() {
        production.addSaab95();
        production.addVolvo240();
        production.addScania();
        production.addPositionObserver(view);
        production.addInfoObserver(secondView);
    }

    public Production getProduction() {
        return this.production;
    }

}
