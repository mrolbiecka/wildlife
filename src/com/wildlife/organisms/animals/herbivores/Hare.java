package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Hare extends Animal {

    public Hare(int x, int y, Board board) {
        super(x, y, board, (byte) 30, (byte) 25);
    }

    @Override
    public String toString() {
        return "🐇";
    }
}
