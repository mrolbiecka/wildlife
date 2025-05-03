package com.wildlife.organisms.animals.carnivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Bear extends Animal {
    private static final byte maxHunger = 75;
    private static final byte initiative = 10;

    public Bear(int x, int y, Board board) {
        super(x, y, board, initiative, maxHunger);
    }

    @Override
    public String toString() { // metoda która pozwala zwrócić string
        return "🐻";
    }
}
