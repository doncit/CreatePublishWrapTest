package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


/**
 * Created by vaididon on 6/11/2016.
 */
public class SignUpForPersonalPlanPage extends BasePage {

    public static final By FREE_TRIAL_BUTTON = By.cssSelector("#freeTrial");
    public static final By SIGN_UP_BUTTON = By.cssSelector(".pricing-cta");
    public static final By EMAIL_INPUT = By.cssSelector(".o-auth-input");
    public static final By SUBMIT_BUTTON = By.cssSelector(".o-auth-button");
    public static final By PASSWORD_INPUT = By.cssSelector("input.o-auth-input");
    public static final By ENTER_USERNAME_LINK = By.cssSelector(".o-auth-link");
    public static final String PASSWORD = "Donata";
    public static final By SIGNUP_EMAIL = By.cssSelector(".signup_email");
    public static final By COMPLETE_ACCOUNT_INFO = By.cssSelector(".o-auth-title");
    public static final By COMPLETE_ACCOUNT_INFO_INPUT = By.cssSelector(".o-auth-input");
    public static final String FIRST_NAME = "Donata";
    public static final String LAST_NAME = "Donata Last Name";
    public static final String COMPANY = "Company";
    public static final String PHONE = "1111";
    public static final By PUBLISH_WRAP_PAGE = By.cssSelector("#wrap-theme");


    public void fillInCompleteAccountInfoForm() {
        waitFor(COMPLETE_ACCOUNT_INFO_INPUT);
        List<WebElement> infoInputs = driver.findElements(COMPLETE_ACCOUNT_INFO_INPUT);
        for (WebElement infoInput : infoInputs) {
            if (infoInput.getAttribute("placeholder").equalsIgnoreCase("First Name *")) {
                infoInput.clear();
                infoInput.sendKeys(FIRST_NAME);
            } else if (infoInput.getAttribute("placeholder").equalsIgnoreCase("Last Name *")) {
                infoInput.clear();
                infoInput.sendKeys(LAST_NAME);
            } else if (infoInput.getAttribute("placeholder").equalsIgnoreCase("Company *")) {
                infoInput.clear();
                infoInput.sendKeys(COMPANY);
            }
            if (infoInput.getAttribute("placeholder").equalsIgnoreCase("Phone number")) {
                infoInput.clear();
                infoInput.sendKeys(PHONE);
            }
        }
    }

    public void clickOnLinkToEnterUsername() {
        waitFor(SIGNUP_EMAIL);
        driver.findElement(ENTER_USERNAME_LINK).click();
    }

    public void enterPassword() {
        waitFor(SIGNUP_EMAIL);
        List<WebElement> usernamePasswordInputs = driver.findElements(PASSWORD_INPUT);
        for (WebElement usernamePasswordInput : usernamePasswordInputs) {
            if (usernamePasswordInput.getAttribute("type").equalsIgnoreCase("password")) {
                usernamePasswordInput.clear();
                usernamePasswordInput.sendKeys(PASSWORD);
            }
        }
    }

    public void clickOnFreeTrialButton() {

        waitFor(FREE_TRIAL_BUTTON);
        driver.findElement(FREE_TRIAL_BUTTON).click();
    }

    public void signUp() {
        driver.findElement(SIGN_UP_BUTTON).click();
    }

    public void enterEmail() {
        waitFor(EMAIL_INPUT);
        driver.findElement(EMAIL_INPUT).clear();
        driver.findElement(EMAIL_INPUT).sendKeys(generateEmail());
    }

    public void createAccount() {

        driver.findElement(SUBMIT_BUTTON).click();
        waitFor(COMPLETE_ACCOUNT_INFO);
    }

    public void submitEmail() {
        List<WebElement> buttons = driver.findElements(SUBMIT_BUTTON);
        for (WebElement button : buttons)
            if (button.getText().equalsIgnoreCase("Sign up")) {
                button.click();
                waitFor(SIGNUP_EMAIL);
            }
    }

    public CreateAndPublishWrapPage finalCreateAccount() {
        List<WebElement> buttons = driver.findElements(SUBMIT_BUTTON);
        for (WebElement button : buttons)
            if (button.getText().equalsIgnoreCase("Create account")) {
                button.click();
                waitFor(PUBLISH_WRAP_PAGE);
            }

        return new CreateAndPublishWrapPage(driver);
    }

    private String generateEmail() {
        Random random = new Random();
        int number = random.nextInt(1000);
        String randoms = String.format("%03d", number);
        return "donatava@gmail" + randoms + ".com";
    }
}
