package com.virgin.games.browserfactory;

import com.virgin.games.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageBrowser {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class.getName());
    public static WebDriver driver;
    public String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    public String secondsInString = PropertyReader.getInstance().getProperty("implicitlyWait");
    public long seconds = Long.parseLong(secondsInString);

    public ManageBrowser(){
        PageFactory.initElements(driver,this);
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/propertiesfile/log4j2.properties");
    }

    public void selectBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            log.info("launching chrome browser");
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            log.info("launching firefox browser");
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("edge")){
            log.info("launching edge browser");
            driver = new EdgeDriver();
        } else if(browser.equalsIgnoreCase("safari")){
            log.info("launching safari browser");
            driver = new SafariDriver();
        }else {
            log.info("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.get(baseUrl);
        log.info("navigate to given url");
    }

    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
