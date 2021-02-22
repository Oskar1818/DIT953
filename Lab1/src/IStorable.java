public interface IStorable<T> {

    void putObject(T object);

    T getObject();

}
