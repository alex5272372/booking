package booking;

import users.User;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingDaoImpl implements BookingDao{

    private List<Booking> bookingList = new ArrayList<>();

//    public BookingDaoImpl() {
//        this.bookingList = new ArrayList<Booking>();
//    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookingList) ;
    }

    public Booking getBooking(int id) {
        return getAllBookings().stream().filter(booking -> booking.getId() == id).findFirst().get();
    }

    public void addBooking(int tripId,int count, User user) {
        bookingList.add(new Booking(tripId, count, user));
    }

    public void updateBooking(int tripId,int bookingId,int count,User user) {
        if (isPresentId(id)) {
            getBooking(bookingId).setTripId(date);
            getBooking(bookingId).setBookingId(bookingId);
            getBooking(bookingId).setCount(count);
            getBooking(bookingId).setUser(user);
        }
    }

    public void deleteBooking(int id) {
        if (isPresentId(id)) tripList.remove(getTrip(id));

    }

// read file, write file, transform toString

    public void readBooking() throws IOException {
        File tripFile = new File("./booking.csv");
        BufferedReader reader = new BufferedReader(new FileReader(tripFile));
        List<String> strList = reader.lines().collect(Collectors.toList());
        strList.forEach(str -> {
            try {
                Booking booking = transformStringToBooking(str);
                bookingList.add(booking);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
    public void writeBooking() throws IOException {
        File bookingFile = new File("./booking.csv");
        FileWriter fwClean = new FileWriter(bookingFile);
        PrintWriter pwClean = new PrintWriter(fwClean);
        pwClean.close();
        FileWriter fw = new FileWriter(bookingFile);
        PrintWriter pw = new PrintWriter(fw, true);
        getAllBookings().forEach(booking -> pw.println(booking.toCsvString()));

    }
    public Booking transformStringToBooking(String str) throws ParseException {
        String[] arr = str.split(";");
        int tripId = Integer.parseInt(arr[0]);
        int bookingID = Integer.parseInt(arr[1]);
        int count = Integer.parseInt(arr[2]);
        User user = User.getUserByLogin(arr[3]);
        return new Booking(tripId, bookingID, count, user);
    }
}
