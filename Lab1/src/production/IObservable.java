package production;

import view.IObserver;

import java.awt.*;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public interface IObservable{

    void addPositionObserver(IPositionObserver positions);
    void notifyPositionObservers(HashMap<String, Point> positions);
    void removePositionObserver(IPositionObserver observer);

    void notifyInformationObservers(HashMap<String, Integer> information);
    void removeInformationObserver(IInfoObserver obs);

    void addInfoObserver(IInfoObserver observer);

}
