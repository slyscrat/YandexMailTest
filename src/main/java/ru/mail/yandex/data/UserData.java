package ru.mail.yandex.data;

import lombok.Getter;

public class UserData {
    @Getter
    private String username;
    @Getter
    private String password;

    public UserData(String username, String password){
        this.username = username;
        this.password = password;
    }
}
