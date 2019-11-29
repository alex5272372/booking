package booking;

import users.User;
import java.io.IOException;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBooking(int bookingId);
    void addBooking(int tripId, User user, User passenger);
    void deleteBooking(int bookingId);
    int getCount(int tripId);
    void displayBookings(List<Booking> bookings);
    void write() throws IOException;
    void read()throws IOException;
    List<Booking> getBookingsByUser(User user);
}
