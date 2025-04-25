package com.wildlife;

import com.wildlife.animals.carnivores.Bear;
import com.wildlife.animals.herbivores.Bird;
import com.wildlife.animals.herbivores.Boar;

//2 zmienne pole 1 i pole 2
public class Board {
    Object[][] organisms = new Object[50][50];
    Boar Zdzisiu = new Boar();
    Bird Marysia = new Bird();
    Bear Zbychu = new Bear();

    public void printBoard() {
        organisms[0][0] = Zdzisiu;
        organisms[40][40] = Marysia;
        organisms[30][30] = Zbychu;
        for (Object organism : organisms){
            System.out.println(organism);
            for (Object organism1 : organisms) {
                System.out.println(organism1);
            }
        }
    }
}
