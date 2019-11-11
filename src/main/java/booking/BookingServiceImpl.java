package booking;

import users.User;

import java.io.IOException;
import java.text.ParseException;
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
        return bookingDao.getCount(tripId);
    }

    public void read() throws IOException {
        bookingDao.read();
    }

    public void write() throws IOException {
        bookingDao.write();
    }
    public Booking transformStringToBooking(String str) throws ParseException{
        return bookingDao.transformStringToBooking(str);
    }

    public List<Booking> getBookingsByUser(User user) {
        return bookingDao.getBookingsByUser(user);
    }

    public void displayBookings(List<Booking> bookings) {
        System.out.println(Booking.toStringHeader());
        bookings.stream().forEach(booking -> System.out.println(booking.toString()));
        System.out.println(Booking.toStringFooter());
    }
}
