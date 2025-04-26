package com.wildlife.organisms.animals.carnivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Bear extends Animal {
    private String icon = "🐻";

    public Bear(int x, int y, int x_board_size, int y_board_size, Board board) {
        super(x, y, x_board_size, y_board_size, board);  //super z nawiasami konstruktor wyżej, super z kropką metodę wyżej
    }
    @Override
    public String toString() {
        return icon;
    }
}

