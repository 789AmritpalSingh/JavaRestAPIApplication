package com.amrit.javarestapi.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {

    // first we are using static list to add members of user dao service,later in the course ,we will use h2 database and jpa
    private static List<User> userDetails = new ArrayList<>();
    private static int countUserId = 0; // this counter will automatically assign value to id

    static {
        userDetails.add(new User(++countUserId,"Adam", LocalDate.now().minusYears(30)));
        userDetails.add(new User(++countUserId,"Amrit", LocalDate.now().minusYears(20)));
        userDetails.add(new User(++countUserId,"Divya", LocalDate.now().minusYears(18)));
    }

    public List<User>findAll(){
        return userDetails;
    }

    public User findById(int id){
        Predicate<? super User> predicate = user -> user.getId()==id;
        return userDetails.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId()==id;
        userDetails.removeIf(predicate); // delete user if the predicate matches or say id matches
    }

    public User save(User user){
        user.setId(++countUserId);
        UserDaoService.userDetails.add(user); // adding name and birthdate to a user
        return user;
    }
}
