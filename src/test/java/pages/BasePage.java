package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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

    //Esto es para localizar cualquier WebElement
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private WebElement FindCssSelector(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    //Esto es para dar click sobre algún webElement
    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void clickElementCss(String locator) {
        FindCssSelector(locator).click();
    }

    //Función para escribir algo en las cajas de texto
    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void writeLocatorCss(String locator, String textToWrite) {
        FindCssSelector(locator).clear();
        FindCssSelector(locator).sendKeys(textToWrite);
    }

    //Esto es para dar click en las opciones del select con value tipo text
    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    //Esto es para dar click en las opciones del select con value tipo int
    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    //Esto es para dar click en las opciones del con texto que ve el usuario
    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    //Funcion para hacer un hoverOverElement (pasar el cursor sobre algo)
    public void hoverOverElement(String locator) {
        action.moveToElement(Find(locator));
    }

    // funcion para hacer doble click
    public void doubleClick(String locator) {
        action.doubleClick(Find(locator));
    }

    // click derecho
    public void rightClick(String locator) {
        action.contextClick(Find(locator));
    }

    //Buscar en tablas
    public String getValueFromTable(String locator, int row, int colum) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + colum + "]";
        return Find(cellINeed).getText();
    }

    //Agregar valores a una tabla
    public void setValueOnTable(String locator, int row, int colum, String stringToSend) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + colum + "]";
        Find(cellINeed).sendKeys(stringToSend);
    }

    //
    public void switchToiFrame(int iFrameId) {
        driver.switchTo().frame(iFrameId);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
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

    // verificar que un webElement esta en la page
    public boolean elementIsDisplayed(String locator) {
        return Find(locator).isDisplayed();
    }

    //verifica si por ejemplo un boton esta habilitado
    public boolean elementIsEnabled(String locator) {
        return Find(locator).isEnabled();
    }

    //verifica si por ejemplo checkbox esta seleccionado
    public boolean elementIsSelect(String locator) {
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }

    //Funcion para mostrar el type ="file" en caso de estar oculto
    public void verTypeFile() {
        String change_visiblility = "$(\"#fileField\").css(\"visibility,\"visible\");";
        String change_display = "$(\"#fileField\").css(\"display,\"block\");";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(change_display);
        js.executeScript(change_visiblility);
    }

    public void maxWindow() {
        driver.manage().window().maximize();
    }
}
