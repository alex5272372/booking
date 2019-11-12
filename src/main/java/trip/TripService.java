package trip;

import booking.BookingController;
import main.City;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface TripService {
    List<Trip> getAllTrips();
    Trip getTrip(int id);
    void addTrip(Date date, City from, City to, int count, TripController tripController);
    void addTrip(Trip trip);
    void updateTrip(int id, Date date, City from, City to, int count);
    void deleteTrip(int id);
    List<Trip> getNearestTrips(int hours);
    List<Trip> getTripsByParams(Date date, City from, City to);
    void write() throws IOException;
    void read()throws IOException;
    void displayTrips(List<Trip> trips, BookingController bookingController);
    void displayTrip(Trip trip, BookingController bookingController);
}
