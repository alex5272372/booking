package main;

import board.Board;
import board.State;
import board.InputOutOfRangeException;
import booking.BookingController;
import trip.TripController;
import trip.TripDaoImpl;
import trip.TripServiceImpl;
import users.Users;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Users users = new Users();
        users.addUser("guest", "1");

        TripController tripController = new TripController(new TripServiceImpl(new TripDaoImpl()));
        try {
            tripController.read();
            tripController.generateTripsDB(tripController);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BookingController bookingController = new BookingController();
        try {
            bookingController.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Board board = new Board();
        while (board.getState() != State.EXIT) {
            try {
                board.inputCommand(users, tripController, bookingController);
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Your input is invalid, please try again");
            } catch (NoSuchElementException | InputOutOfRangeException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

        try {
            tripController.write();
            bookingController.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
