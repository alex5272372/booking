package users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsersTest {
    private Users users;

    @Before
    public void newBoard() {
        users = new Users();
        users.addUser("guest", "1");
    }

    @Test
    public void testGetUser() {
        String expectedResult = "Optional[User{login='guest', password='1'}]";
        String actualResult = users.getUser("guest", "1").toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddUser() {
        String expectedResult = "User{login='admin', password='123'}";
        String actualResult = users.addUser("admin", "123").toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetOrAddUser() {
        String expectedResult = "User{login='guest', password='1'}";
        String actualResult = users.getOrAddUser("guest").toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testToString() {
        String expectedResult = "Users{users=[User{login='guest', password='1'}]}";
        String actualResult = users.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}