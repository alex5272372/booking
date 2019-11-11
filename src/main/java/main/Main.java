package main;

import board.Board;
import board.State;
import board.extInputException;
import booking.BookingController;
import trip.TripController;
import trip.TripDaoImpl;
import trip.TripServiceImpl;
import users.Users;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
//import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Users users = new Users();
        users.addUser("guest", "1");

        TripController tripController = new TripController(new TripServiceImpl(new TripDaoImpl()));
        try {
            tripController.read();
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
            } catch (NoSuchElementException | extInputException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

        /*tripController.addTrip(new Date(), City.KYIV, City.LVIV, 100);
        tripController.addTrip(new Date(), City.KYIV, City.ODESSA, 100);*/

        try {
            tripController.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bookingController.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
