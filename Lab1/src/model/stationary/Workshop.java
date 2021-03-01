package model.stationary;

import model.interfaces.IStationary;
import model.interfaces.IStorable;
import model.vehicle.Vehicle;

import java.awt.*;
import java.util.ArrayList;

/**
 * The class representing a workshop that can store vehicles.
 * @param <T> The specified type parameter of which Vehicles that could be stored in a specific workshop.
 */
public class Workshop<T extends Vehicle> implements IStationary, IStorable<T> {

    private final int capacity;
    private final ArrayList<T> workshop; // The data structure representing the storage.
    private final Point location;

    /**
     * @param capacity The maximum amount of vehicles that the workshop can store.
     * @param location The static (not movable) location of the workshop.
     */
    public Workshop(int capacity, Point location){
        this.capacity = capacity;
        workshop = new ArrayList<>(capacity);
        this.location = location;
    }

    public void addVehicle(T v){
        if (workshop.size() < capacity && ((getYCord() - v.getYCord() <= 1 && getXCord() - v.getXCord() <= 1)))
            workshop.add(v);
        else
            System.out.println("Cannot store your vehicle!");
    }

    // The workshop is designed in a manner which does not allow any cars of wrong type to be placed in a workshop
    // and the same goes for vehicles, e.g. you cannot add a Truck to a workshop that only allows cars.
    // This implies that the type of vehicles that you can get out from a workshop is as general or as narrow as the
    // list is defined, which prevents any unwanted side effects. A faulty vehicle (type) is identified at compile time.
    public T getVehicle(T vehicle){
        int i = workshop.indexOf(vehicle);
        return i != -1 ? workshop.get(i) : null;
    }


    public int getCapacity(){ return capacity; }

    @Override
    public double getYCord() {
        return this.location.getY();
    }

    @Override
    public double getXCord() {
        return this.location.getX();
    }

    @Override
    public void putObject(T object) {

    }

    @Override
    public T getObject() {
        return null;
    }
}
