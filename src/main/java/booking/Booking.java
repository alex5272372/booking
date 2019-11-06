package booking;

import users.User;

public class Booking {
    private static int maxId;
    private int id;
    private int tripId;
    private User user;

    static {
        maxId = 0;
    }

    public Booking(int tripId, User user) {
        this.id = maxId++;
        this.tripId = tripId;
        this.user = user;
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
}
