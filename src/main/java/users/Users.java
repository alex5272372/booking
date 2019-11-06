package users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public User addUser(String login) {
        User user = new User(login);
        users.add(user);
        return user;
    }

    public User getOrAddUser(String login) {
        List<User> resList = users.stream()
                .filter(user -> login.equals(user.getLogin()) || login.equals(user.getFullName()))
                .collect(Collectors.toList());

        if(resList.isEmpty()) {
            return addUser(login);
        } else {
            return resList.get(0);
        }
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
