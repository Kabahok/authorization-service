package ru.egoravdeev.authorizationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.egoravdeev.authorizationservice.exception.InvalidCredentials;
import ru.egoravdeev.authorizationservice.exception.UnauthorizedUser;
import ru.egoravdeev.authorizationservice.parameters.Authorities;
import ru.egoravdeev.authorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = repository.getUserAutorities(user, password);

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }

        return userAuthorities;

    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

}
