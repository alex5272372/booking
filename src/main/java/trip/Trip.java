package trip;

import main.City;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Trip {
    private int id;
    private Date date;
    private City from;
    private City to;
    private int count;

    private TripController tripController;

    public Trip(Date date, String from, String to, int count) {
        this.id = generateId();
        this.date = date;
        this.from = City.get(from);
        this.to = City.get(to);
        this.count = count;
    }

    public Trip(int id, Date date, String from, String to, int count) {
        this.id = generateId();
        this.date = date;
        this.from = City.get(from);
        this.to = City.get(to);
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Enum getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = City.get(from);
    }

    public Enum getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = City.get(to);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static String toStringHeader() {
        return "+----id-----+-------date-------+-------------from--------------+--------------to---------------+---count---+---free----+";
    }

    public static String toStringFooter() {
        return "+-----------+------------------+-------------------------------+-------------------------------+-----------+-----------+";
    }

    public String toString(int free) {
        return String.format("|%10d | %td/%tm/%tY %tH:%tM | %-30s| %-30s|%10d |%10d |",
                id, date, date, date, date, date, from.getName(), to.getName(), count, free);
    }

    public String toCsvString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return this.id + ";" +
                dateFormat.format(this.date) + ";" +
                City.getCode(this.from) + ";" +
                City.getCode(this.to) + ";" + this.count + ";";
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
