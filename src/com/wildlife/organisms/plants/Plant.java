package com.wildlife.organisms.plants;

import com.wildlife.Board;
import com.wildlife.organisms.Organism;

import java.util.Random;

public abstract class Plant extends Organism {
    private final int spreadingPercentProbability = 50;
    private final Random random = new Random();

    public Plant(int x, int y, Board board) {
        super(x, y, board);

    }

    @Override
    public boolean isPlant() {
        return true;
    }

    @Override
    public void performAction() {
        multiplication();
    }

    @Override
    public byte getInitiative() {
        return 0;
    }


    @Override
    protected void multiplication() {
        int probability = random.nextInt(0, 100);
        int nextPositionX = super.positionX;
        int nextPositionY = super.positionY;
        if (probability < spreadingPercentProbability) {
            int direction = random.nextInt(1, 5);
            int[] directions = {direction, direction + 1, direction + 2, direction + 3};

            for (int dir : directions) {
                if (dir % 4 == 0) {
                    int nextPosition = super.positionX + 1;
                    if (nextPosition < board.getSizeX()) {
                        if (board.getOrganismFromField(nextPosition, positionY) == null) {
                            nextPositionX = nextPosition;
                        }
                    }
                } else if (dir % 4 == 1) {
                    int nextPosition = super.positionX - 1;
                    if (nextPosition >= 0) {
                        if (board.getOrganismFromField(nextPosition, positionY) == null) {
                            nextPositionX = nextPosition;
                        }
                    }
                } else if (dir % 4 == 2) {
                    int nextPosition = super.positionY + 1;
                    if (nextPosition < board.getSizeY()) {
                        if (board.getOrganismFromField(positionX, nextPosition) == null) {
                            nextPositionY = nextPosition;
                        }
                    }
                } else if (dir % 4 == 3) {
                    int nextPosition = super.positionY - 1;
                    if (nextPosition >= 0) {
                        if (board.getOrganismFromField(positionX, nextPosition) == null) {
                            nextPositionY = nextPosition;
                        }
                    }
                }
            }
        }

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

