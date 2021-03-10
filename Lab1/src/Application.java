import production.ImmutableProduction;

public class Application {

    public static void main(String[] args){
        ImmutableProduction production = new ImmutableProduction();
        production.getProduction().timer.start();
    }
}
