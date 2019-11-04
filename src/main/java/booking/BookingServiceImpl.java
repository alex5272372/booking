package booking;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    private BookingDao bookingDao;

    public BookingServiceImpl() {
        this.bookingDao = new BookingDaoImpl();
    }

    public List<Booking> getAllBookings() {
        return bookingDao.getAllBookings();
    }

    public Booking getBooking(int id) {
        return bookingDao.getBooking(id);
    }

    public void addBooking(int tripId, String firstName, String lastName) {
        bookingDao.addBooking(tripId, firstName, lastName);
    }

    public void updateBooking(int id, int tripId, String firstName, String lastName) {
        bookingDao.updateBooking(id, tripId, firstName, lastName);
    }

    public void deleteBooking(int id) {
        bookingDao.deleteBooking(id);
    }

    public int getCount(int tripId) {
        return 0;
    }
}
