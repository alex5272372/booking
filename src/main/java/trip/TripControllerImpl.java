package trip;

import java.util.Date;
import java.util.List;

public class TripControllerImpl implements TripController {
    private TripService tripService;

    public TripControllerImpl(TripService tripService) {
        this.tripService = tripService;
    }

    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    public Trip getTrip(int id) {
        return tripService.getTrip(id);
    }

    public void addTrip(Date date, String from, String to, int count) {
        tripService.addTrip(date, from, to, count);
    }

    public void updateTrip(int id, Date date, String from, String to, int count) {
        tripService.updateTrip(id, date, from, to, count);
    }

    public void deleteTrip(int id) {
        tripService.deleteTrip(id);
    }
}
