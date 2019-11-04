package main;

import board.Board;
import board.BoardImpl;
import board.State;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardImpl();
        while(board.getState() != State.EXIT) {
            board.inputCommand();
        };
    }
}
