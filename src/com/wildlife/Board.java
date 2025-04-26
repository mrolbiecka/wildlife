package com.wildlife;

import com.wildlife.organisms.Organism;
import com.wildlife.organisms.animals.carnivores.Bear;
import com.wildlife.organisms.animals.carnivores.Wolf;
import com.wildlife.organisms.animals.herbivores.Bird;
import com.wildlife.organisms.animals.herbivores.Hare;
import com.wildlife.organisms.animals.herbivores.Squirel;
import com.wildlife.organisms.plants.Grass;
import com.wildlife.organisms.plants.Mushroom;
import com.wildlife.organisms.plants.Strawberry;
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
        // Boar boar = new Boar(0, 0, x, y, this); // napraw wychodzenie poza krawędzie
        organisms.add(new Bird(1, 1, x, y, this));
        organisms.add(new Bear(3,2, x, y, this));
        organisms.add(new Grass(1, 3, x, y, this));
        organisms.add(new Strawberry(1, 4, x, y, this));
        organisms.add(new Mushroom(9, 9, x, y, this));
        organisms.add(new Wolf(8, 7, x, y, this));
        organisms.add(new Squirel(1, 7, x, y, this));
        organisms.add(new Hare(1, 2, x, y, this));
    }

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
