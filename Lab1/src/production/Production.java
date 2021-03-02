package production;

import model.interfaces.ITurbo;
import model.vehicle.MotorizedVehicle;
import model.vehicle.car.Saab95;
import model.vehicle.transporter.Scania;
import model.vehicle.transporter.Transporter;
import view.IObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Production implements IProduction, IObservable {

    private final ArrayList<MotorizedVehicle> vehicles;
    private final ArrayList<ITurbo> turbos; //model.interfaces.ITurbo
    private final ArrayList<Transporter> transporters; //model.vehicle.transporter.Transporter
    private final ArrayList<IObserver> observers;
    private final HashMap<String, Point> positions;

    private final static Production production = new Production();

    private final int delay = 50;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    public Timer timer = new Timer(delay, new TimerListener());

    public static Production production() {
        return production;
    }

    public Production() {
        this.vehicles = new ArrayList<>();
        this.turbos = new ArrayList<>();
        this.transporters = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.positions = new HashMap<>();
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

    public ArrayList<MotorizedVehicle> getVehicleList() { return vehicles; }

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

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(IObserver::update);
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            collisionDetection();
            move();
            notifyObservers();
        }
    }

    // is it necessary to have error handling here, for instance if there is no cars in the list
    void move() {
        vehicles.forEach(MotorizedVehicle::move);
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        vehicles.forEach( v -> v.gas(gas));

    }

    public void brake(int amount) {
        double brake = ((double) amount / 100);
        vehicles.forEach( v -> v.brake(brake));
    }

    public void turboOn() {
        turbos.forEach(ITurbo::setTurboOn);
    }

    public void turboOff() { turbos.forEach(ITurbo::setTurboOff); }

    public void liftBed() { transporters.forEach(Transporter::setRampUp); }

    public void lowerBed() {transporters.forEach(Transporter::setRampDown); }

    public void startAll() {
        vehicles.forEach(MotorizedVehicle::startEngine);
    }

    public void stopAll() {
        vehicles.forEach(MotorizedVehicle::stopEngine);
    }

    public void collisionDetection(){
        vehicles.forEach(v -> {
            if (v.getXCord() < 0 || v.getXCord() > 700 || v.getYCord() < 0 || v.getYCord() > 700 - 200) {
                v.setDirection(v.getOppositeDirection(v.getDirection()));
            }
        });
    }

    // Law of Demeter
    public HashMap<String, Point> getPositions() {
        vehicles.forEach( v -> positions.put(
                v.getName(), new Point((int) v.getXCord(), (int) v.getYCord())));
        return positions;
    }
}
