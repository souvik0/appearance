package com.whatfix;

public class BoilerContext {

    public StatePattern states;

    public StatePattern getStates() {
        return states;
    }

    public void setStates(StatePattern states) {
        this.states = states;
    }

    public BoilerContext() {
        if (states == null) {
            states = EmptyState.getSingletonLazyInstance();
        }
    }

    public void invoke() {
        if (states != null) {
            states.updateState(this);
        }
    }
}