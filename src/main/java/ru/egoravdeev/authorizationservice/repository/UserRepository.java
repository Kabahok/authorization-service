package ru.egoravdeev.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.egoravdeev.authorizationservice.parameters.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {

    HashMap<String, String> users = new HashMap<>();

    public UserRepository() {
        users.put("admin1", "qwerty");
        users.put("admin2", "qwerty2");
        users.put("admin3", "qwerty3");
    }


    public List<Authorities> getUserAutorities(String user, String password) {
        if (users.containsKey(user)) {
            if (users.get(user).equals(password)) {
                return List.of(Authorities.values());
            }
            return new ArrayList<>();
        }
        return new ArrayList<>();

    }
}
