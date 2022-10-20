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






























    @FindBy (xpath = "//select[@id='dropdown_product_type']")
    public WebElement allProductsTypes;//Zeynep

    @FindBy (xpath = "(//a[@class='wcfm_product_title'])[1]")
    public WebElement urunListesindenAl;//Zeynep


    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit_button']")
    public WebElement submit;//Zeynep




    /////////////////////////////////////Inventory Zeynep //////////////////////////////////////////////////////////////


    @FindBy (xpath = "//input[@id='manage_stock']")
    public WebElement manageStockBox;

    @FindBy (xpath = "//input[@id='stock_qty']")
    public WebElement stockQtyBox;

    @FindBy (xpath = "//select[@id='backorders']")
    public WebElement backorderDropdown;

    ////////////////////////////////Toptan urun gosterme ayarlari  Zeynep///////////////////////////////////////////////

    @FindBy (xpath = "//select[@id='catalog_visibility']")
    public WebElement catalogVisibility;

    @FindBy (xpath = "(//*[text()='Toptan Ürün Gösterme Ayarları'])[1]")
    public WebElement toptanUrunGostermeAyarlariSekmesi;

    @FindBy (xpath = "//select[@id='piecetype']")
    public WebElement pieceType;

    @FindBy (xpath = "//input[@id='unitpercart']")
    public WebElement unitsPerPiece;

    @FindBy (xpath = "//input[@id='minorderqtytr']")
    public WebElement minOrderQty;




}
