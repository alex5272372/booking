package trip;

import booking.BookingController;
import main.City;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        return getAllTrips().stream().filter(trip -> (trip.getDate().getTime() > new Date().getTime()) &&
                (trip.getDate().getTime() < new Date().getTime() + 1000 * 60 * 60 * hours))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsByParams(Date date, City from, City to) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return getAllTrips().stream().filter(trip -> (dateFormat.format(trip.getDate()).equals(dateFormat.format(date))) &&
                (trip.getFrom() == from) &&
                (trip.getTo() == to))
                .collect(Collectors.toList());
    }

    public void read() throws IOException {
        tripDao.read();
    }

    public void write() throws IOException {
        tripDao.write();
    }

    public void displayTrips(List<Trip> trips, BookingController bookingController) {
        System.out.println(Trip.toStringHeader());
        trips.stream().forEach(trip -> System.out.println(trip.toString(trip.getCount() - bookingController.getCount(trip.getId()))));
        System.out.println(Trip.toStringFooter());
    }

    public void displayTrip(Trip trip, BookingController bookingController) {
        List<Trip> trips = new ArrayList<Trip>();
        trips.add(trip);
        displayTrips(trips, bookingController);
    }
}
