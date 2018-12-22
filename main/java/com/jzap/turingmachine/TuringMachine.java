package com.jzap.turingmachine;

import java.util.List;

public class TuringMachine {

    Tape mTape;
    State mState;

    public TuringMachine(State initialState, List initalData) {
        mState = initialState;
        mTape = new Tape(initalData);
    }

    public void moveHead(Direction direction) {

    }
}
