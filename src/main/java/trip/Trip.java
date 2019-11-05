package trip;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public int getId() {
        return id;
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

    public static String toStringHeader() {
        return "+----id-----+-------date-------+-------------from--------------+--------------to---------------+---count---+---free----+";
    }

    public static String toStringFooter() {
        return "+-----------+------------------+-------------------------------+-------------------------------+-----------+-----------+";
    }

    public String toString(int free) {
        return String.format("|%10d | %td/%tm/%tY %tH:%tM | %-30s| %-30s|%10d |%10d |", id, date, date, date, date, date, from, to, count, free);
    }

    public String toCsvString() {
       return this.id + ";" + this.date.getDay()+";" +this.date.getTime()+";" + this.from +";"+ this.to +";"+ this.count +";";
    }
}
