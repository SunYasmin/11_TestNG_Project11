package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MyAccountPage {

    public MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeMan;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[1]")
    public WebElement orders;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[2]")
    public WebElement downloads;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[3]")
    public WebElement addresses;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[4]")
    public WebElement accountDetails;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[5]")
    public WebElement wishlist;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[6]")
    public WebElement logOut;

    @FindBy (xpath = "//*[text()='Dashboard']")
    public WebElement dashboard;

    @FindBy (xpath = "(//*[text()='Orders'])[1]")
    public WebElement ordersUnderDashboard;

    @FindBy (xpath = "(//*[text()='Downloads'])[1]")
    public WebElement downloadsUnderDashboard;

    @FindBy (xpath = "(//*[text()='Addresses'])[1]")
    public WebElement addressesUnderDashboard;

    @FindBy (xpath = "(//*[text()='Account details'])[1]")
    public WebElement accountDetailsUnderDashboard;

    @FindBy (xpath = "(//*[text()='Wishlist'])[2]")
    public WebElement wishlistUnderDashboard;

    @FindBy (xpath = "//div//nav//ul//li")
    public List<WebElement> linkListOfMyAccount;

    @FindBy (xpath = "//*[text()='Support Tickets']")
    public WebElement supportTickets;

    @FindBy (xpath = "//*[text()='Followings']")
    public  WebElement followings;

    @FindBy (xpath = "(//*[text()='Logout'])[1]")
    public WebElement logoutUnderDashboard;

    @FindBy(xpath = "(//a[@href='https://pearlymarket.com/shop/'])[1]")
    public WebElement browseProduct;

    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']")
    public WebElement goToShop;





    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[5]")
    public WebElement wishlistLink;

    @FindBy(xpath = "//tr//td")
    public List<WebElement> orderAllCell;

    @FindBy(xpath = "//td[@class='woocommerce-orders-table__cell woocommerce-orders-table__cell-order-number']")
    public List<WebElement> orderNumberText;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> wishList;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> wishlistAllCell;

    @FindBy(xpath = "//td[@class='product-name']")
    public List<WebElement> wishCellText;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> adresList;

    @FindBy(xpath = "//tr//td")
    public List<WebElement> addressAllCell;

    @FindBy(xpath = "//input[@id='account_first_name']")
    public WebElement firstnameBox;

    @FindBy(xpath = "//input[@id='account_last_name']")
    public WebElement lastnameBox;

    @FindBy(xpath = "//input[@id='account_display_name']")
    public WebElement displayNameBox;

    @FindBy(xpath = "//input[@id='account_email']")
    public WebElement eMailBox;

    @FindBy(xpath = "//button[@name='save_account_details']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//*[text()='Not right now']")
    public WebElement notRightNow;

    @FindBy(xpath = "//button[@value='SUBSCRIBE']")
    public WebElement subscribe;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement accountDetailsChanged;





}
