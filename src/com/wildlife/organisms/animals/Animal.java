package com.wildlife.organisms.animals;

import com.wildlife.Board;
import com.wildlife.organisms.Organism;
import com.wildlife.organisms.animals.carnivores.Bear;
import com.wildlife.organisms.animals.carnivores.Wolf;
import com.wildlife.organisms.animals.herbivores.Bird;
import com.wildlife.organisms.animals.herbivores.Boar;
import com.wildlife.organisms.animals.herbivores.Hare;
import com.wildlife.organisms.animals.herbivores.Squirel;
import com.wildlife.organisms.plants.Grass;
import com.wildlife.organisms.plants.Mushroom;
import com.wildlife.organisms.plants.Strawberry;


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
        boolean successfulMove = false;
        int nextPositionX = super.positionX;
        int nextPositionY = super.positionY;
        int direction = random.nextInt(1, 5);
        int[] directions = {direction, direction + 1, direction + 2, direction + 3};

        for (int dir : directions) {
            if (dir % 4 == 0) {
                int nextPosition = super.positionX + 1;
                if (nextPosition < board.getSizeX()) {
                    if (board.getOrganismFromField(nextPosition, positionY) == null) {
                        nextPositionX = nextPosition;
                        successfulMove = true;
                        break;
                    }
                }
            } else if (dir % 4 == 1) {
                int nextPosition = super.positionX - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(nextPosition, positionY) == null) {
                        nextPositionX = nextPosition;
                        successfulMove = true;
                        break;
                    }
                }
            } else if (dir % 4 == 2) {
                int nextPosition = super.positionY + 1;
                if (nextPosition < board.getSizeY()) {
                    if (board.getOrganismFromField(positionX, nextPosition) == null) {
                        nextPositionY = nextPosition;
                        successfulMove = true;
                        break;
                    }
                }
            } else if (dir % 4 == 3) {
                int nextPosition = super.positionY - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(positionX, nextPosition) == null) {
                        nextPositionY = nextPosition;
                        successfulMove = true;
                        break;
                    }
                }
            }
        }

         if (successfulMove) {
             Organism organismFromField = board.getOrganismFromField(nextPositionX, nextPositionY);
             if (organismFromField == null) {
                 String myOrganismClass = this.getClass().getSimpleName();
                 switch (myOrganismClass) {
                     case "Bird" -> board.createOrganism(new Bird(nextPositionX, nextPositionY, board));
                     case "Boar" -> board.createOrganism(new Boar(nextPositionX, nextPositionY, board));
                     case "Hare" -> board.createOrganism(new Hare(nextPositionX, nextPositionY, board));
                     case "Squirel" -> board.createOrganism(new Squirel(nextPositionX, nextPositionY, board));
                     case "Bear" -> board.createOrganism(new Bear(nextPositionX, nextPositionY, board));
                     case "Wolf" -> board.createOrganism(new Wolf(nextPositionX, nextPositionY, board));
                 }
             }
         }
        System.out.println("Organism was created on the field" + "pos X: " + nextPositionX + "pos Y: "  + nextPositionY);
    }

    @Override
    public void eat() {
        // idź na miejsce tego organizmu i go zjedz
        // ten organizm jest dodawany do listy do usunięcia na końcu rundy jest usuwany (ale powinien być usunięty od razu, żeby nie wykonał
        // swojego ruchu
        // przekaż pozycje rośliny i wtedy w tej pozycji ustaw organism (zmień pozycje tak jak w move)
    }

    @Override
    public void checkIfFight() {

    }

    @Override
    public void performAction() {
        boolean successfulMove = false;
        int direction = random.nextInt(1, 5);
        int[] directions = {direction, direction + 1, direction + 2, direction + 3};
        for (int dir: directions) {
            if (dir % 4 == 0) {
                int nextPosition = super.positionX + 1;
                if (nextPosition < board.getSizeX()) {
                    if (board.getOrganismFromField(nextPosition, positionY) == null) {
                        super.positionX = nextPosition;
                        successfulMove = true;
                        break;
                    } else {
                        String organismFromFieldClass = board.getOrganismFromField(nextPosition, positionY).getClass().getSimpleName();
                        if (organismFromFieldClass.equals(this.getClass().getSimpleName())) {
                            multiplication();
                            break;
                        } else {
                            if (organismFromFieldClass.equals("Grass") || organismFromFieldClass.equals("Mushroom") || organismFromFieldClass.equals("Strawberry")) {
                                eat();
                            } else {
                                checkIfFight();
                            }
                        }
                    }
                }
                // i tak samo eat i fight dodać do tych poniższych
            } else if (dir % 4 == 1) {
                int nextPosition = super.positionX - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(nextPosition, positionY) == null) {
                        super.positionX = nextPosition;
                        successfulMove = true;
                        break;
                    } else {
                        String organismFromFieldClass = board.getOrganismFromField(nextPosition, positionY).getClass().getSimpleName();
                        if (organismFromFieldClass.equals(this.getClass().getSimpleName())) {
                            multiplication();
                            break;
                        }
                    }
                }
            } else if (dir % 4 == 2) {
                int nextPosition = super.positionY + 1;
                if (nextPosition < board.getSizeY()) {
                    if (board.getOrganismFromField(positionX, nextPosition) == null) {
                        super.positionY = nextPosition;
                        successfulMove = true;
                        break;
                    } else {
                        String organismFromFieldClass = board.getOrganismFromField(positionX, nextPosition).getClass().getSimpleName();
                        if (organismFromFieldClass.equals(this.getClass().getSimpleName())) {
                            multiplication();
                            break;
                        }
                    }
                }
            } else if (dir % 4 == 3) {
                int nextPosition = super.positionY - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(positionX, nextPosition) == null) {
                        super.positionY = nextPosition;
                        successfulMove = true;
                        break;
                    } else {
                        String organismFromFieldClass = board.getOrganismFromField(positionX, nextPosition).getClass().getSimpleName();
                        if (organismFromFieldClass.equals(this.getClass().getSimpleName())) {
                            multiplication();
                            break;
                        }
                    }
                }
            }
        }
    }
}
