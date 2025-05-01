package com.wildlife.organisms.animals.carnivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Wolf extends Animal {
    private static final byte maxHunger = 50;
    private static final byte initiative = 40;

    public Wolf(int x, int y, Board board) {
        super(x, y, board, initiative, maxHunger);
    }

    @Override
    public String toString() {
            return "🐕";
        }
}
