package com.wildlife;

import com.wildlife.organisms.animals.carnivores.Bear;
import com.wildlife.organisms.animals.herbivores.Bird;
import com.wildlife.organisms.animals.herbivores.Boar;

//2 zmienne pole 1 i pole 2
public class Board {
    Object[][] organismsArray;

    //konstruktor
    public Board(int x, int y) {
        organismsArray = new Object[x][y];
    }


    Boar boar = new Boar();
    Bird bird = new Bird();
    Bear bear = new Bear();

    public void printBoard() {
        organismsArray[0][0] = boar;
        organismsArray[10][10] = bird;
        organismsArray[30][30] = bear;
        for (Object[] organismRow : organismsArray){
            for (Object organism : organismRow) {
                if (organism == null){
                    System.out.print(" ");
                } else {
                    System.out.print(organism);
                }

            }
            System.out.print("\n");
        }
    }
}
