package com.wildlife.organisms.animals.herbivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Boar extends Animal {

    public Boar(int x, int y, Board board) {
        super(x, y, board, (byte) 20, (byte) 60);
    }

    @Override
    public String toString(){
        return "🐗";
    }
}

