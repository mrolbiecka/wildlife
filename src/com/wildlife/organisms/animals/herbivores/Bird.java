package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Bird extends Animal {
    private String icon = "🐦";

    public Bird(int x, int y, int x_board_size, int y_board_size, Board board) {
        super(x, y, x_board_size, y_board_size, board);
    }

    @Override
    public String toString() {
            return icon;
        }
    }

