package ru.egoravdeev.authorizationservice.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {

    @NotEmpty(message = "Имя пользователя не должно быть пустым или содержать только пробелы")
    @Size(min=4, max=15, message = "Недопустимый размер имени")
    private String user;

    @NotEmpty(message = "Пароль не должен быть пустым или содержать только пробелы")
    @Size(min=8, max=20, message = "Недопустимый размер пароля")
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
