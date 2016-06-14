package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by vaididon on 6/13/2016.
 */
public class CreateAndPublishWrapPage extends BasePage {
    public static final By CREATE_NEW_WRAP_BUTTON = By.cssSelector(".wraps_create-btn");
    public static final By TEMPLATE = By.cssSelector(".template-categories_category");
    public static final By CREATE_WRAP_BUTTON = By.cssSelector(".btn.btn-success");
    public static final By CLOSE_HELP_ICON = By.cssSelector(".wrap-icon");

    public CreateAndPublishWrapPage(WebDriver driver) {
        super(driver);
    }

    public CreateAndPublishWrapPage() {

    }

    public void clickOnCreateNewWrap() {

        driver.findElement(CREATE_NEW_WRAP_BUTTON).click();
    }

    public void selectTemplate() {
        waitFor(TEMPLATE);
        driver.findElement(TEMPLATE).click();
        waitFor(CREATE_NEW_WRAP_BUTTON);
    }

    public void clickToCreateWrap() {
        waitFor(CREATE_WRAP_BUTTON);
        driver.findElement(CREATE_WRAP_BUTTON).click();
        waitFor(CLOSE_HELP_ICON);
    }

    public void clickCloseHelpIcon() {
        waitFor(CLOSE_HELP_ICON);
        driver.findElement(CLOSE_HELP_ICON).click();
        waitFor(CREATE_WRAP_BUTTON);
    }
}
