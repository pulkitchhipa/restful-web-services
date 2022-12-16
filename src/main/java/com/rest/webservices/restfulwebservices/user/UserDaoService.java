package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;
    static{
        users.add(new User(++userCount,"adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"john", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll() {
        return users;
    }
    public User findUserById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }
    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
