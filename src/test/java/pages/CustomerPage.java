package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CustomerPage {
    public CustomerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerBUtton;

    @FindBy(xpath = "(//*[@class='text'])[7]")
    public WebElement customerButton;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> kisiListesi;

    @FindBy(xpath = "(//*[.='Print'])[2]")
    public WebElement printButton;

    @FindBy(xpath = "(//*[.='PDF'])[2]")
    public WebElement pdfButton;

    @FindBy(xpath = "(//*[.='Excel'])[2]")
    public WebElement excelButton;

    @FindBy(xpath = "(//*[.='CSV'])[2]")
    public WebElement csvButton;

    @FindBy(xpath = "(//*[.='Add New'])[2]")
    public WebElement addNewButton;

    @FindBy(xpath = "//*[@id='user_name']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement emailTextBox;


    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement lastNameBox;

    @FindBy(id = "wcfm_customer_submit_button")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='bfirst_name']")
    public WebElement firstNameTextBox2;

    @FindBy(xpath = "//*[@id='blast_name']")
    public WebElement lastNameTextBox2;

    @FindBy(xpath = "//*[@id='bcompany_name']")
    public WebElement companyTextBox;

    @FindBy(xpath = "//*[@id='bphone']")
    public WebElement phoneTextBox;


    @FindBy(xpath = "//*[@id='baddr_1']")
    public WebElement adress1TextBox;

    @FindBy(xpath = "//*[@id='bcity']")
    public WebElement cityTownTextBox;

    @FindBy(xpath = "//*[@id='bstate']")
    public WebElement stateCountyTextBox;

    @FindBy(xpath = "//*[@id='bzip']")
    public WebElement postcodeZipTextBox;

    @FindBy(xpath = "//*[@id='same_as_billing']")
    public WebElement sameAsBillingButton;

    @FindBy(xpath = "//*[@id='sfirst_name']")
    public WebElement farkliFirstName;

    @FindBy(xpath = "//*[@id='slast_name']")
    public WebElement farkliLasntName;

    @FindBy(xpath = "//*[@id='scompany_name']")
    public WebElement farkliCompanyName;

    @FindBy(xpath = "//*[@id='saddr_1']")
    public WebElement farkliAdress;

    @FindBy(xpath = "//*[@id='scity']")
    public WebElement farkliCityTown;

    @FindBy(xpath = "//*[@id='sstate']")
    public WebElement farkliStateCounty;

    @FindBy(xpath = "//*[@id='szip']")
    public WebElement farkliPostacode;

    @FindBy(xpath = "//*[contains(text(),'Customer Successfully Saved.')]")
    public WebElement kisiEklendiDogrulama;


}



