package steps;

import io.cucumber.java.en.*;
import pages.MyInfoPage;

public class MyInfoSteps {
    MyInfoPage myInfoPage = new MyInfoPage();

    @Given("necesito agregar una nueva dependencia")
    public void nuevaDependencia() {
        myInfoPage.addDependency();

    }

    @When("^doy clic en el boton add del area Assigned Dependents,diligencio todos los campos (.+),(.+),(.+)$")
    public void diligenciarFormulario(String name, String dependents,String birth) {
        myInfoPage.writeFormAdd(name,dependents,birth);
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
        myInfoPage.addFile(ruta);
    }

    @When("^diligencio el campo comment (.+), doy clic sobre el boton save$")
    public void subirArchivo(String comentario) {
        myInfoPage.uploadFile(comentario);
    }

    @Then("^se debe mostra el mensaje: (.+)$")
    public void confirmarProcesoExitoso(String mensaje) {

    }

}
