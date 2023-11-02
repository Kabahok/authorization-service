package ru.egoravdeev.authorizationservice.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egoravdeev.authorizationservice.config.authHandler.AuthUser;
import ru.egoravdeev.authorizationservice.model.User;
import ru.egoravdeev.authorizationservice.parameters.Authorities;
import ru.egoravdeev.authorizationservice.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }


    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@AuthUser @Validated User user) {
        System.out.println(user.getUser() + " " + user.getPassword());
        return service.getAuthorities(user.getUser(), user.getPassword());
    }

}
