package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage{

    private String MyInfoLocator = "//b[contains(text(),'My Info')]";
    private String dependentsLocator = "//a[contains(text(),'Dependents')]";
    private String addDependentsLocator = "//input[@id='btnAddDependent']";
    private String nameDependentsLocator = "//input[@id='dependent_name']";
    private String selectDependentsLocator = "//select[@id='dependent_relationshipType']";
    private String dateBirthLocator = "//input[@id='dependent_dateOfBirth']";
    private String  btnSaveDependentsLocator = "//input[@id='btnSaveDependent']";

    private String addAttachsmentLocator = "//input[@id='btnAddAttachment']";
    private String selectFileLocator = "//input[@id='ufile']";
    private String commentLocator = "//textarea[@id='txtAttDesc']";
    private String uploadLocator = "//input[@id='btnSaveAttachment']";

    @FindBy(id = "Boton")
    WebElement boton;

    public MyInfoPage(){
        super(driver);
    }


    public void addDependency(){
        maxWindow();
        clickElement(MyInfoLocator);
        clickElement(dependentsLocator);
        maxWindow();

    }

    public  void writeFormAdd(String name,String dependents, String birth){
        clickElement(addDependentsLocator);
        write(nameDependentsLocator,name);
        selectFromDropdownByText(selectDependentsLocator,dependents);
        write(dateBirthLocator,birth);
    }

    public void saveDependency(){
        clickElement(btnSaveDependentsLocator);
    }

    public void newFile(){
        clickElement(addAttachsmentLocator);
    }

    public void addFile(String ruta){
        write(selectFileLocator,ruta);
    }

    public void uploadFile(String comentario){
        write(commentLocator,comentario);
        clickElement(uploadLocator);
    }
}
