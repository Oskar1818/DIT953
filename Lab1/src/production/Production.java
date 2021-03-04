package production;

import model.interfaces.ITurbo;
import model.vehicle.MotorizedVehicle;
import model.vehicle.car.Saab95;
import model.vehicle.transporter.Scania;
import model.vehicle.transporter.Transporter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Production implements IProduction, IObservable {

    private final ArrayList<MotorizedVehicle> vehicles;
    private final ArrayList<ITurbo> turbos;
    private final ArrayList<Transporter> transporters;
    private final ArrayList<IPositionObserver> positionObservers;
    private final ArrayList<IInfoObserver> informationObservers;
    private final ArrayList<Tuple<String, Point>> positions;
    private final ArrayList<Tuple<String, Integer>> information;

    private final int delay = 50;
    private final VehicleFactory factory = new VehicleFactory();

    // The delay (ms) corresponds to 20 updates a sec (hz)
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
        Saab95 saab = factory.createSaab95(Randomizer.randPos(), Randomizer.randDir());
        vehicles.add(saab);
        turbos.add(saab);
    }

    public void addVolvo240() {
        vehicles.add(factory.createVolvo240(Randomizer.randPos(), Randomizer.randDir()));
    }

    public void addScania() {
        Scania scania = factory.createScania(Randomizer.randPos(), Randomizer.randDir());
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
            notifyPositionObservers(getPositions());
            notifyInformationObservers(getInformation());
            move();
            notifyPositionObservers(getPositions());
            notifyInformationObservers(getInformation());
            positions.clear();
            information.clear();
        }
    }

    // is it necessary to have error handling here, for instance if there is no cars in the list
    @Override
    public void move() { vehicles.forEach(MotorizedVehicle::move); }

    @Override
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        vehicles.forEach( v -> v.gas(gas));
    }
    @Override
    public void brake(int amount) {
        double brake = ((double) amount / 100);
        vehicles.forEach( v -> v.brake(brake));
    }

    @Override
    public void turboOn() { turbos.forEach(ITurbo::setTurboOn); }

    @Override
    public void turboOff() { turbos.forEach(ITurbo::setTurboOff); }

    @Override
    public void liftBed() { transporters.forEach(Transporter::setRampUp); }

    @Override
    public void lowerBed() {transporters.forEach(Transporter::setRampDown); }

    @Override
    public void startAll() {
        vehicles.forEach(MotorizedVehicle::startEngine);
    }

    @Override
    public void stopAll() {
        vehicles.forEach(MotorizedVehicle::stopEngine);
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
            if (v.getXCord() < 0 || v.getXCord() > 700 || v.getYCord() < 0 || v.getYCord() > 700 - 200) {
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
}
