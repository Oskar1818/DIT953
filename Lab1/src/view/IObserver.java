package view;

import production.Tuple;
import java.util.ArrayList;

public interface IObserver<K, V>{
    void update(ArrayList<Tuple<K, V>> positions);
}
