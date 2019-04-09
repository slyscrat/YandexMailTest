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

    @FindBy(linkText = "У меня нет телефона")
    private WebElement linkSecretQuestion;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/form/div[4]/button")
    private WebElement buttonSignUp;

    @FindBy(id = "money_eula_accepted")
    private WebElement checkBoxOnlyPhone;

    @FindBy(id = "eula_accepted")
    private WebElement checkBoxSecond;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[1]/img")
    private WebElement imageCaptcha;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[1]/div")
    private WebElement soundCaptcha;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/form/div[3]/div/div[2]/div[2]/input[1]")
    private WebElement captchaId;

    @FindBy(linkText = "Другой код")
    private WebElement buttonChangeCode;

    @FindBy(className = "error-message")
    private WebElement textError;


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

    public String errorIs(){
        return textError.getText();
    }

    public boolean signUpWithMobileAs(){
        return true;
    }

    public boolean signUpWithoutMobileAs(){
        return true;
    }
}
