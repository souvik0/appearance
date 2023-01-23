package natwest;

@FunctionalInterface
public interface MyFunctionalInterface {

    public String dispaly();
    public default void move() {
        System.out.println("I am moving through Interface");
    }
}
