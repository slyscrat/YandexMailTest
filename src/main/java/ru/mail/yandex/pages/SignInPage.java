package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.data.UserData;
import ru.mail.yandex.utils.ConfigProperties;

import java.util.List;

public class SignInPage extends Page{

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[2]")
    private WebElement buttonSignInQR;

    @FindBy(linkText = "Зарегистрироваться")
    private WebElement linkRegister;

    @FindBy(linkText = "Другой аккаунт")
    private WebElement linkAnotherUser;

    @FindBy(linkText = "Не помню логин")
    private WebElement linkRemindLogin;

    @FindBy(linkText = "Не помню пароль")
    private WebElement linkRemindPassword;

    @FindBy(className = "passp-social-block__list-item")
    private List<WebElement> linksSocialNets;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/a")
    private WebElement buttonReturn;

    @FindBy(id="passp-field-login")
    private WebElement fieldUsername;

    @FindBy(id = "passp-field-passwd")
    private WebElement fieldPassword;

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void open(){
        driver.get(ConfigProperties.getProperty("signin.url"));
    }

    public HomePage loginAs(UserData user){
        //linkSignIn.click();
        type(fieldUsername, user.getUsername());
        buttonSignIn.click();
        //fieldUsername.submit();
        type(fieldPassword, user.getPassword());
        fieldPassword.submit();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void back(){
        buttonReturn.click();
    }
}