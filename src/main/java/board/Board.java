package board;

import trip.Trip;
import java.util.List;

public interface Board {
    State getState();
    void setState(State state);
    void displayMenu();
    void displayTrips(List<Trip> trips);
    void inputCommand();
}
