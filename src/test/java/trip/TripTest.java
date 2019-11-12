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
        boolean actualResult = trip1.isNotUniqueId(id[0],tc);
        assertEquals(expectedResult, actualResult);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private TripDaoImpl td = new TripDaoImpl();
    private TripServiceImpl ts = new TripServiceImpl(td);
    private TripController tc = new TripController(ts);

    private String dateStr1 = "11/11/2019 12:40";
    private Date date1 = dateFormat.parse(dateStr1);
    private Trip trip1 = new Trip(date1, City.LVIV, City.KHARKIV, 320,tc);
    int id1 = trip1.getId();

    private int[] id;

    public TripTest() throws ParseException {
    }

    @Before
    public void init() {
        tc.addTrip(date1, City.LVIV, City.KHARKIV, 320, tc);
        id = tc.getAllTrips().stream().mapToInt(Trip::getId).toArray();
    }
}
