package ru.mail.yandex.data;

import lombok.Getter;

public class ErrorData {
    @Getter
    private String testError;
    @Getter
    private String textError;
    @Getter
    private String dataError;

    public ErrorData(String testError, String textError, String dataError){
        this.testError = testError;
        this.textError = textError;
        this.dataError = dataError;
    }
}
