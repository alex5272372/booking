package trip;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class TripDaoImpl implements TripDao {

    private List<Trip> tripList = new ArrayList<>();

    public List<Trip> getAllTrips() {
        return new ArrayList<>(tripList);
    }

    public Trip getTrip(int id) {
        return getAllTrips().stream().filter(trip -> trip.getId() == id).findFirst().get();
    }

    public void addTrip(Date date, String from, String to, int count) {
        tripList.add(new Trip(date, from, to, count));
    }

    public void updateTrip(int id, Date date, String from, String to, int count) {
        if (isPresentId(id)) {
            getTrip(id).setDate(date);
            getTrip(id).setFrom(from);
            getTrip(id).setTo(to);
            getTrip(id).setCount(count);
        }
    }

    public void deleteTrip(int id) {
        if (isPresentId(id)) tripList.remove(getTrip(id));
    }

    public boolean isPresentId(int id) {
        return getAllTrips().stream().anyMatch(trip -> trip.getId() == id);
    }

    public List<Trip> getNearestTrips(int hours) {
        return getAllTrips().stream().filter(trip -> (trip.getDate().getTime() > new Date().getTime()) &&
                (trip.getDate().getTime() < new Date().getTime() + 1000 * 60 * 60 * hours))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsByParams(Date date, String from, String to) {
        return getAllTrips().stream().filter(trip -> (trip.getDate() == date) &&
                (trip.getFrom() == from) &&
                (trip.getTo() == to))
                .collect(Collectors.toList());
    }

    public void read() throws IOException {
        File tripFile = new File("./trips.csv");
        BufferedReader br = new BufferedReader(new FileReader(tripFile));
        List<String> strList = br.lines().collect(Collectors.toList());
        strList.forEach(str -> {
            try {
                Trip trip = transformStringToTrip(str);
                tripList.add(trip);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

    public void write() throws IOException {
        File tripFile = new File("./trips.csv");
        FileWriter fwClean = new FileWriter(tripFile);
        PrintWriter pwClean = new PrintWriter(fwClean);
        pwClean.close();
        FileWriter fw = new FileWriter(tripFile);
        PrintWriter pw = new PrintWriter(fw, true);
        getAllTrips().forEach(trip -> pw.println(trip.toCsvString()));

    }

    public Trip transformStringToTrip(String str) throws ParseException {
        String[] arr = str.split(";");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        int id = Integer.parseInt(arr[0]);
        Date date = dateFormat.parse(arr[1]);
        int count = Integer.parseInt(arr[4]);
        return new Trip(id, date, arr[2], arr[3], count);
    }
}
