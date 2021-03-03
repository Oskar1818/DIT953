package view;

import java.awt.*;
import java.util.HashMap;

public interface IObserver<K, V>{

    void update(HashMap<K, V> positions);
    //void update(HashMap<String, Integer> info);

   // void update(HashMap<K, V> pos);
}
