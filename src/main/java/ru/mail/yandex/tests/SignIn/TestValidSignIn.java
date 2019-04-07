package ru.mail.yandex.tests.SignIn;

import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.data.UserData;
import ru.mail.yandex.pages.HomePage;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.tests.WebTest;
import ru.mail.yandex.utils.TestsProperties;


public class TestValidSignIn extends WebTest {

    private SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);
    private HomePage homePage;

    public void setUpBeforeMethod() {}

    @Override
    public boolean test() {
        signInPage.open();
        homePage = signInPage.loginAs(new UserData(TestsProperties.getProperty("username"), TestsProperties.getProperty("password")));
        if (!homePage.isSignedIn()){
            status = false;
            failedPrint(this.getClass().getSimpleName(), "user authorization");
        }
        return status;
    }

}
