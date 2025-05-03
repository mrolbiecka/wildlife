package com.wildlife.organisms;

import com.wildlife.Board;


public abstract class Organism implements Comparable<Organism> {
    protected int positionX;
    protected int positionY;
    protected Board board;


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
    @Override
    public int compareTo(Organism organism) {
        if (organism.getInitiative() > this.getInitiative()) return 1;
        if (organism.getInitiative() < this.getInitiative()) return -1;
        return 0;
    }

    public abstract void performAction();

    protected abstract void multiplication();

    public abstract boolean isPlant();

    public abstract byte getInitiative();

}




