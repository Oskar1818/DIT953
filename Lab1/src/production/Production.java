package production;

import model.*;
import production.IProduction;

import java.util.ArrayList;

public class Production implements IProduction {

    /*private ArrayList<model.ITurbo> turbos;
    private ArrayList<model.ITransporter<model.CommonGoods>> transporters;
    private ArrayList<ArrayList<production.IProduction>> vehicleList;*/

    // perhaps a map?

    // TODO should be an abstraction (interface) not an abstract class such as model.Vehicle

    /* TODO cannot rely on abstraction model.ITransporter bs it doesn't define the methods with ramps, think about creating a
    interface */

    // We could make all the lists contain some abstraction, for instance model.MotorizedVehicle, but then we can't have
    // compile time checking of the correct type of model.Vehicle in the correct list, e.g. a volvo could be added to turbos.

    private ArrayList<MotorizedVehicle> vehicles;
    private ArrayList<ITurbo> turbos; //model.ITurbo
    private ArrayList<Transporter> transporters; //model.Transporter

    public Production() {
        this.vehicles = new ArrayList<>();
        this.turbos = new ArrayList<>();
        this.transporters = new ArrayList<>();
    }

    public void addSaab95(Saab95 saab){
        vehicles.add(saab);
        turbos.add(saab);
    }

    public void addVolvo240(MotorizedVehicle volvo) {
        vehicles.add(volvo);
    }

    public void addScania(Scania scania) {
        vehicles.add(scania);
        transporters.add(scania);
    }

    public ArrayList<MotorizedVehicle> getVehicleList() {
        return vehicles;
    }

    public ArrayList<ITurbo> getTurboList() {
        return turbos;
    }

    public ArrayList<Transporter> getTransporterList() {
        return transporters;
    }

    @Override
    public String getName() {
        return null;
    }

}
