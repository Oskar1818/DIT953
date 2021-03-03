package production;

public class CoordinateCalculator {

    public static int calc(int x) {

        if (x <= 2) return 0;
        if (x <= 5) return 300;
        if (x <= 8) return 600;

        return 0;
    }

}
