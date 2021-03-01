package model.interfaces;

import java.util.Collection;

public interface ITransporter<T extends ITransportable> {

    void addLoad(T object);

    Collection<T> getLoad();

    T unload();

    int getLoadSize();
}
