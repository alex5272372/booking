package users;

import java.util.Random;

public class User {
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    public User(String login, String password) {
        String[] words = login.split(" ");

        this.firstName = words.length > 0 ? words[0] : "";
        this.lastName = words.length > 1 ? words[1] : "";
        this.login = login;
        this.password = password;
    }

    public User(String login) {
        String[] words = login.split(" ");

        this.firstName = words.length > 0 ? words[0] : "";
        this.lastName = words.length > 1 ? words[1] : "";
        this.login = login;

        Random random = new Random();
        this.password = String.valueOf(random.nextInt(1000000));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
