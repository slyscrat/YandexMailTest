package ru.mail.yandex.tests.signIn;

import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.data.ErrorData;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.tests.WebTest;
import ru.mail.yandex.utils.TestsProperties;

import java.util.ArrayList;

public class TestInvalidSignIn extends WebTest {
    private SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);
    private ArrayList<ErrorData> errorUsername = new ArrayList<>();
    private ArrayList<ErrorData> errorPassword = new ArrayList<>();

    public void setUpBeforeMethod() {}

    @Override
    public boolean test() {

        signInPage.open();

        for(ErrorData error: errorUsername){
            try {
                signInPage.submitUsername(error.getDataError());
                if (signInPage.isErrorNotShown(error.getTextError()))
                    throw new Exception("username " + error.getTestError());
            }
            catch(Exception ex){
                status = false;
                failedPrint(this, ex.getMessage());
            }
        }

        signInPage.submitUsername(TestsProperties.getProperty("username"));

        for(ErrorData error: errorPassword){
            try{
                signInPage.submitPassword(error.getDataError());
                if (signInPage.isErrorNotShown(error.getTextError()))
                    throw new Exception("passsword " + error.getTestError());
            }
            catch(Exception ex){
                status = false;
                failedPrint(this, ex.getMessage());
            }
        }
        return status;
    }

    public TestInvalidSignIn(){
        initErrors();
    }

    private void initErrors(){
        errorUsername.add(new ErrorData("empty", "Логин не указан", " "));
        errorUsername.add(new ErrorData("starting with num", "Такой логин не подойдет", "1slyscrat"));
        errorUsername.add(new ErrorData("with rus letters", "Такой логин не подойдет", "Илья"));
        errorUsername.add(new ErrorData("with special characters", "Такой логин не подойдет", "!№%"));
        errorPassword.add(new ErrorData("empty", "Пароль не указан", " "));
        errorPassword.add(new ErrorData("wrong", "Неверный пароль", "1qaz"));
    }
}
