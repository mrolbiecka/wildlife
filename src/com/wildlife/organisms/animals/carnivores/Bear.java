package com.wildlife.organisms.animals.carnivores;

import com.wildlife.Board;
import com.wildlife.organisms.animals.Animal;

public class Bear extends Animal {
    // final nie można zmienić wartości zmniennej

    public Bear(int x, int y, int x_board_size, int y_board_size, Board board) {
        super(x, y, x_board_size, y_board_size, board, (byte) 10, (byte) 75);  //super z nawiasami konstruktor wyżej, super z kropką metodę wyżej
    }

    @Override // każdy obiekt w javie dziedziczy po klasie typu Object
    public String toString() { // metoda która pozwala zwrócić string
        return "🐻";
    }
}

