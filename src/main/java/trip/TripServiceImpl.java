package trip;

import booking.Booking;
import main.City;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void addTrip(Date date, City from, City to, int count) {
        tripDao.addTrip(date, from, to, count);
    }

    public void updateTrip(int id, Date date, City from, City to, int count) {
        tripDao.updateTrip(id, date, from, to, count);
    }

    public void deleteTrip(int id) {
        tripDao.deleteTrip(id);
    }

    public List<Trip> getNearestTrips(int hours) {
        return tripDao.getNearestTrips(hours);
    }

    public List<Trip> getTripsByParams(Date date, City from, City to) {
        return tripDao.getTripsByParams(date, from, to);
    }

    public void read() throws IOException {
        tripDao.read();
    }

    public void write() throws IOException {
        tripDao.write();
    }

    public Trip transformStringToTrip(String str) throws ParseException {
        return tripDao.transformStringToTrip(str);
    }

    public void displayTrips(List<Trip> trips) {
        System.out.println(Trip.toStringHeader());
        trips.stream().forEach(trip -> System.out.println(trip.toString(0)));
        System.out.println(Trip.toStringFooter());
    }

    public void displayTrip(Trip trip) {
        List<Trip> trips = new ArrayList<Trip>();
        trips.add(trip);
        displayTrips(trips);
    }
}
