package trip;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TripDaoImpl implements TripDao {
    private List<Trip> tripList = new ArrayList<>();

    public List<Trip> getAllTrips() {
        return new ArrayList<>(tripList);
    }

    public Trip getTrip(int id) {
        return getAllTrips().stream().filter(trip -> trip.getId() == id).findFirst().get();
    }

    public void addTrip(Date date, String from, String to, int count) {
        tripList.add(new Trip(date, from, to, count));
    }

    public void updateTrip(int id, Date date, String from, String to, int count) {
        if (isPresentId(id)) {
            getTrip(id).setDate(date);
            getTrip(id).setFrom(from);
            getTrip(id).setTo(to);
            getTrip(id).setCount(count);
        }
    }

    public void deleteTrip(int id) {
        if (isPresentId(id)) tripList.remove(getTrip(id));
    }

    public boolean isPresentId(int id) {
        return getAllTrips().stream().anyMatch(trip -> trip.getId() == id);
    }

    public List<Trip> getTripsNearest24Hours() {
        return getAllTrips().stream().filter(trip -> (trip.getDate().getTime() > new Date().getTime()) &&
                (trip.getDate().getTime() < new Date().getTime() + 1000 * 60 * 60 * 24))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsByFromAndDate(String from, Date date) {
        return getAllTrips().stream().filter(trip -> (trip.getFrom() == from) &&
                (trip.getDate() == date))
                .collect(Collectors.toList());
    }
}
