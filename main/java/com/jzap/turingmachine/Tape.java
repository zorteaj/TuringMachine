package com.jzap.turingmachine;


import java.util.List;

public class Tape<T> {

    private Node mCurrentCell = null;

    public static class Node<T> {
        public Node next = null;
        public Node previous = null;
        public T data;

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }
    }

    public Tape(List<T> initalData) {
        Node first = null;
        for(int i = 0; i < initalData.size(); i++) {
            if(i == 0) {
                mCurrentCell = new Node(initalData.get(i));
                first = mCurrentCell;
            } else {
                setCurrentCellValue(initalData.get(i));
            }
            move(Direction.RIGHT);
        }
        mCurrentCell = first;
    }

    public void move(Direction direction) {
        if(mCurrentCell == null) {
            mCurrentCell = new Node();
        }

        switch(direction) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            case NONE:
                break;
            default:
                break;
        }
    }

    private void moveLeft() {
        if(mCurrentCell.previous == null) {
            Node newNode = new Node();
            newNode.next = mCurrentCell;
            mCurrentCell.previous = newNode;
        }
        mCurrentCell = mCurrentCell.previous;
    }

    private void moveRight() {
        if(mCurrentCell.next == null) {
            Node newNode = new Node();
            newNode.previous = mCurrentCell;
            mCurrentCell.next = newNode;
        }
        mCurrentCell = mCurrentCell.next;
    }

    public Object getCurrentCellValue() {
        if(mCurrentCell == null) {
            mCurrentCell = new Node();
        }
        return mCurrentCell.data;
    }

    public void setCurrentCellValue(T data) {
        if(mCurrentCell == null) {
            mCurrentCell = new Node();
        }
        mCurrentCell.data = data;
    }

    public Node getCurrentCell() {
        if(mCurrentCell == null) {
            mCurrentCell = new Node();
        }
        return mCurrentCell;
    }

}
