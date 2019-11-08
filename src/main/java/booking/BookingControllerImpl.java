package booking;

import trip.Trip;
import users.User;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class BookingControllerImpl implements BookingController {
    private BookingService bookingService;

    public BookingControllerImpl() {
        this.bookingService = new BookingServiceImpl();
    }

    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    public Booking getBooking(int id) {
        return bookingService.getBooking(id);
    }

    public void addBooking(int tripId,int count, User user) {
        bookingService.addBooking(tripId, count, user);
    }

    public void updateBooking(int id, int tripId, User user) {
        bookingService.updateBooking(id, tripId, user);
    }

    public void deleteBooking(int id) {
        bookingService.deleteBooking(id);
    }

    public int getCount(int tripId) {

        return bookingService.getCount(tripId);
    }

    public void read() throws IOException {
        bookingService.read();
    }

    public void write() throws IOException {
        bookingService.write();
    }

    public Booking transformStringToBooking(String str) throws ParseException {
        return bookingService.transformStringToBooking(str);
    }
}
