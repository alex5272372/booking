package booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao{
    private List<Booking> bookingList;

    public BookingDaoImpl() {
        this.bookingList = new ArrayList<Booking>();
    }

    public List<Booking> getAllBookings() {
        return null;
    }

    public Booking getBooking(int id) {
        return null;
    }

    public void addBooking(int tripId, String firstName, String lastName) {

    }

    public void updateBooking(int id, int tripId, String firstName, String lastName) {

    }

    public void deleteBooking(int id) {

    }
}
