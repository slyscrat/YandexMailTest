package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.utils.ConfigProperties;

public class MainPage extends Page {
    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[1]")
    public WebElement buttonRegister;

    @FindBy(xpath= "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    public WebElement buttonSignIn;

    @Override
    public void open(){
        driver.get(ConfigProperties.getProperty("main.url"));
    }

    public boolean isPageLoaded(){
        return (isElementPresent(buttonRegister) && isElementPresent(buttonSignIn));
    }

    public SignInPage goToSignIn(){
        buttonSignIn.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public RegisterPage goToRegister(){
        buttonRegister.click();
        return PageFactory.initElements(driver, RegisterPage.class);
    }
}
