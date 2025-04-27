package com.wildlife.organisms.plants;

import com.wildlife.Board;
import com.wildlife.organisms.Organism;

import java.util.Random;

public abstract class Plant extends Organism {
    private int spreadingPercentProbability = 50;
    private Random random = new Random();

    public Plant(int x, int y, Board board) {
        super(x, y, board);

    }

    @Override
    public void performAction() {
        multiplication();
    }

    @Override
    public void multiplication() {
        boolean spreading = false;
        int probability = random.nextInt(0, 100);
        int nextPositionX = super.positionX;
        int nextPositionY = super.positionY;
        if (probability < spreadingPercentProbability) {
            spreading = true;
            boolean successfulMove = false;
            do {
                int direction = random.nextInt(1, 5);
                if (direction == 1) {
                    int nextPosition = super.positionX + 1;
                    if (nextPosition < board.getSizeX()) {
                        if (board.getOrganismFromField(nextPosition, positionY) == null) {
                            nextPositionX = nextPosition;
                            successfulMove = true;
                        }
                    }
                } else if (direction == 2) {
                    int nextPosition = super.positionX - 1;
                    if (nextPosition >= 0) {
                        if (board.getOrganismFromField(nextPosition, positionY) == null) {
                            nextPositionX = nextPosition;
                            successfulMove = true;
                        }
                    }
                } else if (direction == 3) {
                    int nextPosition = super.positionY + 1;
                    if (nextPosition < board.getSizeY()) {
                        if (board.getOrganismFromField(positionX, nextPosition) == null) {
                            nextPositionY = nextPosition;
                            successfulMove = true;
                        }
                    }
                } else if (direction == 4) {
                    int nextPosition = super.positionY - 1;
                    if (nextPosition >= 0) {
                        if (board.getOrganismFromField(positionX, nextPosition) == null) {
                            nextPositionY = nextPosition;
                            successfulMove = true;
                        }
                    }
                }
            } while (!successfulMove);
        }
        if (spreading) {
            Organism organismFromField = board.getOrganismFromField(nextPositionX, nextPositionY);
            if (organismFromField == null) {
                String myOrganismClass = this.getClass().getSimpleName();
                switch (myOrganismClass) {
                    case "Strawberry" -> board.createOrganism(new Strawberry(nextPositionX, nextPositionY, board));
                    case "Mushroom" -> board.createOrganism(new Mushroom(nextPositionX, nextPositionY, board));
                    case "Grass" -> board.createOrganism(new Grass(nextPositionX, nextPositionY, board));
                }

            }
        }
    }
}
