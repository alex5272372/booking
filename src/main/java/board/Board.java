package board;

import booking.BookingController;
import trip.Trip;
import trip.TripController;
import users.Users;

import java.util.List;

public interface Board {
    State getState();
    void setState(State state);
    void displayMenu();
    void displayTrips(List<Trip> trips);
    void inputCommand(Users users, TripController tripController, BookingController bookingController) throws extInputException;
}
