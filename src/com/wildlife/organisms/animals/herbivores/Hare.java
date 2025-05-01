package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Hare extends Animal {
    private static final byte maxHunger = 25;
    private static final byte initiative = 30;

    public Hare(int x, int y, Board board) {
        super(x, y, board, initiative, maxHunger);
    }

    @Override
    public String toString() {
        return "🐇";
    }
}
