package ru.mail.yandex.tests.signUp;

import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.data.ErrorData;
import ru.mail.yandex.pages.SignUpPage;
import ru.mail.yandex.tests.WebTest;

import java.util.ArrayList;

public class TestInvalidSignUp extends WebTest {
    private SignUpPage signUpPage = PageFactory.initElements(getDriver(), SignUpPage.class);
    private ArrayList<ErrorData> errorUsername = new ArrayList<>();

    @Override
    public void setUpBeforeMethod() {}

    @Override
    public boolean test() {
        signUpPage.open();
        try{
            //signUpPage.
        }
        catch(Exception ex){
            failedPrint(this, "");
            status = false;
        }
        signUpPage.insert();
        return status;
    }

    public TestInvalidSignUp(){
        initErrors();
    }

    private void initErrors() {
        errorUsername.add(new ErrorData("empty", "Пожалуйста, укажите имя", "  "));
        //errorUsername.add(new ErrorData("empty", "Пожалуйста, укажите фамилию", "  "));
    }
}
