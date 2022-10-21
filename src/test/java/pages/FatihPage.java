package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FatihPage {


    public FatihPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public  WebElement storeManager;

    @FindBy(xpath="(//*[@class='text'])[4]")
    public  WebElement products;

    @FindBy(xpath="(//*[@class='text'])[18]")
    public  WebElement addNew;

    @FindBy(className = "button media-button button-primary button-large media-button-select")
    public  WebElement addproductSelect;
}
