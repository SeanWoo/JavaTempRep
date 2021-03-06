package OOP5;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> _users = new ArrayList<>();

    public User GetByEmail(String email){
        var result = _users.stream().filter(x -> x.email == email).findFirst();

        return result.orElse(null);
    }

    public void Insert(User user){
        _users.add(user);
    }
}
