package production;

import model.interfaces.ITurbo;
import model.vehicle.MotorizedVehicle;
import model.vehicle.transporter.Transporter;
import view.IInfoObserver;
import view.IPositionObserver;

import javax.swing.*;
//import java.awt.*;
import point.Point;
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
    ImmutableProduction immutableProduction = new ImmutableProduction();

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

    private Production(ArrayList<MotorizedVehicle> vehicles, ArrayList<ITurbo> turbos,
                       ArrayList<Transporter> transporters, ArrayList<IPositionObserver> pObservers,
                       ArrayList<IInfoObserver> iObservers)
    {
        this.vehicles = vehicles;
        this.turbos = turbos;
        this.transporters = transporters;
        this.positionObservers = pObservers;
        this.informationObservers = iObservers;
        this.positions = new ArrayList<>();
        this.information = new ArrayList<>();
    }

    private Production(Production p){
        this.vehicles = p.vehicles;
        this.turbos = p.turbos;
        this.transporters = p.transporters;
        this.positionObservers = p.positionObservers;
        this.informationObservers = p.informationObservers;
        this.positions = p.positions;
        this.information = p.information;
        this.timer = p.timer;
    }

    public Production addSaab95(){
        ITurbo saab = factory.createSaab95(Randomizer.randPos(), Randomizer.randDir());
        ArrayList<MotorizedVehicle> copy1 = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++){ copy1.add(i, vehicles.get(i)); }
        copy1.add((MotorizedVehicle) saab);
        ArrayList<ITurbo> copy2 = new ArrayList<>();
        for (int i = 0; i < turbos.size(); i++){ copy2.add(i, turbos.get(i)); }
        copy2.add(saab);
        return new Production(copy1, copy2, transporters, positionObservers, informationObservers);
    }

    public Production addVolvo240() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++){ copy.add(i, vehicles.get(i)); }
        copy.add(factory.createVolvo240(Randomizer.randPos(), Randomizer.randDir()));
        return new Production(copy, turbos, transporters, positionObservers, informationObservers);
    }

    public Production addScania() {
        Transporter scania = factory.createScania(Randomizer.randPos(), Randomizer.randDir());
        ArrayList<MotorizedVehicle> copy1 = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) copy1.add(i, vehicles.get(i));
        copy1.add(scania);
        ArrayList<Transporter> copy2 = new ArrayList<>();
        for (int i = 0; i < transporters.size(); i++) copy2.add(i, transporters.get(i));
        copy2.add(scania);
        return new Production(copy1, turbos, copy2, positionObservers, informationObservers);
    }

    @Override
    public Production addInfoObserver(IInfoObserver observer) {
        ArrayList<IInfoObserver> copy = new ArrayList<>(informationObservers);
        copy.add(observer);
        return new Production(vehicles, turbos, transporters, positionObservers, copy);
    }

    @Override
    public Production addPositionObserver(IPositionObserver observer) {
        ArrayList<IPositionObserver> copy = new ArrayList<>(positionObservers);
        copy.add(observer);
        return new Production(vehicles, turbos, transporters, copy, informationObservers);

    }

    @Override
    public Production removePositionObserver(IPositionObserver observer) {
        ArrayList<IPositionObserver> copy = new ArrayList<>(positionObservers);
        copy.remove(observer);
        return new Production(vehicles, turbos, transporters, copy, informationObservers);
    }

    @Override
    public Production removeInformationObserver(IInfoObserver observer) {
        ArrayList<IInfoObserver> copy = new ArrayList<>(informationObservers);
        copy.remove(observer);
        return new Production(vehicles, turbos, transporters, positionObservers, copy);
    }

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
            immutableProduction.receiveProduction(new Production(move().collisionDetection()));
            System.out.println("Hello");
            notifyPositionObservers(getPositions());
            notifyInformationObservers(getInformation());
            positions.clear();
            information.clear();
        }
    }

    // is it necessary to have error handling here, for instance if there is no cars in the list
    @Override
    public Production move() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            copy.add(i, (MotorizedVehicle) vehicles.get(i).move());
        }
        return new Production(copy, turbos, transporters, positionObservers, informationObservers);
    }

    @Override
    public Production gas(int amount) {
        double gas = ((double) amount) / 100;
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            copy.add(i, (MotorizedVehicle) vehicles.get(i).gas(gas));
        }
        return new Production(copy, turbos, transporters, positionObservers, informationObservers);
    }
    @Override
    public Production brake(int amount) {
        double brake = ((double) amount / 100);
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            copy.add(i, (MotorizedVehicle) vehicles.get(i).brake(brake));
        }
        return new Production(copy, turbos, transporters, positionObservers, informationObservers);
    }

    @Override
    public Production turboOn() {
        ArrayList<ITurbo> copy = new ArrayList<>();
        for (int i = 0; i < turbos.size(); i++) copy.add(i, turbos.get(i));
        copy.forEach(ITurbo::setTurboOn);
        return new Production(vehicles, copy, transporters, positionObservers, informationObservers);
    }

    @Override
    public Production turboOff() {
        ArrayList<ITurbo> copy = new ArrayList<>();
        for (int i = 0; i < turbos.size(); i++) copy.add(i, turbos.get(i));
        copy.forEach(ITurbo::setTurboOff);
        return new Production(vehicles, copy, transporters, positionObservers, informationObservers);
    }

    @Override
    public Production liftBed() {
        ArrayList<Transporter> copy = new ArrayList<>();
        copy.forEach(Transporter::setRampUp);
        return new Production(vehicles, turbos, copy, positionObservers, informationObservers);
    }

    @Override
    public Production lowerBed() {
        ArrayList<Transporter> copy = new ArrayList<>();
        for (int i = 0; i < transporters.size(); i++) copy.add(i, transporters.get(i));
        copy.forEach(Transporter::setRampDown);
        return new Production(vehicles, turbos, copy, positionObservers, informationObservers);
    }

    @Override
    public Production startAll() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) copy.add(i, vehicles.get(i));
        copy.forEach(MotorizedVehicle::startEngine);
        return new Production(copy, turbos, transporters, positionObservers, informationObservers);
    }

    @Override
    public Production stopAll() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) copy.add(i, vehicles.get(i));
        copy.forEach(MotorizedVehicle::stopEngine);
        return new Production(copy, turbos, transporters, positionObservers, informationObservers);
    }

    public Production removeVehicle() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) copy.add(i, vehicles.get(i));
        if (copy.size() > 0) copy.remove(0);
        return new Production(copy, turbos, transporters, positionObservers, informationObservers);
    }

    public void addRandomVehicle() {
        ArrayList<MotorizedVehicle> copy = new ArrayList<>(vehicles);
        if (copy.size() < 10) {
            int rnd = new Random().nextInt(3);
            switch (rnd) {
                case 0 -> addVolvo240();
                case 1 -> addSaab95();
                case 2 -> addScania();
            }
        }
    }

    public Production collisionDetection(){
        ArrayList<MotorizedVehicle> copy = new ArrayList<>(vehicles);
        copy.forEach(v -> {
            if (v.getXCord() < 0 || v.getXCord() > 700 || v.getYCord() < 0 || v.getYCord() > 500) {
                v.setDirection(v.getOppositeDirection(v.getDirection()));
            }
        });
        return new Production(copy, turbos, transporters, positionObservers, informationObservers);
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