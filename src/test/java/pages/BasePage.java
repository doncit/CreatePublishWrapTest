package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by vaididon on 6/13/2016.
 */
public class BasePage {
    protected WebDriver driver = null;
    public static final String CREATE_WRAP_URL = "https://www.qa.wrapdev.net/";

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver startDriver(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--test-type");

            driver = new ChromeDriver(options);

        } else if (browser.equals("Firefox")) {

            driver = new FirefoxDriver();

        }

        driver.manage().window().maximize();

        return driver;
    }

    public void init() {
        startDriver("chrome");
        driver.get(CREATE_WRAP_URL);
    }

    public void waitFor(By by) {

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void quitDriver() {
        driver.quit();
    }

}
