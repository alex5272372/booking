package trip;

import main.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TripServiceImplTest {

    @Test
    public void testThatGetAllTripsReturnsProperResult() {
        String expectedResult = dateStr1 + ";" + "Lviv;Kharkiv;320;" +
                dateStr2 + ";" + "Mykolaiv;Kryvyi rih;300;" +
                dateStr3 + ";" + "Kyiv;Kharkiv;260;";
        String actualResult = ts.getAllTrips().stream().map(trip -> trip.toCsvString().substring(5)).collect(Collectors.joining());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatGetTripReturnsProperResult() {
        String expectedResult = id[0] + ";" + dateStr1 + ";" + "Lviv;Kharkiv;320;";
        String actualResult = ts.getTrip(id[0]).toCsvString();
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void testThatGetNearestTripsReturnsProperResult() {
        String  expectedResult = id[1] + ";" + dateStr2 + ";" + "Mykolaiv;Kryvyi rih;300;";
        String actualResult = ts.getNearestTrips(240).stream().map(trip -> trip.toCsvString()).collect(Collectors.joining());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatGetTripsByParamsReturnsProperResult() {
        String expectedResult = id[2] + ";" + dateStr3 + ";" + "Kyiv;Kharkiv;260;";
        String actualResult = ts.getTripsByParams(date3,City.KYIV, City.KHARKIV).stream().map(trip -> trip.toCsvString()).collect(Collectors.joining());
        assertEquals(expectedResult, actualResult);
    }

    private TripDaoImpl td = new TripDaoImpl();
    private TripServiceImpl ts = new TripServiceImpl(td);

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private String dateStr1 = "11/11/2019 12:40";
    private String dateStr2 = "19/11/2019 00:40";
    private String dateStr3 = "11/11/2019 18:20";

    private Date date1 = dateFormat.parse(dateStr1);
    private Date date2 = dateFormat.parse(dateStr2);
    private Date date3 = dateFormat.parse(dateStr3);

    private int[] id;

    public TripServiceImplTest() throws ParseException {
    }

    @Before
    public void init() {
        ts.addTrip(date1, City.LVIV, City.KHARKIV, 320);
        ts.addTrip(date2, City.MYKOLAIV, City.KRYVYI_RIH, 300);
        ts.addTrip(date3, City.KYIV, City.KHARKIV, 260);

        id = ts.getAllTrips().stream().mapToInt(Trip::getId).toArray();
    }
}
