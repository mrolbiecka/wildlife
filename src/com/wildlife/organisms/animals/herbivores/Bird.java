package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Bird extends Animal {
    private static final byte maxHunger = 35;
    private static final byte initiative = 35;

    public Bird(int x, int y, Board board) {
        super(x, y, board, initiative, maxHunger);
    }

    @Override
    public String toString() {
        return "🐦";
    }
}

