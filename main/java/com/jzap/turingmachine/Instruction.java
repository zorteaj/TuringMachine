package com.jzap.turingmachine;

public class Instruction<T> {
    private Action mAction;
    private T mData;
    private State mState;
    private Direction mDirection;

    Instruction(Action action, T data, State state, Direction direction) {
        mAction = action;
        mData = data;
        mDirection = direction;
        mState = state;
    }

    public Action getAction() {
        return mAction;
    }

    public T getData() {
        return mData;
    }

    public Direction getDirection() {
        return mDirection;
    }

    public State getState() {
        return  mState;
    }
}
