import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class MercedesActros extends Transporter<Car> {

    public MercedesActros(Color color, Point point, Direction dir, int capacity){
        super(color, 725, 2, "MercedesActros", point, dir, capacity);
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
