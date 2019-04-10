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

    @FindBy(id = "phone")
    private WebElement fieldPhone;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/form/div[4]/button")
    private WebElement buttonSignUp;

    @FindBy(id = "eula_accepted")
    private WebElement checkBox;

    @FindBy(id = "hint_answer")
    private WebElement fieldAnswer;

    @FindBy(id = "captcha")
    private WebElement fieldCaptcha;

    @FindBy(className = "error-message")
    private WebElement textError;


    @Override
    public void open(){
        driver.get(TestsProperties.getProperty("signup.url"));
    }

    public String errorIs(){
        return textError.getText();
    }

    public void typeInFirstname(String data){
        type(fieldFirstName, data);
        buttonSignUp.click();
    }

    public boolean isTextInPhoneAllowed(String data){
        return fieldPhone.getText().equals(data);
    }

    public void typeInLastname(String data){
        type(fieldLastName, data);
        buttonSignUp.click();
    }

    public void typeInLogin(String data){
        type(fieldLogin, data);
        buttonSignUp.click();
    }

    public void typeInPassword(String data){
        type(fieldPassword, data);
        buttonSignUp.click();
    }

    public void typeInPasswordConfirm(String data){
        type(fieldPasswordConfirm, data);
        buttonSignUp.click();
    }

    public void typeInPhone(String data){
        type(fieldPhone, data);
    }

    public void clickSignUp(){
        buttonSignUp.click();
    }

    public void typeInAnswer(String data){
        type(fieldAnswer, data);
        buttonSignUp.click();
    }

    public void typeInCaptcha(String data){
        type(fieldCaptcha, data);
        buttonSignUp.click();
    }

    public void clickCheckBox(){
        checkBox.click();
    }

    public boolean isButtonSignInActive(){
        return buttonSignUp.isEnabled();
    }

    public boolean signUpWithMobileAs(){
        return true;
    }

    public boolean signUpWithoutMobileAs(){
        return true;
    }
}
