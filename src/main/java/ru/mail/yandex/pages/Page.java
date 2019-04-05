package ru.mail.yandex.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {

    protected WebDriver driver;
    // DO we need it?
    private boolean acceptNextAlert = true;

    public Page(){
        this.driver = new ChromeDriver();;
    }

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public abstract void open();

    public boolean isElementPresent(WebElement element){
        try{
            element.isDisplayed();
            System.out.println("Element is presented: true");
            return true;
        }
        catch(NoSuchElementException ex){
            System.out.println("Element is presented: false");
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
