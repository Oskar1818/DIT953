public interface IStorable<T> {

    T getObject();

    void addObject(T obj);
}
