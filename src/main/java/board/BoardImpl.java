package board;

import trip.Trip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
        for(Trip trip : trips) {
            System.out.println(trip.toString(0));
        }
        System.out.println(Trip.toStringFooter());
    }

    public void displayTrip(Trip trip) {
        List<Trip> trips = new ArrayList<Trip>();
        trips.add(trip);
        displayTrips(trips);
    }

    public void inputCommand() {
        // + Test block
        List<Trip> trips = new ArrayList<Trip>();
        trips.add(new Trip(new Date(), "Kiev", "London", 100));
        trips.add(new Trip(new Date(), "Kiev", "Paris", 150));
        trips.add(new Trip(new Date(), "Kiev", "Lviv", 200));
        // - Test block

        Scanner sc = new Scanner(System.in);

        if(state == State.MAIN_MENU) {
            displayMenu();
            int item = sc.nextInt();
            if(item == 1) {
                displayTrips(trips);
            } else if(item == 2) {
                setState(State.GET_TRIP);
            } else if(item == 3) {
                setState(State.FIND_TRIP);
            } else if(item == 4) {

            } else if(item == 5) {

            } else if(item == 6) {
                setState(State.EXIT);
            }

        } else if(state == State.GET_TRIP) {
            System.out.println("Enter trip ID:");
            int id = sc.nextInt();
            displayTrip(trips.get(id));
            setState(State.MAIN_MENU);

        } else if(state == State.FIND_TRIP) {
            System.out.println("Enter destination:");
            int dest = sc.nextInt();
            System.out.println("Enter date:");
            int date = sc.nextInt();
            System.out.println("Enter count:");
            int count = sc.nextInt();
            // TODO: find trips
            displayTrips(trips);
            setState(State.FOUND_TRIP);

        } else if(state == State.FOUND_TRIP) {
            System.out.println("Enter trip ID (or -1 for cancel):");
            int id = sc.nextInt();
            if(id == -1) {
                setState(State.MAIN_MENU);
            }
        }
    }
}
