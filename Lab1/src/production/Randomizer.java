package production;

import model.vehicle.Direction;
import point.Point;
import java.util.Random;

public class Randomizer {

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

   public static Direction randDir() {
        int seed = rand.nextInt(3);
        switch (seed) {
            case 0 -> {return Direction.SOUTH;}
            case 1 -> {return Direction.EAST;}
            case 2 -> {return Direction.WEST;}
            case 3 -> {return Direction.NORTH;}
            default -> {return null;}
        }
   }

}
