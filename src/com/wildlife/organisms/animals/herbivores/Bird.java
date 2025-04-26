package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Bird extends Animal {

    public Bird(int x, int y, Board board) {
        super(x, y, board, (byte) 35, (byte) 35);
    }

    @Override
    public String toString() {
        return "🐦";
    }
}

