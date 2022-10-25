package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement userEmail;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccount;

    @FindBy (xpath = "//*[text()='Register']")
    public WebElement registerHomePage;

    @FindBy (xpath = "//*[text()='Become a Vendor']")
    public WebElement becomeAVendor;

    @FindBy (xpath = "//h2[@class='page-title']")
    public WebElement vendorRegistration;

























    @FindBy (xpath = "//*[@class='site-logo skip-data-lazy attachment-full size-full']")
    public WebElement pearlyMarketYazisi;

    @FindBy (xpath = "//*[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public WebElement addToCartSimgesi;

    @FindBy(xpath = "//*[@class='cart-count']")
    public WebElement cartUrunSayisiWe;

    @FindBy (xpath = "//*[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']")
    public List<WebElement> urunList12li;


    //2. vendor hesabi webelementleri
    @FindBy (xpath = "(//*[.='MY ACCOUNT'])[3]")
    public WebElement myAccountYaziWe;

    @FindBy (xpath = "(//*[.='My Orders'])[2]")
    public WebElement myOrders;

    @FindBy (xpath = "(//*[.='COMPANY'])[3]")
    public WebElement companyYaziWe;

    @FindBy (xpath = "//a[@href='/about-us/']")
    public WebElement aboutUs;


}
