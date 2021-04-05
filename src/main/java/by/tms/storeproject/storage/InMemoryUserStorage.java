package by.tms.storeproject.storage;

import by.tms.storeproject.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InMemoryUserStorage {
    private List<User> users;

    public void addUser(User user){
        users.add(user);
    }
}
