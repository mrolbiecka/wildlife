package com.wildlife.organisms;

import com.wildlife.Board;

public abstract class Organism {
    protected int positionX;
    protected int positionY;
    protected Board board;

// napraw, żeby było przekazywane dynamicznie
    public Organism(int x, int y, Board board) {
        positionX = x;
        positionY = y;
        this.board = board;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public abstract void performAction();

    public abstract void multiplication();

    public abstract void eat();

    public abstract void checkIfFight();
}




