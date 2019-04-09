package ru.mail.yandex.tests.signIn;

import org.openqa.selenium.support.PageFactory;
import ru.mail.yandex.pages.QRPage;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.tests.WebTest;

public class TestQRPage extends WebTest {

    private SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);
    private QRPage qrPage;

    @Override
    public void setUpBeforeMethod() {
        signInPage.open();
        qrPage = signInPage.signInQR(getUser());
    }

    @Override
    public boolean test() {

        try{
            if (!qrPage.isPageLoaded()) throw new Exception("page loading");
        }
        catch(Exception ex){
            failedPrint(this, ex.getMessage());
            status = false;
        }

        try{
            signInPage = qrPage.goBack();
        }
        catch(Exception ex){
            failedPrint(this, "link go back");
            status = false;
        }

        setUpBeforeMethod();
        try{
            qrPage.goToYandexKey();
            if (!getDriver().getCurrentUrl().contains("twofa")) throw new Exception("link go Yandex.Key");
        }
        catch(Exception ex){
            failedPrint(this, ex.getMessage());
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage = qrPage.signInWithPass();
        }
        catch(Exception ex){
            failedPrint(this,"link sign in with password");
            status = false;
        }

        return status;
    }
}
