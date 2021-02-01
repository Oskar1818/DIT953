public interface ICar extends IVehicle {

    /**
     * @return Returns the number of doors the car has.
     */
    int getNrDoors();

    /**
     * @return Returns the engine power of the car.
     */
    double getEnginePower();

    /**
     * Starts the engine and sets the initial speed to 1.
     */
    void startEngine();

    /**
     * Stops the engine, which makes the car stop.
     */
    void stopEngine();
}
