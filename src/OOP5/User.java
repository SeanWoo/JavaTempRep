package OOP5;

import java.util.Objects;

public class User {
    public int id;
    public String email;
    private String password; // тут лучше хэш с солью

    public User(String email, String password){
        this.email = email;
        this.password = password;
        //TODO: hash password
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email == user.email && password == user.password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
