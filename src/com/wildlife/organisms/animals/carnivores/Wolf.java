package com.wildlife.organisms.animals.carnivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Wolf extends Animal {

    public Wolf(int x, int y, Board board) {
        super(x, y, board, (byte) 40, (byte) 50);
    }

    @Override
    public String toString() {
            return "🐕";
        }
}
