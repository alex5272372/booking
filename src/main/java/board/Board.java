package board;

import trip.Trip;
import java.util.List;

public interface Board {
    void displayMenu();
    void displayTrips(List<Trip> trips);
    void inputCommand();
}
