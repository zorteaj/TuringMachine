package com.jzap.turingmachine;

public class Instruction<T> {
    State mState;
    Action mAction;
    T mData;

    Instruction(State state, Action action, T data) {
        mState = state;
        mAction = action;
        mData = data;
    }
}
