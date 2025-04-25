package com.wildlife.organisms.animals;


import com.wildlife.organisms.Organism;

import java.util.Random;

public abstract class Animal extends Organism {
    // void - typ który nic nie zwraca
    private Random random = new Random();

    public Animal(int x, int y, int x_board_size, int y_board_size) {
        super(x, y, x_board_size, y_board_size); // odwołuje się do konstruktora klasy wyżej (Organism) a super. odwołuje się do metod klasy wyżej
    }

    public void move(){
        int direction = random.nextInt(1,5);
        if (direction == 1) {
            if (super.posX + 1 < super.x_board_size) {
                super.posX = super.posX + 1;
            }
        }
        else if (direction == 2){
            if (super.posX - 1 > 0) {
                super.posX = super.posX - 1;
            }
        }
        else if (direction == 3){
            if (super.posY + 1 > super.y_board_size) {
                super.posY = super.posY + 1;
            }
        }
        else if (direction == 4){
            if (super.posY - 1 < 0) {
                super.posY = super.posY - 1;
            }
        }
    }

}
