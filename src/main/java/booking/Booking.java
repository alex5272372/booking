package booking;

import users.User;

import java.util.Random;

public class Booking {
    private int tripId;
    private int bookingId;
    private int count;
    private User user;
    private BookingController bookingController;
    private int countLeft;

    public Booking(int tripId, int count, User user) {
        this.tripId = tripId;
        this.bookingId = generateId();
        this.count = count;
        this.countLeft = getCountLeft(count);
        this.user = user;
    }

    public int getBooking() {
        return bookingId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setCount(int count) {
        this.count = count;
    }



    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCountLeft(int count) {
        return 1;
    }
    public int getCount (int count) {
        return count;
    }
    public int getBookingId() {
        return bookingId;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static String toStringHeader() {
        return "+----id-----+--tripId---+------------------user-------------------+";
    }

    public static String toStringFooter() {
        return "+-----------+-----------+-----------------------------------------+";
    }

    public String toString() {
        return String.format(String.valueOf(bookingId), tripId, user.getFullName());
    }

    private int generateId() {
        int id = getRandomInt(1000, 9999);
        while (isNotUniqueId(id)) {
            id = getRandomInt(1000, 9999);
        }
        return id;
    }

    private int getRandomInt(int from, int to) {
        Random random = new Random();
        return from + random.nextInt(to - from + 1);
    }

    private boolean isNotUniqueId(int id) {
        if (bookingController == null) return false;
        return bookingController.getAllBookings().stream().anyMatch(booking -> booking.getBookingId() == id);
    }

    String toCsvString() {
        return this.tripId + ";" +
                this.bookingId + ";" +
                this.count + ";" +
                this.getUser() + ";";
    }

}
