package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement addNewButton;

    @FindBy(xpath = "//*[@id='pro_title']")
    public WebElement productTitle;

    @FindBy (xpath = "//input[@value='Submit']")
    public WebElement submitButon;










































    /////////////////////////////////////Inventory //////////////////////////////////////////////////////////////


    @FindBy (xpath = "//input[@id='manage_stock']")
    public WebElement manageStockBox;

    @FindBy (xpath = "//input[@id='stock_qty']")
    public WebElement stockQtyBox;

    @FindBy (xpath = "//select[@id='backorders']")
    public WebElement backorderDropdown;






}
