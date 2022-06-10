package com.whatfix;

import java.io.Serializable;

// All state implementation has to be singleton
public class BoiledState implements StatePattern, Serializable{

    private static final long serialVersionUID = 1L;
    private static volatile BoiledState instance = null;

    private BoiledState() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    // Lazy Instantiation with Double checking thread safety implemented
    public static BoiledState getSingletonLazyInstance() {
        if (instance == null) {
            synchronized(BoiledState.class) {
                // Introducing double checking
                if (instance == null) {
                    instance = new BoiledState();
                }
            }
        }
        return instance;
    }
    public void drainingWater() {
        System.out.println("Start draining");
    }

    @Override
    public void updateState(BoilerContext context) {
        drainingWater();
    }
}
