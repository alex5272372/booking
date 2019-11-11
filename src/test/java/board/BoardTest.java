package board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void newBoard() {
        board = new Board();
    }

    @Test
    public void testGetState() {
        State expectedResult = State.LOGIN;
        State actualResult = board.getState();
        Assert.assertEquals(expectedResult, actualResult);
    }
}