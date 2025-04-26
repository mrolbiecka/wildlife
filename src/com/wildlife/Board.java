package com.wildlife;

import com.wildlife.organisms.Organism;
import com.wildlife.organisms.animals.Animal;
import com.wildlife.organisms.animals.carnivores.Bear;
import com.wildlife.organisms.animals.herbivores.Bird;

import java.util.ArrayList;

//2 zmienne pole 1 i pole 2
public class Board {
    private final int x;
    private final int y;
    private ArrayList<Organism> organisms = new ArrayList<Organism>(); //List Interface, a Array to instancja Interface (
    // typ generyczny


    //konstruktor
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        initializeOrganisms();
    }

    private void initializeOrganisms() {
        // Boar boar = new Boar(0, 0, x, y, this);
        Bird bird = new Bird(1, 1, x, y, this);
        organisms.add(bird);
        Bear bear = new Bear(3,2, x, y, this);
        organisms.add(bear);
    }


//lista zwierzaków for item in list wstaw na pozycje

    public void printBoard() {
        Organism[][] board = new Organism[x][y];

        for (Organism organism: organisms) {
            int posX = organism.returnPositionPosX();
            int posY = organism.returnPositionPosY();
            board[posX][posY] = organism;
        }

        for (Organism[] organismRow : board) {
            for (Organism organism : organismRow) {
                if (organism == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(organism);
                }

            }
            System.out.print("\n");
        }
    }
    public void move() {
        for (Organism organism: organisms) {
                if (organism != null) {
                    organism.performAction();
                }
        }
    }
}
// czyszczenie pozycji
// debugowanie funkcji move