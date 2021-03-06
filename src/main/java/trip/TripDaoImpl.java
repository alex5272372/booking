package trip;

import main.City;
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

    public void addTrip(Date date, City from, City to, int count, TripController tripController) {
        tripList.add(new Trip(date, from, to, count, tripController));
    }

    public void addTrip(Trip trip) {
        tripList.add(trip);
    }

    public void updateTrip(int id, Date date, City from, City to, int count) {
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
        City from = City.getByName(arr[2]);
        City to = City.getByName(arr[3]);
        int count = Integer.parseInt(arr[4]);
        return new Trip(id, date, from, to, count);
    }
}
