package by.tms.storeproject.service;

import by.tms.storeproject.entity.User;
import by.tms.storeproject.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private InMemoryUserStorage inMemoryUserStorage;

    public void saveUser(User user){
        inMemoryUserStorage.addUser(user);
    }
}
