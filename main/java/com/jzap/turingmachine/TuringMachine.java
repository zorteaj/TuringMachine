package com.jzap.turingmachine;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

public class TuringMachine {

    private final static String TAG = Config.getTag("TuringMachine");

    Tape mTape;
    State mState;
    HashMap<Boolean, HashMap<State, Instruction<Boolean>>> mInstructions;
    TuringMachineUI mUi;

    public TuringMachine(State initialState, List initalData, HashMap<Boolean, HashMap<State, Instruction<Boolean>>> instructions, TuringMachineUI ui) {
        mState = initialState;
        mTape = new Tape(initalData);
        mInstructions = instructions;
        mUi = ui;
    }

    public void moveHead(Direction direction) {
        mTape.move(direction);
    }

    public Tape getTape() {
        return mTape;
    }

    public void run() {
        if(mState == State.HALT) {
            return;
        }

        Boolean currentSymbol = (Boolean) mTape.getCurrentCellValue();
        HashMap<State, Instruction<Boolean>> symbolInstructions = mInstructions.get(currentSymbol);
        Instruction<Boolean> instruction = symbolInstructions.get(mState);

        switch(instruction.getAction()) {
            case WRITE:
                mTape.setCurrentCellValue(instruction.getData());
                break;
            case ERASE:
                mTape.setCurrentCellValue(null);
                break;
            case NONE:
                break;
            default: ;
        }

        mState = instruction.getState();
        mTape.move(instruction.getDirection());
        mUi.updateTape();

        run();
    }

}
