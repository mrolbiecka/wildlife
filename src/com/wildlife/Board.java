package com.wildlife;

import com.wildlife.organisms.Organism;
import com.wildlife.organisms.animals.carnivores.Bear;
import com.wildlife.organisms.animals.carnivores.Wolf;

import java.util.ArrayList;
import java.util.Iterator;

//2 zmienne pole 1 i pole 2
public class Board {
    private final int x;
    private final int y;
    private ArrayList<Organism> organisms = new ArrayList<>(); //List Interface, a Array to instancja Interface (
    private ArrayList<Organism> newOrganisms = new ArrayList<>(); // Arraylist nie ma ustalonego z góry limitu ilości
    // typ generyczny (1 array list może przechoywać wiele różnych typów) w typie generycznym nie trzeba dwa razy podawać dwa razy co jest w środku

    //konstruktor
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        initializeOrganisms();
    }

    public int getSizeX() {
        return x;
    }

    public int getSizeY() {
        return y;
    }

    private void initializeOrganisms() {
        //organisms.add(new Bird(0, 0, this));
        organisms.add(new Bear(3,3, this));
        organisms.add(new Bear(3, 2, this));
        //organisms.add(new Grass(1, 3, this));
        //organisms.add(new Strawberry(1, 4, this));
        //organisms.add(new Mushroom(9, 9, this));
        organisms.add(new Wolf(8, 7, this));
        organisms.add(new Wolf(8, 8,this));
        organisms.add(new Wolf(8, 6, this));
        organisms.add(new Bear(4, 3, this));
    }

    public void removeOrganismFromBoard(int X, int Y) {
        Iterator<Organism> iterator = organisms.iterator();
        while (iterator.hasNext()) {
            Organism organism = iterator.next();
            if (organism.getPositionY() == Y && organism.getPositionX() == X) {
                iterator.remove();
            }
        }
    }

    public void printBoard() {
        Organism[][] board = new Organism[x][y];

        for (Organism organism : organisms) {
            int posX = organism.getPositionX();
            int posY = organism.getPositionY();
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
        for (Organism organism : organisms) {
            organism.performAction();
        }
        addnewOrganismtoOrganisms();
    }

    public Organism getOrganismFromField(int x, int y) {
        for (Organism organism : organisms) {
            if (organism.getPositionX() == x && organism.getPositionY() == y) {
                return organism;
            }
        }
        return null;
    }

    public void createOrganism(Organism newOrganism) {
        newOrganisms.add(newOrganism);
    }

    public void addnewOrganismtoOrganisms() {
        organisms.addAll(newOrganisms);
        newOrganisms.clear();
    }


}
