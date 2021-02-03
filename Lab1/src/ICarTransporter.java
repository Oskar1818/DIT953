
// It could be better to have a more general interface "VehicleTransporter", where you use type parameters instead.
// not quite sure how to implement though.
public interface ICarTransporter extends IVehicle {
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

    void loadTransport(ICar car);

    void unloadTransport();
}
