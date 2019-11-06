package board;

import booking.Booking;
import booking.BookingController;
import main.City;
import trip.Trip;
import trip.TripController;
import users.User;
import users.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BoardImpl implements Board {
    private State state;

    public BoardImpl() {
        this.state = State.MAIN_MENU;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void displayMenu() {
        System.out.println("1. Trips board");
        System.out.println("2. View trip information");
        System.out.println("3. Book a trip");
        System.out.println("4. Cancel trip booking");
        System.out.println("5. My trips");
        System.out.println("6. Exit");
    }

    public void displayTrips(List<Trip> trips) {
        System.out.println(Trip.toStringHeader());
        trips.stream().forEach(trip -> System.out.println(trip.toString(0)));
        System.out.println(Trip.toStringFooter());
    }

    public void displayTrip(Trip trip) {
        List<Trip> trips = new ArrayList<Trip>();
        trips.add(trip);
        displayTrips(trips);
    }

    public void displayBookings(List<Booking> bookings) {
        System.out.println(Booking.toStringHeader());
        bookings.stream().forEach(booking -> System.out.println(booking.toString()));
        System.out.println(Booking.toStringFooter());
    }

    public void inputCommand(Users users, TripController tripController, BookingController bookingController) throws extInputException {
        Scanner sc = new Scanner(System.in);

        if(state == State.MAIN_MENU) {
            displayMenu();
            int item = sc.nextInt();
            sc.nextLine();
            if(item == 1) {
                displayTrips(tripController.getNearestTrips(24));
            } else if(item == 2) {
                setState(State.GET_TRIP);
            } else if(item == 3) {
                setState(State.FIND_TRIP);
            } else if(item == 4) {
                setState(State.UNDO_BOOKING);
            } else if(item == 5) {
                displayBookings(bookingController.getAllBookings());
            } else if(item == 6) {
                setState(State.EXIT);
            } else {
                throw new extInputException("Item does not exist");
            }

        } else if(state == State.GET_TRIP) {
            System.out.println("Enter trip ID:");
            int id = sc.nextInt();
            sc.nextLine();
            Trip trip = tripController.getTrip(id);
            displayTrip(trip);
            setState(State.MAIN_MENU);

        } else if(state == State.FIND_TRIP) {
            try {
                Arrays.stream(City.values())
                        .filter(city -> city != City.KYIV)
                        .forEach(city -> System.out.println(city.getId() + ". " + city.getName()));
                System.out.println("Enter destination ID:");
                int dest = sc.nextInt();
                sc.nextLine();
                if(dest >= City.getCount()) {
                    throw new extInputException("City does not exist");
                }

                System.out.println("Enter date in format dd/MM/yyyy:");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateString = sc.nextLine();

                Date date = dateFormat.parse(dateString);

                displayTrips(tripController.getTripsByParams(date, City.KYIV, City.get(dest)));
                setState(State.BOOK_TRIP);
            } catch (ParseException e) {
                System.out.println("ERROR: Incorrect input for date");
            }

        } else if(state == State.BOOK_TRIP) {
            System.out.println("Enter count:");
            int count = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter trip ID (or -1 for cancel):");
            int id = sc.nextInt();
            sc.nextLine();

            if(id != -1) {
                Trip trip = tripController.getTrip(id);
                if(trip.getCount() < bookingController.getCount(id) + count) {
                    throw new extInputException("Not enough places for booking");
                }

                for(int i = 1; i <= count; i++) {
                    System.out.println("USER " + i);
                    System.out.println("Enter first name and last name, or login:");
                    String login = sc.nextLine();
                    User user = users.getOrAddUser(login);
                    bookingController.addBooking(id, user);
                }
                System.out.println("BOOKING COMPLETED");
            }
            setState(State.MAIN_MENU);

        } else if(state == State.UNDO_BOOKING) {
            System.out.println("Enter booking ID:");
            int id = sc.nextInt();
            sc.nextLine();
            bookingController.deleteBooking(id);
            setState(State.MAIN_MENU);
        }
    }
}
