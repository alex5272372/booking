package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Users {
    private List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public Optional<User> getUser(String login, String password) {
        List<User> resList = users.stream()
                .filter(user -> login.equals(user.getLogin()) && password.equals(user.getPassword()))
                .collect(Collectors.toList());

        if(resList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(resList.get(0));
        }
    }

    public User addUser(String login) {
        User user = new User(login);
        users.add(user);
        return user;
    }

    public User addUser(String login, String password) {
        User user = new User(login, password);
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
