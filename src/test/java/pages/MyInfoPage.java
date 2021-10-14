package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage{

    @CacheLookup
    private String MyInfoLocator = "//b[contains(text(),'My Info')]";
    @CacheLookup
    private String dependentsLocator = "//a[contains(text(),'Dependents')]";
    @CacheLookup
    private String addDependentsLocator = "//input[@id='btnAddDependent']";
    @CacheLookup
    private String nameDependentsLocator = "//input[@id='dependent_name']";
    @CacheLookup
    private String selectDependentsLocator = "//select[@id='dependent_relationshipType']";
    @CacheLookup
    private String dateBirthLocator = "//input[@id='dependent_dateOfBirth']";
    @CacheLookup
    private String  btnSaveDependentsLocator = "//input[@id='btnSaveDependent']";

    @CacheLookup
    private String addAttachsmentLocator = "//input[@id='btnAddAttachment']";
    @CacheLookup
    private String selectFileLocator = "//input[@id='ufile']";
    @CacheLookup
    private String commentLocator = "//textarea[@id='txtAttDesc']";
    @CacheLookup
    private String uploadLocator = "//input[@id='btnSaveAttachment']";

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
