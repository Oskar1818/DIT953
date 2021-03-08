package production;

import view.CarView;
import view.InfoView;

public final class ImmutableProduction {

    private final CarView view = new CarView("CarSim 1.1");
    private final InfoView secondView = new InfoView();

    private Production production = new Production().addSaab95().addVolvo240().addScania()
            .addPositionObserver(view).addInfoObserver(secondView);

    public Production getProduction() {
        return this.production;
    }

    public void receiveProduction(Production p) {
        this.production = p;
    }

    public CarView getView() {
        return this.view;
    }

}
