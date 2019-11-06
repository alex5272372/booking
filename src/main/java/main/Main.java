package main;

import board.Board;
import board.BoardImpl;
import board.State;
import board.extInputException;
import trip.TripController;
import trip.TripControllerImpl;
import trip.TripDaoImpl;
import trip.TripServiceImpl;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
//import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TripController tripController = new TripControllerImpl(new TripServiceImpl(new TripDaoImpl()));
        try {
            tripController.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Board board = new BoardImpl();
        while(board.getState() != State.EXIT) {
            try {
                board.inputCommand(tripController);
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Your input is invalid, please try again");
            } catch(NoSuchElementException | extInputException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

        /*tripController.addTrip(new Date(), "Kiev", "Lviv", 100);
        tripController.addTrip(new Date(), "Kiev", "London", 100);*/

        try {
            tripController.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
