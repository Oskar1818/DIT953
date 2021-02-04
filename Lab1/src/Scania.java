import java.awt.*;

public class Scania extends Transporter<CommonGoods> {


    public Scania(Color color, Point point, Direction dir, int capacity){
        super(color, 500, 2, "Scania", point, dir, capacity);
        stopEngine();
    }

    @Override
    public void addLoad(CommonGoods something) {
        getLoad().add(something);
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
