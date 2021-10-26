package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;

public class LoginOrangeHRMPage extends BasePage {
    @FindBy(xpath = "//input[@id='txtUsername']")
    @CacheLookup
    private WebElement emailLocator;

    @FindBy(xpath = "//input[@id='txtPassword']")
    @CacheLookup
    private WebElement passLocator;

    @FindBy(xpath = "//input[@id='btnLogin']")
    @CacheLookup
    private WebElement buttonLoginLocator;

    @FindBy(xpath = "//span[@id='spanMessage']")
    @CacheLookup
    private WebElement message;

    @FindBy(xpath = "//b[contains(text(),'Dashboard')]")
    @CacheLookup
    private WebElement validLogin;

    public LoginOrangeHRMPage() {
        super(driver);
    }

    public void navigateToOrangeHrm(String url) {
        navigateTo(url);
    }

    public void writeEmail(String criteria) throws InterruptedException {
        try {
            writePageFactory(emailLocator, criteria);
        } catch (NoSuchElementException e) {
            System.out.println("No se encontro el elemento");
            e.printStackTrace();
        }
    }

    public void writePass(String criteria) {
        writePageFactory(passLocator, criteria);
    }

    public void clickButtonLogin() {
        clickElementPageFactory(buttonLoginLocator);
    }


    public String validateMessage() {
        return textFromElementPageFactory(message);
    }

    public String loginTrue() {
        return textFromElementPageFactory(validLogin);
    }


}
