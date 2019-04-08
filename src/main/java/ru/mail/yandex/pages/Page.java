package ru.mail.yandex.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {

    WebDriver driver;
    //private boolean acceptNextAlert = true;

    public Page(){
        this.driver = new ChromeDriver();
    }

    Page(WebDriver driver) {
        this.driver = driver;
    }

    void type(WebElement webElement, String text){
        webElement.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        webElement.sendKeys(text);
    }

    public abstract void open();

    boolean isElementPresent(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }
        catch(NoSuchElementException ex){
            return false;
        }
    }


    /*private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }*/

    /*private String closeAlertAndGetItsText() {
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
    }*/
}
