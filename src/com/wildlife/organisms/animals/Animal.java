package com.wildlife.organisms.animals;

import com.wildlife.Board;
import com.wildlife.organisms.Organism;
import java.util.Random;

public abstract class Animal extends Organism {

    private Random random = new Random();
    private byte initiative;
    private byte hunger;
    // void - typ który nic nie zwraca

    public Animal(int x, int y, Board board, byte initiative, byte hunger) {
        super(x, y, board); // odwołuje się do konstruktora klasy wyżej (Organism) a super. odwołuje się do metod klasy wyżej (SUPER DAJE DO KLASY WYŻĘJ)
        this.initiative = initiative;
        this.hunger = hunger;
    }
    @Override
    public void multiplication() {
    }

    @Override
    public void performAction() {
        boolean successfulMove = false;
        do {
            int direction = random.nextInt(1, 5);
            if (direction == 1) {
                int nextPosition = super.positionX + 1;
                if (nextPosition < board.getSizeX()) {
                    if (board.getOrganismFromField(nextPosition, positionY) == null) {
                        super.positionX = nextPosition;
                        successfulMove = true;
                    }
                }
            } else if (direction == 2) {
                int nextPosition = super.positionX - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(nextPosition, positionY) == null) {
                        super.positionX = nextPosition;
                        successfulMove = true;
                    }
                }
            } else if (direction == 3) {
                int nextPosition = super.positionY + 1;
                if (nextPosition < board.getSizeY()) {
                    if (board.getOrganismFromField(positionX, nextPosition) == null) {
                        super.positionY = nextPosition;
                        successfulMove = true;
                    }
                }
            } else if (direction == 4) {
                int nextPosition = super.positionY - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(positionX, nextPosition) == null) {
                        super.positionY = nextPosition;
                        successfulMove = true;
                    }
                }
            }
        } while (!successfulMove);
    }
}
