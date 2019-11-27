package booking;

import users.User;

import java.util.Random;

public class Booking {
    private int tripId;
    private int bookingId;
    private User user;
    private BookingController bookingController;


    private User passenger;

    public Booking(int tripId, User user, User passenger){
        this.tripId=tripId;
        this.bookingId=generateId();
        this.user=user;
        this.passenger=passenger;
    }

    public Booking(int tripId, int bookingId, User user, User passenger) {
        this.tripId=tripId;
        this.bookingId=generateId();
        this.user=user;
        this.passenger=passenger;
    }

    public int getBooking() {
        return bookingId;
    }

    public User getpassenger(){return passenger;};

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public User getPassenger() {
        return passenger;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static String toStringHeader() {
        return "+----id-----+--tripId---+------------------user-------------------+--passenger------+";
    }

    public static String toStringFooter() {
        return "+-----------+-----------+-----------------------------------------+-----------------+";
    }

    public String toString() {
        return String.format("|%10d |%10d | %-40s| %-20s|",
                bookingId, tripId, user.getLogin(), passenger.getLogin());
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
        return this.bookingId + ";" +
                this.tripId + ";" +
                this.user.getLogin()+ ";"+
                this.user.getPassword()+ ";"+
                this.passenger + ";";
    }

}
