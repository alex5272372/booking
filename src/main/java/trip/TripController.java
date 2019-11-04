package trip;

import java.util.Date;
import java.util.List;

public interface TripController {
    List<Trip> getAllTrips();
    Trip getTrip(int id);
    void addTrip(Date date, String from, String to, int count);
    void updateTrip(int id, Date date, String from, String to, int count);
    void deleteTrip(int id);
}
