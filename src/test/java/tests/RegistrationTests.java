package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestsBase {

    @BeforeMethod
    public void preCondition() {
        // if logged [logout present???] ---> logout

        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }
    }
    @Test
    public void registrationSuccess() {


        int index = (int) (System.currentTimeMillis() / 1000 % 3600);
        System.out.println(index);
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm("Lola", "Dow", "dow" + index + "@gmail.com", "Jj12345$");
        app.getUserHelper().checkPolicy();
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }


    @Test
    public void registrationSuccessModel() {


        int index = (int) (System.currentTimeMillis() / 1000 % 3600);
        System.out.println(index);

        User user = new User().withName("Lola").withLastName("Dow").withEmail("dow" + index + "@gmail.com").withPassword("Jj12345$");

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkPolicy();
        app.getUserHelper().pause(200);
        app.getUserHelper().submitForm();

        //Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }

    @AfterMethod
    public void postCondition() {
        app.getUserHelper().clickOkButton();

    }

}