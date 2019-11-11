package users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User user;

    @Before
    public void newBoard() {
        user = new User("guest", "1");
    }

    @Test
    public void testGetLogin() {
        String expectedResult = "guest";
        String actualResult = user.getLogin();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetPassword() {
        String expectedResult = "1";
        String actualResult = user.getPassword();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testToString() {
        String expectedResult = "User{login='guest', password='1'}";
        String actualResult = user.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}