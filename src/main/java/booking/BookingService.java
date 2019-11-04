package booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBooking(int id);
    void addBooking(int tripId, String firstName, String lastName);
    void updateBooking(int id, int tripId, String firstName, String lastName);
    void deleteBooking(int id);
    int getCount(int tripId);
}
