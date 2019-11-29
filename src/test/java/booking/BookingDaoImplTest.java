//package booking;
//
//import org.junit.Before;
//import org.junit.Test;
//import users.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class BookingDaoImplTest {
//
//    private BookingDaoImpl bookingDao = new BookingDaoImpl();
//    private BookingServiceImpl bookingService = new BookingServiceImpl();
//    private List<Booking> bookingList = new ArrayList<>();
//    private int[] id;
//    User user = new User("testUser");
//    Booking booking = new Booking(777, user);
//
//    @Before
//    public void init() {
//        bookingDao.addBooking(777, user, user);
//        bookingDao.addBooking(666, user,user);
//        bookingDao.addBooking(555, user,user);
//
//        id = bookingDao.getAllBookings().stream().mapToInt(Booking::getBookingId).toArray();
//    }
//
//    @Test
//    public void getBooking() {
//        String expectedResult = id[0] + ";" + booking.getTripId() + ";" + user.getLogin() + ";" + user.getPassword() + ";";
//        String actualResult = bookingDao.getBooking(id[0]).toCsvString();
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    public void testThatIsPresentIdReturnsProperResult() {
//        boolean expectedResult = true;
//        boolean actualResult = bookingDao.isPresentId(id[0]);
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    public void getBookingsByUser() {
//    }
//
//    @Test
//    public void transformStringToBooking() {
//        String expectedResult = id[0] + ";" + booking.getTripId() + ";" + user.getLogin() + ";" + user.getPassword() + ";";
//        String actualResult = bookingDao.getBooking(id[0]).toCsvString();
//        assertEquals(expectedResult, actualResult);
//    }
//
//}