package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    HelperSearch search;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public void init (){

if(browser.equals(BrowserType.CHROME)){
    wd = new EventFiringWebDriver(new ChromeDriver());
    logger.info("All tests starts in 'Chrome' browser");
}else if (browser.equals(BrowserType.FIREFOX)){
    wd = new EventFiringWebDriver(new FirefoxDriver());
    logger.info("All tests starts in 'Firefox' browser");
}


        //wd = new ChromeDriver();

        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.register(new MyListener());


        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        search = new HelperSearch(wd);

    }
    public void stop(){
        wd.quit();

    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCarHelper() {
        return carHelper;
    }

    public HelperSearch Search() {
        return search;
    }
}
