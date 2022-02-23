package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestsBase {
    @BeforeMethod
    public void preCondition(){
        // if logged ---> login()
        if(!app.getUserHelper().isLogOutPresent()){
            User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
            app.getUserHelper().login(user);
            logger.info(" Car was edded for user" + user.toString());
        }
    }
    @Test
    public void addNewCarSuccess(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println(index);


        Car car = Car.builder()
                .addres("Tell-Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("3.0")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .carRegNumber("178-"+index)
                .seats("4")
                .clasS("E")
                .fuelConsumption("10.0")
                .price("70")
                .distanceIncluded("700")
                .features("type of")
                .about("No Smoking")
                .build();

        logger.info("Car was edded" +car.toString());

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().attachPhoto("/Users/andreybenchuk/Dropbox/Mac/Downloads/204520.jpg");
        app.getCarHelper().submitForm();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }
    @Test


    public void addNewCarSuccess2(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println(index);


        Car car = Car.builder()
                .addres("Tell-Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("3.0")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .carRegNumber("178-"+index)
                .seats("4")
                .clasS("E")
                .fuelConsumption("10.0")
                .price("70")
                .distanceIncluded("700")
                .features("type of")
                .about("No Smoking")
                .build();

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().attachPhoto("/Users/andreybenchuk/Dropbox/Mac/Downloads/204520.jpg");
        app.getCarHelper().submitForm();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }
    @AfterMethod
    public void postConditions(){
        app.getCarHelper().clickSearchButton();
        app.getUserHelper().logout();
    }


}
