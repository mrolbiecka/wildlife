package com.wildlife.organisms.plants;

import com.wildlife.Board;
import com.wildlife.organisms.Organism;

public abstract class Plant extends Organism {

    public Plant(int x, int y, int x_board_size, int y_board_size, Board board) {
        super(x, y, x_board_size, y_board_size, board);
        this.board = board;
    }

    @Override
    public void performAction(){

    }
}
