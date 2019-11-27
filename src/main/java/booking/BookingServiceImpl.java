package booking;

import users.User;
import java.io.IOException;
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

    public void addBooking(int tripId, User user, User passenger) {
        bookingDao.addBooking(tripId, user, passenger);
    }

    public void deleteBooking(int id) {
        bookingDao.deleteBooking(id);
    }

    public int getCount(int tripId) {
        return bookingDao.getCount(tripId);
    }

    public void read() throws IOException {
        bookingDao.read();
    }

    public void write() throws IOException {
        bookingDao.write();
    }

    public List<Booking> getBookingsByUser(User user) {
        return bookingDao.getBookingsByUser(user);
    }

    public void displayBookings(List<Booking> bookings) {
        System.out.println(Booking.toStringHeader());
        bookings.forEach(booking -> System.out.println(booking.toString()));
        System.out.println(Booking.toStringFooter());
    }
}
