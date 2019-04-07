package ru.mail.yandex.tests.MainPage;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.pages.MainPage;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.pages.SignUpPage;
import ru.mail.yandex.tests.WebTest;

public class TestMainPage extends WebTest {

    private MainPage mainPage = PageFactory.initElements(getDriver(), MainPage.class);
    private SignInPage signInPage;
    private SignUpPage signUpPage;

    public void setUpBeforeMethod() {}

    @Override
    public boolean test() {

        try{
            mainPage.open();
            if (!mainPage.isPageLoaded()){
                throw new Exception();
            }
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "page loading");
            status = false;
            return status;
        }

        try{
            signInPage = mainPage.goToSignIn();
            signInPage.back();
        }
        catch(Exception ex){
            failedPrint(TestMainPage.class.getSimpleName(), "go to sign in");
            status = false;
        }

        try{
            signUpPage = mainPage.goToSignUp();
            if (signUpPage != null){
                driver.navigate().back();
            }
            else
                throw new InvalidElementStateException();
        }
        catch(Exception ex){
            failedPrint(TestMainPage.class.getSimpleName(), "go to sign up");
            status = false;
        }

        return status;
    }
}

