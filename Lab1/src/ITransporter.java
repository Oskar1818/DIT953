public interface ITransporter<T extends ITransportable> {

    void addLoad(T object);

    void unload();

    void loadTransporter(T object);

    void unloadTransporter();

    int getLoadSize();
}
