package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginOrangeHRMPage;

public class LoginOrangeHRMSteps {

    LoginOrangeHRMPage loginOrangeHRMPage = new LoginOrangeHRMPage();

    @Given("necesito ingresar al sistema OrangHRM")
    public void ingresoSistema() {
        loginOrangeHRMPage.navigateToOrangeHrm();
    }

    @When("^ingreso un (.+)$")
    public void ingresoUsuario(String user) throws InterruptedException {
        loginOrangeHRMPage.writeEmail(user);

    }

    @When("^una (.+)")
    public void ingresoClave(String pass) {
        loginOrangeHRMPage.writePass(pass);

    }
    

    @Then("^al dar click en el boton Login, debe ingresar al sistema$")
    public void ingresaSistema() {
        loginOrangeHRMPage.clickButtonLogin();
        String value = loginOrangeHRMPage.loginTrue();
        Assert.assertEquals("Dashboard", value);

    }

}
