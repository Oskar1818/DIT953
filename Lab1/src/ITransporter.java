public interface ITransporter<T extends ITransportable> {

    void addLoad(T object);

    T unload();

    void loadTransporter(T object);

    void unloadTransporter();

    int getLoadSize();
}
