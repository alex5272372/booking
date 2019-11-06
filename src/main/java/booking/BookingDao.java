package booking;

import users.User;
import java.util.List;

public interface BookingDao {
    List<Booking> getAllBookings();
    Booking getBooking(int id);
    void addBooking(int tripId, User user);
    void updateBooking(int id, int tripId, User user);
    void deleteBooking(int id);
}
