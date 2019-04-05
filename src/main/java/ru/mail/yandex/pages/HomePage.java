package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement linkSignIn;

    @FindBy(linkText= "Выйти из сервисов Яндекса")
    public WebElement linkSignOut;

    @FindBy(className = "mail-User-Name")
    public WebElement userActions;

    @Override
    public void open(){
        //driver.get(ConfigProperties.getProperty("homePage.url"));
    }

    public boolean isSignedIn(){
        // maybe change to sign out
        return isElementPresent(userActions);
    }

    public void signOut(){
        userActions.click();
        linkSignOut.click();
    }

    public boolean isSignedOut(){
        return isElementPresent(linkSignIn);
    }
}
