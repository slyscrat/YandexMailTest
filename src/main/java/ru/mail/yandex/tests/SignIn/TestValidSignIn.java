package ru.mail.yandex.tests.SignIn;

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
        homePage = signInPage.loginAs(Ilya);

        if (homePage.isSignedIn()){
            homePage.signOut();
            return true;
        }
        else{
            System.out.println("Пользователь не авторизован");
            return false;
        }
    }

}
