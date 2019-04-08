package ru.mail.yandex.tests.signUp;

import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.pages.SignUpPage;
import ru.mail.yandex.tests.WebTest;

public class TestInvalidSignUp extends WebTest {
    private SignUpPage signUpPage = PageFactory.initElements(getDriver(), SignUpPage.class);

    @Override
    public void setUpBeforeMethod() {}

    @Override
    public boolean test() {
        signUpPage.open();
        try{

        }
        catch(Exception ex){
            status = false;
        }
        signUpPage.insert();
        return status;
    }
}
