package com.wildlife.organisms.animals;


import com.wildlife.Board;
import com.wildlife.organisms.Organism;
import java.util.Random;

public abstract class Animal extends Organism {
    private Random random = new Random();
    private byte initiative;
    private byte hunger;
    // void - typ który nic nie zwraca

    public Animal(int x, int y, int x_board_size, int y_board_size, Board board, byte initiative, byte hunger) {
        super(x, y, x_board_size, y_board_size, board); // odwołuje się do konstruktora klasy wyżej (Organism) a super. odwołuje się do metod klasy wyżej (SUPER DAJE DO KLASY WYŻĘJ)
    }

    @Override
    public void performAction() {
        boolean successfulMove = false;

        do {
            int direction = random.nextInt(1, 5);
            if (direction == 1) {
                int nextPosition = super.posX + 1;
                if (nextPosition < super.x_board_size) {
                    if (board.getOrganismFromField(nextPosition, posY) == null) {
                        super.posX = nextPosition;
                        successfulMove = true;
                    }
                }
            } else if (direction == 2) {
                int nextPosition = super.posX - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(nextPosition, posY) == null) {
                        super.posX = nextPosition;
                        successfulMove = true;
                    }
                }
            } else if (direction == 3) {
                int nextPosition = super.posY + 1;
                if (nextPosition < super.y_board_size) {
                    if (board.getOrganismFromField(posX, nextPosition) == null) {
                        super.posY = nextPosition;
                        successfulMove = true;
                    }
                }
            } else if (direction == 4) {
                int nextPosition = super.posY - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(posX, nextPosition) == null) {
                        super.posY = nextPosition;
                        successfulMove = true;
                    }
                }
            }
        } while (!successfulMove) ;
    }
}
