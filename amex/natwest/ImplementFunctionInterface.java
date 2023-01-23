package natwest;

public class ImplementFunctionInterface implements MyFunctionalInterface{

    @Override
    public String dispaly() {
        // TODO Auto-generated method stub
        return null;
    }

    // Default method are only allowed in interface
    public default void move() {
    }
}