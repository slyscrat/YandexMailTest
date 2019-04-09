package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.data.UserData;
import ru.mail.yandex.utils.TestsProperties;

import java.util.ArrayList;
import java.util.List;

public class SignInPage extends Page{

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[2]")
    private WebElement buttonSignInQR;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/a[3]")
    private WebElement linkYandex;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div/div/form/a")
    private WebElement linkLogin;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div/div/form/div[1]/span[2]")
    private WebElement buttonShowPass;

    @FindBy(linkText = "Зарегистрироваться")
    private WebElement linkSignUp;

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

    @FindBy(className = "passp-form-field__error")
    private WebElement textError;

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void open(){
        driver.get(TestsProperties.getProperty("signin.url"));
    }

    public boolean isErrorNotShown(String text){
        if (isElementPresent(textError)){
            return !textError.getText().equals(text);
        }
        return true;
    }

    public QRPage signInQR(UserData user){
        type(fieldUsername, user.getUsername());
        buttonSignInQR.click();
        return PageFactory.initElements(driver, QRPage.class);
    }

    public void enterPassword(String data){
        type(fieldPassword, data);
    }

    public void showPassword(){
        buttonShowPass.click();
    }

    public void submitUsername(String data){
        type(fieldUsername, data);
        fieldUsername.submit();
    }

    public void submitPassword(String data){
        type(fieldPassword, data);
        fieldPassword.submit();
    }

    public void goToYandex(){
        linkYandex.click();
    }

    public void loginRestore(){
        linkRemindLogin.click();
    }

    public void passwordRestore(){
        linkRemindPassword.click();
    }

    public SignInPage loginIconClick(){
        linkLogin.click();
        return this;
    }

    public String getTypeOfPasswordField(){
        return fieldPassword.getAttribute("type");
    }

    public boolean isLoginPage(){ return isElementPresent(fieldUsername); }

    public SignUpPage goToSignUp(){
        linkSignUp.click();
        return PageFactory.initElements(driver, SignUpPage.class);
    }

    public HomePage loginAs(UserData user){
        submitUsername(user.getUsername());
        submitPassword(user.getPassword());
        return PageFactory.initElements(driver, HomePage.class);
    }

    public ArrayList<WebElement> getLinksSocialNets(){
        ArrayList<WebElement> links = new ArrayList<>(linksSocialNets);
        for(WebElement link:links){
            if(link.getAttribute("class").contains("more")){
                link.click();
                links.remove(link);
                break;
            }
        }
        return links;
    }

    public void back(){
        buttonReturn.click();
    }
}
