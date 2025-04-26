package com.wildlife.organisms.plants;

import com.wildlife.Board;

public class Mushroom extends Plant {

    public Mushroom(int x, int y, Board board) {
        super(x, y, board);
    }

    @Override
    public String toString() {
        return "🍄";
    }
}


