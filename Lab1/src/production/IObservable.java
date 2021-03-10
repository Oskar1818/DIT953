package production;


import view.IInfoObserver;
import view.IPositionObserver;

import point.Point;
import java.util.ArrayList;

public interface IObservable{

    void addPositionObserver(IPositionObserver positions);
    void notifyPositionObservers(ArrayList<Tuple<String, Point>> positions);

    void removePositionObserver(IPositionObserver observer);

    void notifyInformationObservers(ArrayList<Tuple<String, Integer>> information);
    void removeInformationObserver(IInfoObserver obs);

    void addInfoObserver(IInfoObserver observer);

}
