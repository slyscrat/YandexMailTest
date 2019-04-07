package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.yandex.utils.TestsProperties;

public class SignUpPage extends Page {

    public SignUpPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "firstname")
    private WebElement fieldFirstName;

    @FindBy(id = "lastname")
    private WebElement fieldLastName;

    @FindBy(id = "login")
    private WebElement fieldLogin;

    @FindBy(id = "password")
    private WebElement fieldPassword;

    @FindBy(id = "password_confirm")
    private WebElement fieldPasswordConfirm;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/form/div[2]/div[1]/button")
    private WebElement buttonShowPass;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/form/div[4]/button")
    private WebElement buttonSignUp;


    @Override
    public void open(){
        driver.get(TestsProperties.getProperty("signup.url"));
    }

    public void insert(){
        type(fieldFirstName, "FirstName");
        buttonSignUp.click();
        type(fieldLastName, "LastName");
        buttonSignUp.submit();
        type(fieldPassword, "pass");
        buttonShowPass.click();
        buttonShowPass.click();
    }
}
