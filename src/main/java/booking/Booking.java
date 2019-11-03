package booking;

public class Booking {
    private static int maxId;
    private int id;
    private int tripId;
    private String firstName;
    private String lastName;

    static {
        maxId = 0;
    }

    public Booking(int tripId, String firstName, String lastName) {
        this.id = maxId++;
        this.tripId = tripId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
