package booking;

import main.City;
import trip.Trip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import users.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)


public class BookingTest {
    private String dateStr1 = "11/11/2019 12:40";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private Date date = dateFormat.parse(dateStr1);
    private Trip trip = new Trip(1111, date, City.LVIV, City.KHARKIV, 320);
    private User user = new User("testLogin");
    private Booking booking = new Booking(trip.getId(), user);


    public BookingTest() throws ParseException {
    }

    @Test
    public void toCsvStringTest() {
        String expectedResult = booking.getBookingId() + ";" + trip.getId() + ";" + user.getLogin()+ ";" + user.getPassword()+";";
        String actualResult = booking.toCsvString();
        assertEquals(expectedResult, actualResult);
    }


}