public interface ILoadable<T> {

    T getObject();

    void addObject(T obj);
}
