package board;

import booking.BookingController;
import logger.LoggerRoot;
import main.City;
import trip.Trip;
import trip.TripController;
import users.User;
import users.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Board {
    private State state;
    private Optional<User> user;

    public Board() {
        this.state = State.LOGIN;
        this.user = Optional.empty();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void inputCommand(Users users, TripController tripController, BookingController bookingController) throws InputOutOfRangeException {
        Scanner sc = new Scanner(System.in);

        LoggerRoot logger = new LoggerRoot();

        if (state == State.LOGIN) {
            do {
                System.out.println("Enter login:");
                String login = sc.nextLine();
                logger.printAction("login", login);
                System.out.println("Enter password:");
                String password = sc.nextLine();
                logger.printAction("password", password);
                user = users.getUser(login, password);
            } while (user.equals(Optional.empty()));
            setState(State.MAIN_MENU);

        } else if (state == State.MAIN_MENU) {
            System.out.println("1. Trips board\n" +
                    "2. View trip information\n" +
                    "3. Book a trip\n" +
                    "4. Cancel trip booking\n" +
                    "5. My trips\n" +
                    "6. Logout\n" +
                    "7. Exit");
            System.out.println(user);
            int item = sc.nextInt();
            logger.printAction("selected item", Integer.toString(item));
            sc.nextLine();

            if (item == 1) {
                tripController.displayTrips(tripController.getNearestTrips(24), bookingController);
            } else if (item == 2) {
                setState(State.GET_TRIP);
            } else if (item == 3) {
                setState(State.FIND_TRIP);
            } else if (item == 4) {
                setState(State.UNDO_BOOKING);
            } else if (item == 5) {
                bookingController.displayBookings(bookingController.getBookingsByUser(user.get()));
            } else if (item == 6) {
                setState(State.LOGIN);
            } else if (item == 7) {
                setState(State.EXIT);
            } else {
                throw new InputOutOfRangeException("Item does not exist");
            }

        } else if (state == State.GET_TRIP) {
            System.out.println("Enter trip ID:");
            int id = sc.nextInt();
            logger.printAction("trip ID", Integer.toString(id));
            sc.nextLine();
            Trip trip = tripController.getTrip(id);
            tripController.displayTrip(trip, bookingController);
            setState(State.MAIN_MENU);

        } else if (state == State.FIND_TRIP) {
            try {
                Arrays.stream(City.values())
                        .filter(city -> city != City.KYIV)
                        .forEach(city -> System.out.println(city.getId() + ". " + city.getName()));
                System.out.println("Enter destination ID:");
                int dest = sc.nextInt();
                logger.printAction("destination ID", Integer.toString(dest));
                sc.nextLine();
                if (dest >= City.getCount()) {
                    throw new InputOutOfRangeException("City does not exist");
                }

                System.out.println("Enter date in format dd/MM/yyyy:");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateString = sc.nextLine();
                logger.printAction("date", dateString);

                Date date = dateFormat.parse(dateString);

                tripController.displayTrips(tripController.getTripsByParams(date, City.KYIV, City.get(dest)), bookingController);
                setState(State.BOOK_TRIP);
            } catch (ParseException e) {
                System.out.println("ERROR: Incorrect input for date");
            }

        } else if (state == State.BOOK_TRIP) {
            System.out.println("Enter count:");
            int count = sc.nextInt();
            logger.printAction("count", Integer.toString(count));
            sc.nextLine();

            System.out.println("Enter trip ID (or -1 for cancel):");
            int id = sc.nextInt();
            sc.nextLine();

            if (id != -1) {
                Trip trip = tripController.getTrip(id);
                if (trip.getCount() < bookingController.getCount(id) + count) {
                    throw new InputOutOfRangeException("Not enough places for booking");
                }

                for (int i = 1; i <= count; i++) {
                    System.out.println("USER " + i);
                    System.out.println("Enter first name and last name, or login:");
                    String input = sc.nextLine();
                    User passenger = users.getOrAddUser(input);
                    User user = users.getOrAddUser(input);
//                    User user = users.getOrAddUser(this.user.getLogin());

                    //users.getOrAddUser(passenger);
                    bookingController.addBooking(id, user, passenger);
                }
                System.out.println("BOOKING COMPLETED");
                logger.printAction("for cancel", Integer.toString(id));
            }
            setState(State.MAIN_MENU);
            logger.printAction("trip ID", Integer.toString(id));

        } else if (state == State.UNDO_BOOKING) {
            System.out.println("Enter booking ID:");
            int id = sc.nextInt();
            logger.printAction("booking ID", Integer.toString(id));
            sc.nextLine();
            bookingController.deleteBooking(id);
            setState(State.MAIN_MENU);
        }
    }
}
