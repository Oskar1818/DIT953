package production;

import view.IObserver;

import java.awt.*;
import java.util.HashMap;

public interface IPositionObserver extends IObserver<String, Point> {
    void update(HashMap<String, Point> positions);
}
