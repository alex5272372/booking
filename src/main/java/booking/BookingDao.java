package booking;

import users.User;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface BookingDao {
    List<Booking> getAllBookings();
    Booking getBooking(int bookingId);
    void addBooking(int tripId, User user);

    void deleteBooking(int id);
    int getCount(int tripId);
    void updateBooking(int id, int tripId, User user);
    void write() throws IOException;
    void read() throws IOException;
    Booking transformStringToBooking(String str) throws ParseException;
    List<Booking> getBookingsByUser(User user);
}
