package production;

import view.IObserver;

import java.awt.*;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public interface IObservable{

    public void addPositionObserver(IPositionObserver positions);
    void notifyPositionObservers(HashMap<String, Point> positions);
    void removePositionObserver(IPositionObserver observer);

    void notifyInformationObservers(HashMap<String, Integer> information);
    public void removeInformationObserver(IInfoObserver obs);


    public void addInfoObserver(IInfoObserver observer);
    }
