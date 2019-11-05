package trip;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TripController {
    List<Trip> getAllTrips();
    Trip getTrip(int id);
    void addTrip(Date date, String from, String to, int count);
    void updateTrip(int id, Date date, String from, String to, int count);
    void deleteTrip(int id);
    List<Trip> getTripsNearest24Hours();
    List<Trip> getTripsByFromAndDate(String from, Date date);
    void write() throws IOException;
    void read() throws IOException;
    Trip transformStringToTrip(String str) throws ParseException;
}
