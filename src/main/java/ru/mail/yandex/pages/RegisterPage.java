package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.mail.yandex.utils.ConfigProperties;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void open(){
        driver.get(ConfigProperties.getProperty("register.url"));
    }
}
