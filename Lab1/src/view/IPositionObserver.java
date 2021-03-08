package view;

import production.Tuple;

import point.Point;
import java.util.ArrayList;

public interface IPositionObserver extends IObserver<String, Point> {
    void update(ArrayList<Tuple<String, Point>> positions);
}
