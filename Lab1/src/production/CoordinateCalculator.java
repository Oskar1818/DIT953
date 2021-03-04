package production;

import java.awt.*;
import java.util.Random;

public class CoordinateCalculator {

    static Random rand = new Random();

    public static int calc(int y) {

        if (y <= 2) return 0;
        if (y <= 5) return 300;
        if (y <= 8) return 600;

        return 0;
    }

    public static Point randPos() {

        int randX = rand.nextInt(700);
        int randY = rand.nextInt(500);

        return new Point(randX, randY);
    }

   /* public int randDir() {

    }*/

}
