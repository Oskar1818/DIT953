package production;

import view.IObserver;

import java.util.HashMap;

public interface IInfoObserver extends IObserver<String, Integer> {
    void update(HashMap<String, Integer> information);
}
