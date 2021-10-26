package steps;

import io.cucumber.java.en.*;


import org.junit.Assert;
import pages.LoginOrangeHRMPage;
import pages.MyInfoPage;

public class MyInfoSteps {
    private static final String URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    MyInfoPage myInfoPage = new MyInfoPage();
    LoginOrangeHRMPage loginOrangeHRMPage = new LoginOrangeHRMPage();

    @Given("^necesito agregar una nueva dependencia, ingreso con el usuario (.+), la contraseña (.+)$")
    public void nuevaDependencia(String user, String pass) throws InterruptedException {
        loginOrangeHRMPage.navigateToOrangeHrm(URL);
        loginOrangeHRMPage.writeEmail(user);
        loginOrangeHRMPage.writePass(pass);
        loginOrangeHRMPage.clickButtonLogin();
        String value = loginOrangeHRMPage.loginTrue();
        Assert.assertEquals("Dashboard", value);
        myInfoPage.addDependency();

    }

    @When("^doy clic en el boton add del area Assigned Dependents,diligencio todos los campos (.+),(.+),(.+)$")
    public void diligenciarFormulario(String name, String dependents, String birth) {
        myInfoPage.writeFormAdd(name, dependents, birth);
    }

    @When("doy clic sobre el boton save")
    public void guardarDependencia() {
        myInfoPage.saveDependency();
    }

    @Given("necesito agregar un nuevo archivo")
    public void nuevoArchivo() {
        myInfoPage.newFile();
    }

    @When("^doy clic en el boton add del area Assigned Attachments,adjunto el archivo (.+)$")
    public void adjuntarArchivo(String ruta) {
        myInfoPage.addFile(System.getProperty("user.dir") + ruta);
    }

    @When("^diligencio el campo comment (.+), doy clic sobre el boton save$")
    public void subirArchivo(String comentario) {
        myInfoPage.uploadFile(comentario);
    }

    @Then("^se debe mostra el mensaje: (.+)$")
    public void confirmarProcesoExitoso(String mensaje) {

    }

}
