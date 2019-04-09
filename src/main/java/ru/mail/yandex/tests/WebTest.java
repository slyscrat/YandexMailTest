package ru.mail.yandex.tests;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.yandex.data.UserData;
import ru.mail.yandex.utils.TestsProperties;

import java.util.concurrent.TimeUnit;

public abstract class WebTest {
    @Getter
    @Setter
    protected boolean status = true;
    private static WebDriver driver;
    @Getter
    private static final UserData user = new UserData(TestsProperties.getProperty("username"),TestsProperties.getProperty("password"));

    protected WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(TestsProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
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
    /*public void tearDownAfterTestClass(){
        //System.out.println("tearDownAfterMethod");
        // logout of the app, if necessary
    }*/

    public static void tearDownAfterTests(){
        //System.out.println("tearDownAfterTestClass");
        // close connections, close browser as needed
        driver.quit();
    }

    protected void failedPrint(WebTest test, String step){
        System.out.println("Test: " + test.getClass().getSimpleName() + " failed at: " + step);
    }

    /*public boolean waitForJStoLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        return wait.until(jsLoad);
    }*/
}
