package booking;

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

    public void addBooking(int tripId, String firstName, String lastName) {
        bookingService.addBooking(tripId, firstName, lastName);
    }

    public void updateBooking(int id, int tripId, String firstName, String lastName) {
        bookingService.updateBooking(id, tripId, firstName, lastName);
    }

    public void deleteBooking(int id) {
        bookingService.deleteBooking(id);
    }

    public int getCount(int tripId) {
        return bookingService.getCount(tripId);
    }
}
