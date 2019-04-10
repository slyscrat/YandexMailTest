package ru.mail.yandex.tests.signIn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mail.yandex.pages.SignInPage;
import ru.mail.yandex.tests.WebTest;
import ru.mail.yandex.utils.TestsProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class TestSignInPage extends WebTest {

    private SignInPage signInPage = PageFactory.initElements(getDriver(), SignInPage.class);
    private ArrayList<String> expectedSocialTitles = new ArrayList<>();

    @Override
    public void setUpBeforeMethod() { signInPage.open(); }

    @Override
    public boolean test() {
        try{
            signInPage.goToSignUp();
            if(!getDriver().getTitle().equals("Регистрация")) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this, "sign up redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.signInQR(getUser());
            if(!getDriver().getCurrentUrl().contains("magic")) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this, "QR sign in redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.back();
            if(!getDriver().getTitle().contains("Яндекс.Почта")) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this, "main page redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.goToYandex();
            if(!getDriver().getTitle().equals("Яндекс")) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this, "yandex redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.loginRestore();
            if(!getDriver().getTitle().equals("Яндекс.Паспорт")) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this, "login restore redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.submitUsername(getUser().getUsername());
            signInPage.passwordRestore();
        }
        catch(Exception ex){
            failedPrint(this, "password restore redirection");
            status = false;
        }

        setUpBeforeMethod();
        try{
            signInPage.submitUsername(getUser().getUsername());
            signInPage.loginIconClick();
            if(!signInPage.isLoginPage()) throw new Exception();
        }
        catch(Exception ex){
            failedPrint(this, "login page redirection");
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
            failedPrint(this, "password show");
            status = false;
        }


        setUpBeforeMethod();
        try{
            ArrayList<WebElement> links = signInPage.getLinksSocialNets();
            Iterator<String> iterExpectedTitle = expectedSocialTitles.iterator();
            for(WebElement webElement:links){
                String originalWindow = getDriver().getWindowHandle();
                final Set<String> oldWindowsSet = getDriver().getWindowHandles();

                webElement.click();
                String newWindow = (new WebDriverWait(getDriver(), 10))
                        .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                            }
                        );
                getDriver().switchTo().window(newWindow);
                String expectedTitle = iterExpectedTitle.next();

                try{
                    if (!new WebDriverWait(getDriver(),10).until(((ExpectedCondition<Boolean>) title -> getDriver().getTitle().contains(expectedTitle)))){
                        throw new Exception();
                    }
                }
                catch(Exception ex){
                    failedPrint(this, expectedTitle + " authorization");
                    status = false;
                }

                getDriver().close();
                getDriver().switchTo().window(originalWindow);
            }

        }
        catch(Exception ex){
            failedPrint(this, "social net authorization");
            status = false;
        }

        return status;
    }

    public TestSignInPage(){
        expectedTitlesInit();
    }

    private void expectedTitlesInit(){
        expectedSocialTitles.add("ВК");
        expectedSocialTitles.add("Facebook");
        expectedSocialTitles.add("Google");
        expectedSocialTitles.add("Mail.Ru");
        expectedSocialTitles.add("Одноклассники");
        expectedSocialTitles.add("Твиттер");
    }
}
