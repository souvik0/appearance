package com.whatfix;

import java.io.Serializable;

public class FilledState implements StatePattern, Serializable {

    private static final long serialVersionUID = 1L;
    private static volatile FilledState instance = null;

    private FilledState() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    // Lazy Instantiation with Double checking thread safety implemented
    public static FilledState getSingletonLazyInstance() {
        if (instance == null) {
            synchronized(FilledState.class) {
                // Introducing double checking
                if (instance == null) {
                    instance = new FilledState();
                }
            }
        }
        return instance;
    }

    public void startBoiling() {
        System.out.println("Boiling water started");
    }

    @Override
    public void updateState(BoilerContext context) {
        startBoiling();
        invokeNextState(context);
    }

    public void invokeNextState(BoilerContext context) {
        if (context.getStates() instanceof FilledState) {
            context.setStates(BoiledState.getSingletonLazyInstance());
            ((BoiledState) context.getStates()).updateState(context);
        }
    }
}
