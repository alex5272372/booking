package booking;

import users.User;

import java.io.IOException;
import java.util.List;

public class BookingController {
    private BookingService bookingService;

    public BookingController() {
        this.bookingService = new BookingServiceImpl();
    }

    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    public Booking getBooking(int id) {
        return bookingService.getBooking(id);
    }

    public void addBooking(int tripId, User user, User passenger) {
        bookingService.addBooking(tripId, user, passenger);
    }

    public void deleteBooking(int id) {
        bookingService.deleteBooking(id);
    }

    public int getCount(int tripId) {
        return bookingService.getCount(tripId);
    }

    public void displayBookings(List<Booking> bookings) {
        bookingService.displayBookings(bookings);
    }

    public void read() throws IOException {
        bookingService.read();
    }

    public void write() throws IOException {
        bookingService.write();
    }

    public List<Booking> getBookingsByUser(User user) {
        return bookingService.getBookingsByUser(user);
    }
}
