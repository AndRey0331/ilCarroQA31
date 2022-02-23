package tests;

import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase {

    @BeforeMethod
    public void preCondition() {
        // if logged [logout present???] ---> logout

        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }
    }


    @Test
    public void loginSuccess() {
        logger.info("The test start with email : [lenastep@gmail.com] & password [12345nnnN]");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("lenastep@gmail.com", "12345nnnN");
        app.getUserHelper().submitForm();
        // click ok

        //Assert
    }

    @Test
    public void loginSuccessModel() {

        User user = new User().withEmail("lenastep@gmail.com").withPassword("12345nnnN");

        logger.info("The test start with data: "+user.toString());
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitForm();
        app.getUserHelper().takeScreenShot("src/test/screenshots/scr1.png");
        //click ok

        //Assert
    }

    @AfterMethod
    public void postCondition() {
        app.getUserHelper().clickOkButton();

    }

}