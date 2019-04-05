package ru.mail.yandex;

import ru.mail.yandex.tests.SignIn.TestValidSignIn;
import ru.mail.yandex.tests.WebTest;

import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        int runnedTests = 0;
        int failedTests = 0;
        boolean success;

        for (WebTest webTest: App.initTests()){
            runnedTests++;
            webTest.setUpBeforeMethod();
            success = webTest.test();
            webTest.tearDownAfterTestClass();;
            if (!success) failedTests++;
        }

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Tests runned: " + runnedTests + ". Failed tests: " + failedTests);
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static ArrayList<WebTest> initTests(){
        ArrayList<WebTest> testList = new ArrayList<>();
        testList.add(new TestValidSignIn());
        return testList;
    }
}
