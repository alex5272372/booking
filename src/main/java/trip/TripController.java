package trip;

import booking.BookingController;
import main.City;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    public void addTrip(Date date, City from, City to, int count, TripController tripController) {
        tripService.addTrip(date, from, to, count, tripController);
    }

    public void addTrip(Trip trip) {
        tripService.addTrip(trip);
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

    public void displayTrips(List<Trip> trips, BookingController bookingController) {
        tripService.displayTrips(trips, bookingController);
    }

    public void displayTrip(Trip trip, BookingController bookingController) {
        tripService.displayTrip(trip, bookingController);
    }

    int getRandomInt(int from, int to) {
        Random random = new Random();
        return from + random.nextInt(to - from + 1);
    }

    public Trip generateTrip(TripController tripController) {
        long time = 1573582812927L + getRandomInt(1, 1000 * 60 * 60 * 24 * 21);
        Date date = new Date(time);
        int fromId = getRandomInt(0, 9);
        City from = City.get(fromId);
        int toId = getRandomInt(0, 9);
        while (fromId == toId) {
            toId = getRandomInt(0, 9);
        }
        City to = City.get(toId);
        int count = getRandomInt(80, 853);
        return new Trip(date, from, to, count, tripController);
    }

    public void generateTripsDB(TripController tripController) {
        for (int i = 0; i < 200; i++) {
            tripService.addTrip(generateTrip(tripController));
        }
    }
}
