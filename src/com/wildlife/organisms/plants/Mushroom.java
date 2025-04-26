package com.wildlife.organisms.plants;

import com.wildlife.Board;

public class Mushroom extends Plant {
    public Mushroom(int x, int y, int x_board_size, int y_board_size, Board board) {
        super(x, y, x_board_size, y_board_size, board);
    }

    @Override
    public String toString() {
        return "🍄";
    }
}


