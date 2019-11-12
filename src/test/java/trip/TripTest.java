package trip;

import main.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TripTest {


    @Test
    public void testThatToCsvStringReturnsProperResult() {
        String expectedResult = id1 + ";" + dateStr1 + ";" + "Lviv;Kharkiv;320;";
        String actualResult = trip1.toCsvString();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatIsNotUniqueIdReturnsProperResult() {
        boolean expectedResult = true;
        tc.getAllTrips().stream().forEach(trip -> System.out.println(trip.toCsvString()));
        System.out.println(trip1.toCsvString());
        System.out.println(tc.getAllTrips().stream().anyMatch(trip -> trip.getId() == id[0]));

        boolean actualResult = trip1.isNotUniqueId(id[0]);
        assertEquals(expectedResult, actualResult);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private String dateStr1 = "11/11/2019 12:40";
    private String dateStr2 = "12/11/2019 00:40";
    private String dateStr3 = "11/11/2019 18:20";

    private Date date1 = dateFormat.parse(dateStr1);
    private Date date2 = dateFormat.parse(dateStr2);
    private Date date3 = dateFormat.parse(dateStr3);

    private Trip trip1 = new Trip(date1, City.LVIV, City.KHARKIV, 320);
    private Trip trip2 = new Trip(date2, City.MYKOLAIV, City.KRYVYI_RIH, 300);
    private Trip trip3 = new Trip(date3, City.KYIV, City.KHARKIV, 260);


    int id1 = trip1.getId();
    int id2 = trip2.getId();
    int id3 = trip3.getId();

    private int[] id;

    public TripTest() throws ParseException {
    }

    private TripDaoImpl td = new TripDaoImpl();
    private TripServiceImpl ts = new TripServiceImpl(td);
    private TripController tc = new TripController(ts);

    @Before
    public void init() {
        tc.addTrip(date1, City.LVIV, City.KHARKIV, 320);
        tc.addTrip(date2, City.MYKOLAIV, City.KRYVYI_RIH, 300);
        tc.addTrip(date3, City.KYIV, City.KHARKIV, 260);

        id = tc.getAllTrips().stream().mapToInt(Trip::getId).toArray();
    }
}
