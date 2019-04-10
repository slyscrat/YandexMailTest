package ru.mail.yandex.data;

import lombok.Getter;

public class ErrorData {
    @Getter
    private String test;
    @Getter
    private String text;
    @Getter
    private String data;

    public ErrorData(String test, String text, String data){
        this.test = test;
        this.text = text;
        this.data = data;
    }
}
