package production;

import view.IObserver;

import java.awt.*;
import java.util.ArrayList;

public interface IPositionObserver extends IObserver<String, Point> {
    void update(ArrayList<Tuple<String, Point>> positions);
}
