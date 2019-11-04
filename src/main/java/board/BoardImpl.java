package board;

import trip.Trip;
import java.util.List;

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

    }

    public void displayTrips(List<Trip> trips) {

    }

    public void inputCommand() {

    }
}
