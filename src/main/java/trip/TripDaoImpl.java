package trip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TripDaoImpl implements TripDao{
    private List<Trip> tripList;

    public TripDaoImpl() {
        this.tripList = new ArrayList<Trip>();
    }

    public List<Trip> getAllTrips() {
        return null;
    }

    public Trip getTrip(int id) {
        return null;
    }

    public void addTrip(Date date, String from, String to, int count) {

    }

    public void updateTrip(int id, Date date, String from, String to, int count) {

    }

    public void deleteTrip(int id) {

    }
}
