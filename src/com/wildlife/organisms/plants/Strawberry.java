package com.wildlife.organisms.plants;

import com.wildlife.Board;

public class Strawberry extends Plant {

    public Strawberry(int x, int y, Board board) {
        super(x, y, board);
    }

    @Override
    public String toString() {
        return "🍓";
    }
}
