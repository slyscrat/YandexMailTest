package ru.mail.yandex.tests.MainPage;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.pages.MainPage;
import ru.mail.yandex.pages.RegisterPage;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.tests.WebTest;

public class TestMainPage extends WebTest {

    private MainPage mainPage = PageFactory.initElements(getDriver(), MainPage.class);
    private SignInPage signInPage;
    private RegisterPage registerPage;

    public void setUpBeforeMethod() {}
    //@Test
    @Override
    public boolean test() {

        try{
            mainPage.open();
        }
        catch(Exception ex){
            failedPrint(TestMainPage.class.getSimpleName(), "page loading");
            status = false;
        }

        try{
            signInPage = mainPage.goToSignIn();
            signInPage.back();
        }
        catch(Exception ex){
            status = false;
        }

        try{
            registerPage = mainPage.goToRegister();
            if (registerPage != null){
                driver.navigate().back();
            }
            else
                throw new InvalidElementStateException();
        }
        catch(Exception ex){
            status = false;
        }

        return status;
    }
}

