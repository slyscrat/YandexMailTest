package ru.mail.yandex.tests.mainPage;

import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.pages.MainPage;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.pages.SignUpPage;
import ru.mail.yandex.tests.WebTest;

public class TestMainPage extends WebTest {

    private MainPage mainPage = PageFactory.initElements(getDriver(), MainPage.class);
    private SignInPage signInPage;
    private SignUpPage signUpPage;

    public void setUpBeforeMethod() { mainPage.open();}

    @Override
    public boolean test() {

        try{
            if (!mainPage.isPageLoaded()) throw new Exception("page loading");
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), ex.getMessage());
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage = mainPage.goToSignIn();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "go to sign in");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signUpPage = mainPage.goToSignUp();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "go to sign up");
            status = false;
        }

        return status;
    }
}

