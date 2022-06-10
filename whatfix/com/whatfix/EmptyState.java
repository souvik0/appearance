package com.whatfix;

import java.io.Serializable;

public class EmptyState implements StatePattern, Serializable {

    private static final long serialVersionUID = 1L;
    private static volatile EmptyState instance = null;

    private EmptyState() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    // Lazy Instantiation with Double checking thread safety implemented
    public static EmptyState getSingletonLazyInstance() {
        if (instance == null) {
            synchronized(EmptyState.class) {
                // Introducing double checking
                if (instance == null) {
                    instance = new EmptyState();
                }
            }
        }
        return instance;
    }

    public void fillingWater() {
        System.out.println("Start filling water");
    }

    @Override
    public void updateState(BoilerContext context) {
        fillingWater();
        invokeNextState(context);
    }

    public void invokeNextState(BoilerContext context) {
        if (context.getStates() instanceof EmptyState) {
            context.setStates(FilledState.getSingletonLazyInstance());
            ((FilledState) context.getStates()).updateState(context);
        }
    }
}
