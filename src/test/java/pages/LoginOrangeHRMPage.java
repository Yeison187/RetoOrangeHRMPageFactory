package pages;


import org.openqa.selenium.NoSuchElementException;

public class LoginOrangeHRMPage extends BasePage {
    private String emailLocator = "//input[@id='txtUsername']";
    private String passLocator = "//input[@id='txtPassword']";
    private String buttonLoginLocator = "//input[@id='btnLogin']";
    private String message = "//span[@id='spanMessage']";
    private String validLogin = "//b[contains(text(),'Dashboard')]";

    public LoginOrangeHRMPage() {
        super(driver);
    }

    public void navigateToOrangeHrm() {
        navigateTo("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }

    public void writeEmail(String criteria) throws InterruptedException {
        try {
            write(emailLocator, criteria);
        } catch (NoSuchElementException e) {
            System.out.println("No se encontro el elemento");
            e.printStackTrace();
        }
    }

    public void writePass(String criteria) {
        write(passLocator, criteria);
    }

    public void clickButtonLogin() {
        clickElement(buttonLoginLocator);
    }

    public String validateMessage() {
        return textFromElement(message);
    }

    public String loginTrue() {
        return textFromElement(validLogin);
    }


}
