package com.wildlife.organisms.animals.carnivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Wolf extends Animal {
    public Wolf(int x, int y, int x_board_size, int y_board_size, Board board) {
        super(x, y, x_board_size, y_board_size, board, (byte) 40, (byte) 50);
        }

        @Override
        public String toString() {
            return "🐕";
        }
}

