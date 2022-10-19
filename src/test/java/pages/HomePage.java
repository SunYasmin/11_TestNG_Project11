package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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



}
