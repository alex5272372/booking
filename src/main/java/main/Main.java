package main;

import board.Board;
import board.BoardImpl;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardImpl();
        board.displayMenu();
        board.inputCommand();
    }
}
