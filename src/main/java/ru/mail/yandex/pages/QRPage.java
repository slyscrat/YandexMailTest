package ru.mail.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QRPage extends Page {
    public QRPage(WebDriver driver){ super(driver); }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/a[2]")
    private WebElement linkAnotherAccount;

    @FindBy(className = "passp-magic-field__qr")
    private WebElement qrCode;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div/h1/span/a")
    private WebElement linkYandexKey;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/a")
    private WebElement linkBack;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div/a")
    private WebElement linkPassSignIn;

    public boolean[] isPresent(){
        boolean[] array = new boolean[5];
        array[0] = isElementPresent(linkAnotherAccount);
        array[1] = isElementPresent(qrCode);
        array[2] = isElementPresent(linkYandexKey);
        array[3] = isElementPresent(linkBack);
        array[4] = isElementPresent(linkPassSignIn);
        return array;
    }
    @Override
    public void open() {}

    public SignInPage goBack(){
        linkBack.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public boolean isPageLoaded(){
        return isElementPresent(qrCode);
    }

    public SignInPage changeAccount(){
        linkAnotherAccount.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public void goToYandexKey(){
        linkYandexKey.click();
    }

    public SignInPage signInWithPass(){
        linkPassSignIn.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }
}
