package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage{
    @FindBy(xpath = "//b[contains(text(),'My Info')]")
    @CacheLookup
    private WebElement MyInfoLocator;

    @FindBy(xpath = "//a[contains(text(),'Dependents')]")
    @CacheLookup
    private WebElement dependentsLocator;

    @FindBy(xpath = "//input[@id='btnAddDependent']")
    @CacheLookup
    private WebElement addDependentsLocator;

    @FindBy(xpath = "//input[@id='dependent_name']")
    @CacheLookup
    private WebElement nameDependentsLocator;

    private String selectDependentsLocator = "//select[@id='dependent_relationshipType']";


    @FindBy(xpath = "//input[@id='dependent_dateOfBirth']")
    @CacheLookup
    private WebElement dateBirthLocator;

    @FindBy(xpath = "//input[@id='btnSaveDependent']")
    @CacheLookup
    private WebElement  btnSaveDependentsLocator;

    @FindBy(xpath = "//input[@id='btnAddAttachment']")
    @CacheLookup
    private WebElement addAttachsmentLocator;

    @FindBy(xpath = "//input[@id='ufile']" )
    @CacheLookup
    private WebElement selectFileLocator;

    @FindBy(xpath = "//input[@id='dependent_relationship']")
    @CacheLookup
    private  WebElement relationshipLocator;

    @FindBy(xpath = "//textarea[@id='txtAttDesc']")
    @CacheLookup
    private WebElement commentLocator;

    @FindBy(xpath = "//input[@id='btnSaveAttachment']" )
    @CacheLookup
    private WebElement uploadLocator;

    public MyInfoPage(){
        super(driver);
    }


    public void addDependency(){
        maxWindow();
        clickElementPageFactory(MyInfoLocator);
        clickElementPageFactory(dependentsLocator);
    }

    public  void writeFormAdd(String name,String dependents, String birth){
        clickElementPageFactory(addDependentsLocator);
        writePageFactory(nameDependentsLocator,name);
        selectFromDropdownByText(selectDependentsLocator,dependents);
        if (elementIsDisplayed(relationshipLocator)){
            writePageFactory(relationshipLocator,"Prueba");
        }
        writePageFactory(dateBirthLocator,birth);
    }

    public void saveDependency(){
        clickElementPageFactory(btnSaveDependentsLocator);
    }

    public void newFile(){
        clickElementPageFactory(addAttachsmentLocator);
    }

    public void addFile(String ruta){
        writePageFactory(selectFileLocator,ruta);
    }

    public void uploadFile(String comentario){
        writePageFactory(commentLocator,comentario);
        clickElementPageFactory(uploadLocator);
    }
}
