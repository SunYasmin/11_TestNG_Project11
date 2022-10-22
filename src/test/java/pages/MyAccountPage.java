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







}
