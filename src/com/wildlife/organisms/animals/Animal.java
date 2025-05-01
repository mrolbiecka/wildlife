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


import java.util.Iterator;
import java.util.Random;

public abstract class Animal extends Organism {

    private Random random = new Random();
    private byte initiative;
    private byte hunger;
    private byte maxHunger;
    private final int spreadingPercentProbability = 50;
    // void - typ który nic nie zwraca

    public Animal(int x, int y, Board board, byte initiative, byte maxHunger) {
        super(x, y, board); // odwołuje się do konstruktora klasy wyżej (Organism) a super. odwołuje się do metod klasy wyżej (SUPER DAJE DO KLASY WYŻĘJ)
        this.initiative = initiative;
        this.hunger = maxHunger;
        this.maxHunger = maxHunger;
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

    private void eat(Organism organism) {
        int posX = organism.getPositionX();
        int posY = organism.getPositionY();
        board.removeOrganismFromBoard(positionX, positionY);
        positionX = posX;
        positionY = posY;
        this.hunger = maxHunger;
    }


    public void checkIfFight(Organism organism) {
        int probability = random.nextInt(0, 100);
        if (probability < spreadingPercentProbability) {
            eat(organism);
        }
    }

    @Override
    public void performAction() {
        int direction = random.nextInt(1, 5);
        int[] directions = {direction, direction + 1, direction + 2, direction + 3};
        for (int dir: directions) {
            if (dir % 4 == 0) {
                int nextPosition = super.positionX + 1;
                if (nextPosition < board.getSizeX()) {
                    if (board.getOrganismFromField(nextPosition, positionY) == null) {
                        super.positionX = nextPosition;
                        break;
                    } else {
                        String organismFromFieldClass = board.getOrganismFromField(nextPosition, positionY).getClass().getSimpleName();
                        if (organismFromFieldClass.equals(this.getClass().getSimpleName())) {
                            multiplication();
                            break;
                        } else {
                            Organism organismFromField = board.getOrganismFromField(nextPosition, positionY);
                            if (organismFromFieldClass.equals("Grass") || organismFromFieldClass.equals("Mushroom") || organismFromFieldClass.equals("Strawberry")) {
                                eat(organismFromField);
                            } else {
                                checkIfFight(organismFromField);
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
                        break;
                    } else {
                        String organismFromFieldClass = board.getOrganismFromField(nextPosition, positionY).getClass().getSimpleName();
                        if (organismFromFieldClass.equals(this.getClass().getSimpleName())) {
                            multiplication();
                            break;
                        } else {
                            Organism organismFromField = board.getOrganismFromField(nextPosition, positionY);
                            if (organismFromFieldClass.equals("Grass") || organismFromFieldClass.equals("Mushroom") || organismFromFieldClass.equals("Strawberry")) {
                                eat(organismFromField);
                            } else {
                                checkIfFight(organismFromField);
                            }
                        }
                    }
                }
            } else if (dir % 4 == 2) {
                int nextPosition = super.positionY + 1;
                if (nextPosition < board.getSizeY()) {
                    if (board.getOrganismFromField(positionX, nextPosition) == null) {
                        super.positionY = nextPosition;
                        break;
                    } else {
                        String organismFromFieldClass = board.getOrganismFromField(positionX, nextPosition).getClass().getSimpleName();
                        if (organismFromFieldClass.equals(this.getClass().getSimpleName())) {
                            multiplication();
                            break;
                        } else {
                            Organism organismFromField = board.getOrganismFromField(positionX, nextPosition);
                            if (organismFromFieldClass.equals("Grass") || organismFromFieldClass.equals("Mushroom") || organismFromFieldClass.equals("Strawberry")) {
                                eat(organismFromField);
                            } else {
                                checkIfFight(organismFromField);
                            }
                        }
                    }
                }
            } else if (dir % 4 == 3) {
                int nextPosition = super.positionY - 1;
                if (nextPosition >= 0) {
                    if (board.getOrganismFromField(positionX, nextPosition) == null) {
                        super.positionY = nextPosition;
                        break;
                    } else {
                        String organismFromFieldClass = board.getOrganismFromField(positionX, nextPosition).getClass().getSimpleName();
                        if (organismFromFieldClass.equals(this.getClass().getSimpleName())) {
                            multiplication();
                            break;
                        }  else {
                            Organism organismFromField = board.getOrganismFromField(positionX, nextPosition);
                            if (organismFromFieldClass.equals("Grass") || organismFromFieldClass.equals("Mushroom") || organismFromFieldClass.equals("Strawberry")) {
                                eat(organismFromField);
                            } else {
                                checkIfFight(organismFromField);
                            }
                        }
                    }
                }
            }
        }
    }
}
