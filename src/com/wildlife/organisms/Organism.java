package com.wildlife.organisms;

public abstract class Organism {

    protected int posX;
    protected int posY;
    protected int x_board_size;
    protected int y_board_size;

// napraw, żeby było przekazywane dynamicznie
    public Organism(int x, int y, int x_board_size, int y_board_size){
        posX = x;
        posY = y;
        this.x_board_size = x_board_size; // wezmę z siebie x_board size (z mojego atrybutu i przypiszę do niego to co otrzymałem czyli argument x_board_size z konstruktora)
        this.y_board_size = y_board_size;

    }
    public int returnPositionPosX() {
        return posX;
    }
    public int returnPositionPosY() {
        return posY;
    }


    public abstract void performAction();

}


