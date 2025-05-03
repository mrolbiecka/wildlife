package com.wildlife;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 10);
        Scanner input = new Scanner(System.in);

        board.printBoard();
        while (true) {
            board.move();
            System.out.println(" ------ ");
            board.printBoard();
            System.out.println("Press enter to continue");
            input.nextLine();
        }
    }
}