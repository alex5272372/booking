package trip;

import java.util.Date;

public class Trip {
    private static int maxId;
    private int id;
    private Date date;
    private String from;
    private String to;
    private int count;

    static {
        maxId = 0;
    }

    public Trip(Date date, String from, String to, int count) {
        this.id = maxId++;
        this.date = date;
        this.from = from;
        this.to = to;
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
