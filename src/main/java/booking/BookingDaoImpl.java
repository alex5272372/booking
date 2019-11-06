package booking;

import users.User;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao{
    private List<Booking> bookingList;

    public BookingDaoImpl() {
        this.bookingList = new ArrayList<Booking>();
    }

    public List<Booking> getAllBookings() {
        return bookingList;
    }

    public Booking getBooking(int id) {
        return null;
    }

    public void addBooking(int tripId, User user) {
        bookingList.add(new Booking(tripId, user));
    }

    public void updateBooking(int id, int tripId, User user) {

    }

    public void deleteBooking(int id) {

    }
}
