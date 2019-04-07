package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.yandex.utils.TestsProperties;

public class HomePage extends Page {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement linkSignIn;

    @FindBy(linkText= "Выйти из сервисов Яндекса")
    private WebElement linkSignOut;

    @FindBy(className = "mail-User-Name")
    private WebElement userActions;

    @Override
    public void open(){ driver.get(TestsProperties.getProperty("homepage.url"));}

    public boolean isSignedIn(){
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
