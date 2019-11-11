package booking;

import trip.Trip;
import users.User;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();

    Booking getBooking(int bookingId);

    void addBooking(int tripId, int count, User user);

    void updateBooking(int tripId, int bookingId, User user);

    void deleteBooking(int bookingId);

    int getCount(int bookingId);

    void write() throws IOException;
    void read()throws IOException;
    Booking transformStringToBooking(String str) throws ParseException;
}
