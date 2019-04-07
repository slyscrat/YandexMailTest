package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.utils.TestsProperties;

public class MainPage extends Page {
    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[1]")
    private WebElement buttonSignUp;

    @FindBy(xpath= "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    private WebElement buttonSignIn;

    @Override
    public void open(){
        driver.get(TestsProperties.getProperty("main.url"));
    }

    public boolean isPageLoaded(){
        return (isElementPresent(buttonSignUp) && isElementPresent(buttonSignIn));
    }

    public SignInPage goToSignIn(){
        buttonSignIn.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public SignUpPage goToSignUp(){
        buttonSignUp.click();
        return PageFactory.initElements(driver, SignUpPage.class);
    }
}
