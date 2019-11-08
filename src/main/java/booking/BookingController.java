package booking;

import users.User;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface BookingController {
    List<Booking> getAllBookings();
    Booking getBooking(int id);

    void addBooking(int tripId, int count, User user);
    void updateBooking(int id, int tripId, User user);
    void deleteBooking(int id);

    int getCount(int tripId);

    void write() throws IOException;
    void read() throws IOException;
    Booking transformStringToBooking(String str) throws ParseException;
}
