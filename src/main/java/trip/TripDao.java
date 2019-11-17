package trip;

import main.City;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface TripDao {
    List<Trip> getAllTrips();
    Trip getTrip(int id);
    void addTrip(Date date, City from, City to, int count, TripController tripController);
    void addTrip(Trip trip);
    void updateTrip(int id, Date date, City from, City to, int count);
    void deleteTrip(int id);
    void write() throws IOException;
    void read() throws IOException;
}
