package utils;

import Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageInitializer;

import java.time.Duration;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        ConfigReader.configReader(Constant.CONFIG_READER_PATH);

        switch (ConfigReader.getPropertyValue("browser").toLowerCase() ){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        initializePageObjects();

    }


    public static void closeBrowser(){
        driver.quit();
    }


    public static void sendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }
    public static void elementClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        elementClickable(element);
        element.click();
    }
    public static JavascriptExecutor jsExecutor(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
       return js;
    }
    public static void jsClick(WebElement element){
        jsExecutor().executeScript("argument[0].click();", element);
    }
    public static void jsSendText(WebElement element, String text){
        jsExecutor().executeScript("argument[0].value=" +text, element);
    }

}
