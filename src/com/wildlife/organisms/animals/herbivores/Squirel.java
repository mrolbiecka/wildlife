package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Squirel extends Animal {

    public Squirel(int x, int y, Board board) {
        super(x, y, board, (byte) 30, (byte) 15);
    }

    @Override
    public String toString() {
        return "🐿️";
    }
}