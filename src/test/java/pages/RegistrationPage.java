package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RegistrationPage {
    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//input[@id='user_email']")
    public WebElement emailBox;

    @FindBy (xpath = "//input[@class='wcfm-text wcfm_email_verified_input']")
    public WebElement verificationCodeBox;

    @FindBy (xpath = "//input[@id='passoword']")
    public WebElement passwordBox;

    @FindBy (xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPasswordBox;

    @FindBy (xpath = "//*[text()='Email: This field is required.']")
    public WebElement emailRequired;

    @FindBy (xpath = "//input[@id='wcfm_membership_register_button']")
    public WebElement registerButton;

    @FindBy (xpath = "//button[@class='btn-rds icon-btn bg-theme click-to-copy']")
    public WebElement tempEmailAccountName;

    @FindBy (xpath = "//button[@class='refresh-countdown']")
    public WebElement tempEmailRefreshButton;

    @FindBy (xpath = "(//a[@class='viewLink title-subject'])[2]")
    public WebElement tempEmailInboxFirstEmail;

    @FindBy (xpath = "//div[@id='body_content_inner']")
    public WebElement emailContent;

    @FindBy (xpath = "//div[@style='display: block;']")
    public WebElement verificationCodeSentMessage;

    @FindBy (xpath = "//*[text()='Welcome to Pearly Market!']")
    public WebElement welcomeText;

    @FindBy (xpath = "//*[text()='Please provide a valid email address.']")
    public WebElement wrongEmailText;

    @FindBy (xpath = "//*[text()='Registration Successfully Completed.']")
    public WebElement registrationSuccessfullyCompleted;

    @FindBy (xpath = "//div[@class='inbox-dataList']")
    public List<WebElement> emailTitleList;

    @FindBy (xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement existingEmailWarningText;

    @FindBy (xpath = "//body//div//div//span//a[2]")
    public WebElement cookies;

    @FindBy (xpath = "//*[text()='Oturum açın']")
    public WebElement uniqueEmailSignInButton;

    @FindBy (xpath = "//input[@type='email']")
    public WebElement uniqueEmailBox;

    @FindBy (xpath = "//*[text()='Sonraki']")
    public WebElement uniqueEmailNextButton;

    @FindBy (xpath = "//input[@type='password']")
    public WebElement uniqueEmailPasswordBox;

    @FindBy (xpath = "//span[@class='bqe']")
    public WebElement firstEmailTitleText;

    @FindBy (xpath = "//*[text()='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement uniqueEmailWarningText;


}

