package ru.mail.yandex.tests.signIn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.tests.WebTest;

import java.util.List;

public class TestSignInPage extends WebTest {

    private SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);

    @Override
    public void setUpBeforeMethod() { signInPage.open(); }

    @Override
    public boolean test() {
        /*try{
            signInPage.goToSignUp();
            if(!isRedirectedTo("registration")) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "sign up redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.signInQR(getUser());
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "QR sign in redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.back();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "main page redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.goToYandex();
            if(!isRedirectedTo("yandex.ru")) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "yandex redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.loginRestore();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "login restore redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.submitUsername(getUser().getUsername());
            signInPage.passwordRestore();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "password restore redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.submitUsername(getUser().getUsername());
            signInPage.passwordRestore();
            signInPage.loginIconClick();
            if(!signInPage.isLoginPage()) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "login page redirection");
            status = false;
        }


        setUpBeforeMethod();
        try{
            signInPage.submitUsername(getUser().getUsername());
            signInPage.enterPassword(TestsProperties.getProperty("shortnumseq"));
            signInPage.showPassword();
            if(!signInPage.getTypeOfPasswordField().equals("text")) throw new Exception();
            signInPage.showPassword();
            if(!signInPage.getTypeOfPasswordField().equals("password")) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "password show");
            status = false;
        }


        setUpBeforeMethod();*/
        try{
            List<WebElement> links = signInPage.getLinksSocialNets();
            for(WebElement webElement:links){
                // STOP: throws Exception
                webElement.click();
            }

        }
        catch(Exception ex){
            failedPrint(this.getClass().getSimpleName(), "social net authorization");
            status = false;
        }

        return status;
    }
}
