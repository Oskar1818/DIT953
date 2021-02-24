
import java.awt.*;

public class VFactory {

    //public VFactory(){}

    public Car addVolvo240() {
        return new Volvo240(Color.red, new Point(0,0), Direction.EAST);
    }

    public Car addSaab95() {
        return new Saab95(Color.BLACK, new Point(0,200), Direction.EAST);
    }

    public Transporter<CommonGoods> addScania() {
        return new Scania(Color.red, new Point(0,400), Direction.EAST, 10);
    }

}
