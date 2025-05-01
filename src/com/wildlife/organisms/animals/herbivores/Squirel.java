package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Squirel extends Animal {
    private static final byte maxHunger = 15;
    private static final byte initiative = 30;
    public Squirel(int x, int y, Board board) {
        super(x, y, board, initiative, maxHunger);
    }

    @Override
    public String toString() {
        return "🐿️";
    }
}