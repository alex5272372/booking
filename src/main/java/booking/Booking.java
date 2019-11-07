package booking;

import users.User;

import java.util.Random;

public class Booking {
    private int tripId;
    private int bookingId;
    private int count;
    private User user;

    static {
        maxId = 0;
    }

    public Booking(int tripId, int bookingId, int count, User user) {
        this.tripId = tripId;
        this.bookingId = bookingId;
        this.user = user;
        this.count = count;
    }



    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
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
        return String.format("|%10d |%10d | %-40s|", id, tripId, user.getFullName());
    }
    public int generateId() {
        int id = getRandomInt(1000, 9999);
        while (isNotUniqueId(id)) {
            id = getRandomInt(1000, 9999);
        }
        return id;
    }

    int getRandomInt(int from, int to) {
        Random random = new Random();
        return from + random.nextInt(to - from + 1);
    }

    boolean isNotUniqueId(int id) {
        if (tripController == null) return false;
        return tripController.getAllTrips().stream().anyMatch(trip -> trip.getId() == id);
    }
}
