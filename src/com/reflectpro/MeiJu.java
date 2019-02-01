package com.reflectpro;

public class MeiJu {
    private State state = State.DRIVING;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
