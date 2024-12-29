package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(ObjectId id) {
        return userRepo.findById(id).orElse(null);
    }

    public User findByUserName(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean deleteUser(ObjectId id) {
        userRepo.deleteById(id);
        return true;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
