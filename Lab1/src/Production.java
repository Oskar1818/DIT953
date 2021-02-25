import java.util.ArrayList;
import java.util.Map;

public class Production implements IProduction {

    /*private ArrayList<ITurbo> turbos;
    private ArrayList<ITransporter<CommonGoods>> transporters;
    private ArrayList<ArrayList<IProduction>> vehicleList;*/

    // perhaps a map?

    // TODO should be an abstraction (interface) not an abstract class such as Vehicle

    /* TODO cannot rely on abstraction ITransporter bs it doesn't define the methods with ramps, think about creating a
    interface */

    private ArrayList<MotorizedVehicle> vehicles;
    private ArrayList<ITurbo> turbos;
    private ArrayList<Transporter> transporters;

    public Production() {
        this.vehicles = new ArrayList<>();
        this.turbos = new ArrayList<>();
        this.transporters = new ArrayList<>();
    }

    public void addSaab95(Saab95 saab){
        vehicles.add(saab);
        turbos.add(saab);
    }

    public void addVolvo240(Volvo240 volvo) {
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
