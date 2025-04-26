package com.wildlife.organisms.plants;

import com.wildlife.Board;


public class Grass extends Plant {

    public Grass(int x, int y, Board board) {
        super(x, y, board);
    }

    @Override
    public String toString() {
        return "🌱";
    }
}

