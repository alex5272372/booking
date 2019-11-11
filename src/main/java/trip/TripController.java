package trip;

import main.City;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class TripController {
    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    public Trip getTrip(int id) {
        return tripService.getTrip(id);
    }

    public void addTrip(Date date, City from, City to, int count) {
        tripService.addTrip(date, from, to, count);
    }

    public void updateTrip(int id, Date date, City from, City to, int count) {
        tripService.updateTrip(id, date, from, to, count);
    }

    public void deleteTrip(int id) {
        tripService.deleteTrip(id);
    }

    public List<Trip> getNearestTrips(int hours) {
        return tripService.getNearestTrips(hours);
    }

    public List<Trip> getTripsByParams(Date date, City from, City to) {
        return tripService.getTripsByParams(date, from, to);
    }

    public void read() throws IOException {
        tripService.read();
    }

    public void write() throws IOException {
        tripService.write();
    }

    public Trip transformStringToTrip(String str) throws ParseException {
        return tripService.transformStringToTrip(str);
    }

    public void displayTrips(List<Trip> trips) {
        tripService.displayTrips(trips);
    }

    public void displayTrip(Trip trip) {
        tripService.displayTrip(trip);
    }
}
