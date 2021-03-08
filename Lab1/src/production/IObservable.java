package production;


import view.IInfoObserver;
import view.IPositionObserver;

import point.Point;
import java.util.ArrayList;

public interface IObservable{

    IObservable addPositionObserver(IPositionObserver positions);
    void notifyPositionObservers(ArrayList<Tuple<String, Point>> positions);

    IObservable removePositionObserver(IPositionObserver observer);

    void notifyInformationObservers(ArrayList<Tuple<String, Integer>> information);
    IObservable removeInformationObserver(IInfoObserver obs);

    IObservable addInfoObserver(IInfoObserver observer);

}
