package view;

import java.awt.*;
import java.util.HashMap;

public interface IObserver<K, V>{
    void update(HashMap<K, V> positions);
}
