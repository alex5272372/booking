package trip;

import main.City;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TripDao {
    List<Trip> getAllTrips();
    Trip getTrip(int id);
    void addTrip(Date date, City from, City to, int count);
    void updateTrip(int id, Date date, City from, City to, int count);
    void deleteTrip(int id);
    void write() throws IOException;
    void read() throws IOException;
}
