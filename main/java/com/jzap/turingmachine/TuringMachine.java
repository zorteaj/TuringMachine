package com.jzap.turingmachine;

import java.util.HashMap;
import java.util.List;

public class TuringMachine {

    Tape mTape;
    State mState;
    HashMap<Boolean, Instruction<Boolean>> mInstructions;

    public TuringMachine(State initialState, List initalData, HashMap<Boolean, Instruction<Boolean>> instructions) {
        mState = initialState;
        mTape = new Tape(initalData);
        mInstructions = instructions;
    }

    public void moveHead(Direction direction) {
        mTape.move(direction);
    }

    public Tape getTape() {
        return mTape;
    }

}
