package ru.mail.yandex.tests.signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mail.yandex.data.ErrorData;
import ru.mail.yandex.pages.SignUpPage;
import ru.mail.yandex.tests.WebTest;

import java.util.ArrayList;
import java.util.Iterator;

public class TestSignUp extends WebTest {
    private SignUpPage signUpPage = PageFactory.initElements(getDriver(), SignUpPage.class);
    private ArrayList<ErrorData> errors = new ArrayList<>();

    @Override
    public void setUpBeforeMethod() {}

    @Override
    public boolean test() {
        signUpPage.open();
        Iterator<ErrorData> errorIterator = errors.iterator();
        ErrorData errorData = errorIterator.next();
        try {
            signUpPage.typeInFirstname(errorData.getData());
            if (!signUpPage.errorIs().equals(errorData.getText())) throw new Exception();
        } catch (Exception ex) {
            failedPrint(this, errorData.getTest());
            status = false;
        }

        signUpPage.typeInFirstname("Firstname");
        try {
            errorData = errorIterator.next();
            signUpPage.typeInLastname(errorData.getData());
            if (!signUpPage.errorIs().equals(errorData.getText())) throw new Exception();
        } catch (Exception ex) {
            failedPrint(this, errorData.getTest());
            status = false;
        }

        signUpPage.typeInLastname("Lastname");
        for (int i = 0; i < 4; i++) {
            errorData = errorIterator.next();
            try {
                signUpPage.typeInLogin(errorData.getData());
                if (!signUpPage.errorIs().equals(errorData.getText())) throw new Exception();
            } catch (Exception ex) {
                failedPrint(this, errorData.getTest());
                status = false;
            }
        }

        signUpPage.typeInLogin("somenewlogin012");
        for (int i = 0; i < 5; i++) {
            errorData = errorIterator.next();
            try {
                String errorMessage = errorData.getText();
                signUpPage.typeInPassword(errorData.getData());
                if (!new WebDriverWait(getDriver(),10).until(((ExpectedCondition<Boolean>) driver -> driver.findElement(By.className("error-message")).getText().equals(errorMessage)))){
                    throw new Exception();
                }
            } catch (Exception ex) {
                failedPrint(this, errorData.getTest());
                status = false;
            }
        }

        signUpPage.typeInPassword("123456qWe");
        try {
            errorData = errorIterator.next();
            String errorMessage = errorData.getText();
            signUpPage.typeInPasswordConfirm(errorData.getData());
            if (!new WebDriverWait(getDriver(),10).until(((ExpectedCondition<Boolean>) driver -> driver.findElement(By.className("error-message")).getText().equals(errorMessage)))){
                throw new Exception();
            }
        } catch (Exception ex) {
            failedPrint(this, errorData.getTest());
            status = false;
        }

        signUpPage.typeInPasswordConfirm("123456qWe");
        try {
            errorData = errorIterator.next();
            signUpPage.typeInPhone(errorData.getData());
            signUpPage.clickSignUp();
            if (!signUpPage.errorIs().equals(errorData.getText()) || signUpPage.isTextInPhoneAllowed(errorData.getData())) throw new Exception();
        } catch (Exception ex) {
            failedPrint(this, errorData.getTest());
            status = false;
        }

        signUpPage.typeInPhone("");
        WebElement linkToQuestion = getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/form/div[3]/div/div[2]/div/span"));
        try {
            linkToQuestion.click();
            boolean isShown = getDriver().findElement(By.id("hint_answer")).isDisplayed();
            System.out.println(isShown);
            if (!isShown) throw new Exception();
        } catch (Exception ex) {
            failedPrint(this, "question field appearance after click");
            status = false;
        }

        signUpPage.typeInPhone("");
        try {
            errorData = errorIterator.next();
            linkToQuestion.click();
            linkToQuestion.click();
            signUpPage.typeInAnswer(errorData.getData());
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
            if (!signUpPage.errorIs().equals(errorData.getText())) throw new Exception();
        } catch (Exception ex) {
            failedPrint(this, errorData.getTest());
            status = false;
        }

        signUpPage.typeInAnswer("Answer");
        try {
            errorData = errorIterator.next();
            signUpPage.typeInCaptcha(errorData.getData());
            String errorMessage = errorData.getText();
            if (!new WebDriverWait(getDriver(),10).until(((ExpectedCondition<Boolean>) driver -> driver.findElement(By.className("error-message")).getText().equals(errorMessage)))){
                throw new Exception();
            }
        } catch (Exception ex) {
            failedPrint(this, errorData.getTest());
            status = false;
        }

        return status;
    }

    public TestSignUp(){
        initErrors();
    }

    private void initErrors() {
        errors.add(new ErrorData("empty firstname field", "Пожалуйста, укажите имя", "  "));
        errors.add(new ErrorData("empty lastname field", "Пожалуйста, укажите фамилию", "  "));
        errors.add(new ErrorData("empty login field", "Необходимо выбрать логин", "  "));
        errors.add(new ErrorData("special character in login field", "Необходимо выбрать логин", "1somenewlogin012"));
        errors.add(new ErrorData("starting with num character in login field", "Необходимо выбрать логин", "$somenewlogin012"));
        errors.add(new ErrorData("russian character in login field", "Необходимо выбрать логин", "somenewЛogin012"));
        errors.add(new ErrorData("short sequence in password field", "Пароль слишком короткий", "12345"));
        errors.add(new ErrorData("only num sequence in password field", "Пароль слишком простой", "1234567"));
        errors.add(new ErrorData("space in password field", "Пароль содержит запрещённые символы", "1234 567"));
        errors.add(new ErrorData("russian character in password field", "Пароль содержит запрещённые символы", "И1234567"));
        errors.add(new ErrorData("login in password field", "Пароль не может совпадать с логином", "somenewlogin012"));
        errors.add(new ErrorData("wrong sequence in password confirm field", "Подтверждение не совпадает с паролем", "123"));
        errors.add(new ErrorData("letters in phone field", "Недопустимый формат номера", "not_allow"));
        errors.add(new ErrorData("empty answer field", "Необходимо указать ответ на контрольный вопрос", "   "));
        errors.add(new ErrorData("empty captcha field", "Необходимо ввести символы", "   "));

    }
}
