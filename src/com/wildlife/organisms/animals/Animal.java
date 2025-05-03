package com.wildlife.organisms.animals;

import com.wildlife.Board;
import com.wildlife.organisms.Organism;
import com.wildlife.organisms.animals.carnivores.Bear;
import com.wildlife.organisms.animals.carnivores.Wolf;
import com.wildlife.organisms.animals.herbivores.Bird;
import com.wildlife.organisms.animals.herbivores.Boar;
import com.wildlife.organisms.animals.herbivores.Hare;
import com.wildlife.organisms.animals.herbivores.Squirrel;
import java.util.Random;

public abstract class Animal extends Organism {

    private Random random = new Random();
    private byte initiative;
    private byte hunger;
    private byte maxHunger;
    private final int spreadingPercentProbability = 50;

    public Animal(int x, int y, Board board, byte initiative, byte maxHunger) {
        super(x, y, board); // odwołuje się do konstruktora klasy wyżej (Organism) a super. odwołuje się do metod klasy wyżej (SUPER DAJE DO KLASY WYŻĘJ)
        this.initiative = initiative;
        this.hunger = maxHunger;
        this.maxHunger = maxHunger;
    }

    @Override
    public boolean isPlant() {
        return false;
    }

    @Override
    public byte getInitiative() {
        return initiative;
    }

    @Override
    public void performAction() {
        int direction = random.nextInt(1, 5);
        int[] directions = {direction, direction + 1, direction + 2, direction + 3};
        this.hunger--;
        for (int dir: directions) {
            int nextXPosition = super.positionX;
            int nextYPosition = super.positionY;
            switch (dir % 4) {
                case 0:
                    nextXPosition++;
                    break;
                case 1:
                    nextXPosition--;
                    break;
                case 2:
                    nextYPosition++;
                    break;
                case 3:
                    nextYPosition--;
                    break;
            }

            Organism organismFromNextPosition = board.getOrganismFromField(nextXPosition, nextYPosition);
            if (organismFromNextPosition == null) {
                super.positionX = nextXPosition;
                super.positionY = nextYPosition;
                break;
            } else {
                if (checkIfTheSameSpecies(organismFromNextPosition)) {
                    multiplication();
                    break;
                } else {
                    if (organismFromNextPosition.isPlant()) {
                        eat(organismFromNextPosition);
                    } else {
                        checkIfFight(organismFromNextPosition);
                    }
                    break;
                }
            }
        }
    }

    @Override
    protected void multiplication() {
        int direction = random.nextInt(1, 5);
        int[] directions = {direction, direction + 1, direction + 2, direction + 3};
        boolean successfulMove = false;

        for (int dir : directions) {
            int nextXPosition = super.positionX;
            int nextYPosition = super.positionY;
            switch (dir % 4) {
                case 0:
                    nextXPosition++;
                    successfulMove = true;
                    break;
                case 1:
                    nextXPosition--;
                    successfulMove = true;
                    break;
                case 2:
                    nextYPosition++;
                    successfulMove = true;
                    break;
                case 3:
                    nextYPosition--;
                    successfulMove = true;
                    break;

            }
            if (nextXPosition < 0 || nextXPosition >= board.getSizeX() || nextYPosition < 0 || nextYPosition >= board.getSizeY()) {
                continue;
            }

            if (successfulMove) {
                Organism organismFromField = board.getOrganismFromField(nextXPosition, nextYPosition);
                if (organismFromField == null) {
                    String myOrganismClass = this.getClass().getSimpleName();
                    switch (myOrganismClass) {
                        case "Bird" -> board.createOrganism(new Bird(nextXPosition, nextYPosition, board));
                        case "Boar" -> board.createOrganism(new Boar(nextXPosition, nextYPosition, board));
                        case "Hare" -> board.createOrganism(new Hare(nextXPosition, nextYPosition, board));
                        case "Squirrel" -> board.createOrganism(new Squirrel(nextXPosition, nextYPosition, board));
                        case "Bear" -> board.createOrganism(new Bear(nextXPosition, nextYPosition, board));
                        case "Wolf" -> board.createOrganism(new Wolf(nextXPosition, nextYPosition, board));

                    } break;
                }
            }
        }
    }

    private void eat(Organism organism) {
        int posX = organism.getPositionX();
        int posY = organism.getPositionY();
        board.removeOrganismFromBoard(positionX, positionY);
        positionX = posX;
        positionY = posY;
        this.hunger = maxHunger;
    }


    private void checkIfFight(Organism organism) {
        int probability = random.nextInt(0, 100);
        if (probability < spreadingPercentProbability) {
            eat(organism);
        }
    }

    private boolean checkIfTheSameSpecies(Organism organism) {
        String currentSpeciesName = this.getClass().getSimpleName();
        String otherOrganismSpeciesName = organism.getClass().getSimpleName();

        return currentSpeciesName.equals(otherOrganismSpeciesName);
    }
}
