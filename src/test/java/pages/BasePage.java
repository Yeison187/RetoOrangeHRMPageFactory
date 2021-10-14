package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromeDriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
    }

    //Esto es para realizar una espera
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    //Esto es para ir a una url
    public static void navigateTo(String url) {
        driver.get(url);
    }

    //Cerrar navegador
    public static void closeBrowser() {
        driver.quit();
    }

    //Esto es para localizar cualquier WebElement con XPath
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private WebElement FindCssSelector(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    //Esto es para dar click sobre algún webElement sin page factory
    public void clickElement(String locator) {
        Find(locator).click();
    }

    //Esto es para dar click sobre algún webElement con page factory
    public void clickElementPageFactory(WebElement locator) {
        locator.click();
    }


    public void clickElementCss(String locator) {
        FindCssSelector(locator).click();
    }

    //Función para escribir algo en las cajas de texto
    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    //Función para escribir algo en las cajas de texto con pageFactory
    public void writePageFactory(WebElement locator, String textToWrite) {
        locator.clear();
        locator.sendKeys(textToWrite);
    }


    //Esto es para dar click en las opciones del con texto que ve el usuario
    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }


    public void dismmissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    //retornar el dato de un WebElement
    public String textFromElement(String locator) {
        return Find(locator).getText();
    }

    //retornar el dato de un WebElement con page factory
    public String textFromElementPageFactory(WebElement locator) {
        return locator.getText();
    }

    // verificar que un webElement esta en la page
    public boolean elementIsDisplayed(String locator) {
        return Find(locator).isDisplayed();
    }

    public void maxWindow() {
        driver.manage().window().maximize();
    }
}