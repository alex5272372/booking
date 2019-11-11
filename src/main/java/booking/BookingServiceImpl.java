package booking;

import users.User;
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

    public void addBooking(int tripId, User user) {
        bookingDao.addBooking(tripId, user);
    }

    public void updateBooking(int id, int tripId, User user) {
        bookingDao.updateBooking(id, tripId, user);
    }

    public void deleteBooking(int id) {
        bookingDao.deleteBooking(id);
    }

    public int getCount(int tripId) {
        return 0;
    }

    public void displayBookings(List<Booking> bookings) {
        System.out.println(Booking.toStringHeader());
        bookings.stream().forEach(booking -> System.out.println(booking.toString()));
        System.out.println(Booking.toStringFooter());
    }
}
