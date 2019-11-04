package trip;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TripServiceImpl implements TripService{
    private TripDao tripDao;

    public TripServiceImpl(TripDao tripDao) {
        this.tripDao = tripDao;
    }

    public List<Trip> getAllTrips() {
        return tripDao.getAllTrips();
    }

    public Trip getTrip(int id) {
        return tripDao.getTrip(id);
    }

    public void addTrip(Date date, String from, String to, int count) {
        tripDao.addTrip(date, from, to, count);
    }

    public void updateTrip(int id, Date date, String from, String to, int count) {
        tripDao.updateTrip(id, date, from, to, count);
    }

    public void deleteTrip(int id) {
        tripDao.deleteTrip(id);
    }

    public List<Trip> getTripsNearest24Hours() {
        return tripDao.getTripsNearest24Hours();
    }

    public List<Trip> getTripsByFromAndDate(String from, Date date) {
        return tripDao.getTripsByFromAndDate(from, date);
    }
}
