package booking;

import users.User;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public  class BookingDaoImpl implements BookingDao{

    private List<Booking> bookingList = new ArrayList<>();

//    public BookingDaoImpl() {
//        this.bookingList = new ArrayList<Booking>();
//    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookingList) ;
    }
//get,add,update,delete
    public Booking getBooking(int id) {
        return getAllBookings().stream().filter(booking -> booking.getBookingId() == id).findFirst().get();
    }
    public void addBooking(int tripId, User user) {
        bookingList.add(new Booking(tripId,  user));
    }

    public void updateBooking(int tripId,int bookingId,User user) {
        if (isPresentId(bookingId)) {
            getBooking(bookingId).setTripId(tripId);
            getBooking(bookingId).setBookingId(bookingId);
            getBooking(bookingId).setUser(user);
        }
    }

    public void deleteBooking(int id) {
        if (isPresentId(id)) bookingList.remove(getBooking(id));

    }

    @Override
    public int getCount(int tripId) {
        return (int) getAllBookings().stream().filter(booking -> booking.getTripId() == tripId).count();
    }


    public List<Booking> getBookingsByUser(User user){
        return getAllBookings().stream().filter(booking -> booking.getUser().equals(user))
                .collect(Collectors.toList());
    }
    public boolean isPresentId(int id) {
        return getAllBookings().stream().anyMatch(booking -> booking.getBookingId() == id);
    }

// read file, write file, transform toString

    public void read() throws IOException {
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
    public void write() throws IOException {
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
        User user = new User(arr[2], arr[3]);
        return new Booking(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), user);
    }
}
