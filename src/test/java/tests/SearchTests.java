package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestsBase{

    @Test
    public void searchPeriodCurrentMonth(){

        //1/28/2022 - 1/30/2022
        app.Search().fillSearchFormCurrentMonth("Tel Aviv, Israel","1/31/2022","1/31/2022");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.Search().isListOfCarsAppeared());

    }

    @Test
    public void searchPeriodCurrentMonth2(){

        //1/28/2022 - 1/30/2022
        app.Search().fillSearchFormCurrentMonth("Rehovot, Israel","1/31/2022","1/31/2022");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.Search().isListOfCarsAppeared());

    }

    @Test
    public void typePeriodInFuture(){
        //1/30/2022 - 1/31/2022
        // app.search().fillSearchFormInPast("Rehovot, Israel","1/30/2022","1/30/2022");

        // Yalla not clickable
        // error message displaeyd
    }

    @Test
    public void searchPeriodAnyDataInFuture(){

        //"3/30/2022","6/25/2022"
        //"3/30/2022","1/31/2023"
        //"1/10/2023" "1/31/2023"
        app.Search().fillSearchFormInFuture("Tel Aviv, Israel","01/10/2023","01/31/2023" );
        app.Search().pause(7000);
        app.getUserHelper().submitForm();


        Assert.assertTrue(app.Search().isListOfCarsAppeared());
    }

    @AfterMethod
    public void posCondition(){
        app.Search().returnToHome();
    }


}