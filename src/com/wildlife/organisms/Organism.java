package com.wildlife.organisms;

public abstract class Organism {

    protected int posX;
    protected int posY;
    protected int x_board_size = 40;
    protected int y_board_size = 40;

    public Organism(int x, int y, int x_board_size, int y_board_size){
        posX = x;
        posY = y;
        x_board_size = x_board_size;
        y_board_size = y_board_size;
    }
}


