
import java.awt.*;

public class VFactory {

    //public VFactory(){}

    public Volvo240 addVolvo240() {
        return new Volvo240(Color.red, new Point(0,0), Direction.EAST);
    }

    public Saab95 addSaab95() {
        return new Saab95(Color.BLACK, new Point(0,200), Direction.EAST);
    }

    public Scania addScania() {
        return new Scania(Color.red, new Point(0,400), Direction.EAST, 10);
    }

}


// interface Production <- Volvo240 <- Saab95
// Production.move()
