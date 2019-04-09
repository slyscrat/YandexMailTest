package ru.mail.yandex.tests.signIn;

import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.pages.HomePage;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.tests.WebTest;


public class TestValidSignIn extends WebTest {

    private SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);
    private HomePage homePage;

    public void setUpBeforeMethod() {}

    @Override
    public boolean test() {
        signInPage.open();
        homePage = signInPage.loginAs(getUser());
        if (!homePage.isSignedIn()){
            status = false;
            failedPrint(this, "user authorization");
        }
        getDriver().manage().deleteAllCookies();
        return status;
    }

}
