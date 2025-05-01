package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Boar extends Animal {
    private static final byte maxHunger = 60;
    private static final byte initiative = 20;

    public Boar(int x, int y, Board board) {
        super(x, y, board, initiative, maxHunger);
    }

    @Override
    public String toString(){
        return "🐗";
    }
}

