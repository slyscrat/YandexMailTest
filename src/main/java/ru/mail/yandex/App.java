package ru.mail.yandex;

import ru.mail.yandex.tests.SignIn.TestInvalidSignIn;
import ru.mail.yandex.tests.WebTest;

import java.util.ArrayList;

public class App {
    public static void main(String[] args){

        int runnedTests = 0, failedTests = 0;
        boolean success;

        for (WebTest webTest: initTests()){
            runnedTests++;
            webTest.setUpBeforeMethod();
            if (!webTest.test()) failedTests++;
        }
        WebTest.tearDownAfterTests();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Tests runned: " + runnedTests + ". Failed tests: " + failedTests);
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private static ArrayList<WebTest> initTests(){
        ArrayList<WebTest> testList = new ArrayList<>();
        //testList.add(new TestMainPage());
        //testList.add(new TestInvalidSignUp());
        testList.add(new TestInvalidSignIn());
        //testList.add(new TestValidSignIn());
        return testList;
    }
}
