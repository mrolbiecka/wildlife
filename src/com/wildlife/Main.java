package com.wildlife;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 10);
        board.printBoard();
        board.move();
        System.out.println(" ------ ");
        board.printBoard();


    }
}