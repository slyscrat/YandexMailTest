package ru.mail.yandex.tests;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.yandex.data.UserData;
import ru.mail.yandex.utils.ConfigProperties;

import java.io.*;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public abstract class WebTest {
    @Getter
    @Setter
    protected boolean status = true;
    protected static WebDriver driver;
    public UserData Ilya = new UserData(ConfigProperties.getProperty("username"),ConfigProperties.getProperty("password"));

    protected WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
        }
        return driver;
    }


    /*protected WebTest(){
        if (driver == null){

        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://mail.yandex.ru");
    }*/

    /*@BeforeClass
    public void setUpBeforeTestClass(){
        // initialize a browser driver, connect to servers
    }*/

    //@Before
    public abstract void setUpBeforeMethod();
        // initialize testPage
        // login to the app, if necessary

    public abstract boolean test();

    //@After
    public void tearDownAfterMethod(){
        //System.out.println("tearDownAfterMethod");
        // logout of the app, if necessary
    }

    //@After
    public void tearDownAfterTestClass(){
        //System.out.println("tearDownAfterTestClass");
        // close connections, close browser as needed
        driver.quit();
    }

    public void failedPrint(String test, String step){
        //System.out.println("Test " + test + " failed in method " + step);
        System.out.printf("Test: %35s failed at: %s\n", test, step);
    }
}
