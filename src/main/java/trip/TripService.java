package trip;

import main.City;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TripService {
    List<Trip> getAllTrips();
    Trip getTrip(int id);
    void addTrip(Date date, City from, City to, int count);
    void updateTrip(int id, Date date, City from, City to, int count);
    void deleteTrip(int id);
    List<Trip> getNearestTrips(int hours);
    List<Trip> getTripsByParams(Date date, City from, City to);
    void write() throws IOException;
    void read()throws IOException;
    Trip transformStringToTrip(String str) throws ParseException;
    public void displayTrips(List<Trip> trips);
    public void displayTrip(Trip trip);
}
