package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {
    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//input[@id='user_email']")
    public WebElement email;

    @FindBy (xpath = "//input[@class='wcfm-text wcfm_email_verified_input']")
    public WebElement verificationCode;

    @FindBy (xpath = "//input[@id='passoword']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPassword;

    @FindBy (xpath = "//*[text()='Email: This field is required.']")
    public WebElement emailRequired;

    @FindBy (xpath = "//input[@type='submit']")
    public WebElement registerButton;
}
