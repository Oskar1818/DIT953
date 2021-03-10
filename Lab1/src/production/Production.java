package production;

import model.interfaces.ITurbo;
import model.vehicle.MotorizedVehicle;
import model.vehicle.car.Saab95;
import model.vehicle.transporter.Transporter;
import view.IInfoObserver;
import view.IPositionObserver;

import point.Point;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Production implements IProduction, IObservable {

    private ArrayList<MotorizedVehicle> vehicles;
    private ArrayList<ITurbo> turbos;
    private ArrayList<Transporter> transporters;
    private final ArrayList<IPositionObserver> positionObservers;
    private final ArrayList<IInfoObserver> informationObservers;
    private final ArrayList<Tuple<String, Point>> positions;
    private final ArrayList<Tuple<String, Integer>> information;

    private final VehicleFactory factory = new VehicleFactory();

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    public Timer timer = new Timer(delay, new TimerListener());

    public Production() {
        this.vehicles = new ArrayList<>();
        this.turbos = new ArrayList<>();
        this.transporters = new ArrayList<>();
        this.positionObservers = new ArrayList<>();
        this.informationObservers = new ArrayList<>();
        this.positions = new ArrayList<>();
        this.information = new ArrayList<>();
    }

    public void addSaab95(){
        ITurbo saab = factory.createSaab95(Randomizer.randPos(), Randomizer.randDir());
        vehicles.add((MotorizedVehicle) saab);
        turbos.add(saab);
    }

    public void addVolvo240() {
        vehicles.add(factory.createVolvo240(Randomizer.randPos(), Randomizer.randDir()));
    }

    public void addScania() {
        Transporter scania = factory.createScania(Randomizer.randPos(), Randomizer.randDir());
        vehicles.add(scania);
        transporters.add(scania);
    }

    @Override
    public void addInfoObserver(IInfoObserver observer) { informationObservers.add(observer); }

    @Override
    public void addPositionObserver(IPositionObserver observer) { positionObservers.add(observer); }

    @Override
    public void removePositionObserver(IPositionObserver observer) {
        positionObservers.remove(observer);
    }

    @Override
    public void removeInformationObserver(IInfoObserver obs) { informationObservers.remove(obs); }

    @Override
    public void notifyPositionObservers(ArrayList<Tuple<String, Point>> positions) {
        positionObservers.forEach( o -> o.update(positions));
    }

    @Override
    public void notifyInformationObservers(ArrayList<Tuple<String, Integer>> information) {
        informationObservers.forEach( o -> o.update(information));
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            collisionDetection();
            move();
            notifyPositionObservers(getPositions());
            notifyInformationObservers(getInformation());
            positions.clear();
            information.clear();
        }
    }

    @Override
    public void move() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            copy.add(i, (MotorizedVehicle) vehicles.get(i).move());
        }
        this.vehicles = copy;
    }

    @Override
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            copy.add(i, (MotorizedVehicle) vehicles.get(i).gas(gas));
        }
        this.vehicles = copy;
    }
    @Override
    public void brake(int amount) {
        double brake = ((double) amount / 100);
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            copy.add(i, (MotorizedVehicle) vehicles.get(i).brake(brake));
        }
        this.vehicles = copy;
    }

    @Override
    public void turboOn() {
        ArrayList<ITurbo> copy = new ArrayList<>();// this requires new createSaab methods with specified boolean
        double speed = getSaabSpeed();
        for (int i = 0; i < turbos.size(); i++){
            copy.add(i, turbos.get(i).setTurboOn());
        }
        this.turbos = copy;
    }

    @Override
    public void turboOff() {
        ArrayList<ITurbo> copy = new ArrayList<>();
        for (int i = 0; i < turbos.size(); i++){
            copy.add(i, turbos.get(i).setTurboOff());
        }
        this.turbos = copy;
    }

    @Override
    public void liftBed() {
        ArrayList<Transporter> copy = new ArrayList<>(); // this requires new createScania methods with specified bool
        for (int i = 0; i < transporters.size(); i++){
            copy.add(i, transporters.get(i).setRampUp());
        }
        this.transporters = copy;
    }

    @Override
    public void lowerBed() {
        ArrayList<Transporter> copy = new ArrayList<>();
        for (int i = 0; i < transporters.size(); i++){
            copy.add(i, transporters.get(i).setRampDown());
        }
        this.transporters = copy;
    }

    @Override
    public void startAll() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            copy.add(i, (MotorizedVehicle) vehicles.get(i).startEngine());
        }
        this.vehicles = copy;
    }

    @Override
    public void stopAll() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            copy.add(i, (MotorizedVehicle) vehicles.get(i).stopEngine());
        }
        this.vehicles = copy;
    }

    public void removeVehicle() { if (vehicles.size() > 0) vehicles.remove(0); }

    public void addRandomVehicle() {
        if (vehicles.size() < 10) {
            int rnd = new Random().nextInt(3);
            switch (rnd) {
                case 0 -> addVolvo240();
                case 1 -> addSaab95();
                case 2 -> addScania();
            }
        }
    }

    public void collisionDetection(){
        vehicles.forEach(v -> {
            if (v.getXCord() < 0 || v.getXCord() > 700 || v.getYCord() < 0 || v.getYCord() > 500) {
                v.setDirection(v.getOppositeDirection(v.getDirection()));
            }
        });
    }

    // Law of Demeter
    public ArrayList<Tuple<String, Point>> getPositions() {
        vehicles.forEach( v -> positions.add(
                new Tuple(v.getName(), new Point((int) v.getXCord(), (int) v.getYCord()))));
        return positions;
    }

    public ArrayList<Tuple<String, Integer>> getInformation() {
        vehicles.forEach( v -> information.add(
                new Tuple(v.getName(), v.getSpeed())));
        return information;
    }

    private double getSaabSpeed() {
        double saabSpeed = 0;
        for (MotorizedVehicle v : vehicles){
            if (v instanceof ITurbo)
                saabSpeed = v.getSpeed();
        }
        return saabSpeed;
    }

    private double getScaniaSpeed() {
        double scaniaSpeed = 0;
        for (MotorizedVehicle v : vehicles){
            if (v instanceof Transporter)
                scaniaSpeed= v.getSpeed();
        }
        return scaniaSpeed;
    }
}