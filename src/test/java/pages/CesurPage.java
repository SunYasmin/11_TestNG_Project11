package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CesurPage {

    public CesurPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeMan;


    @FindBy(xpath = "//*[@class='wcfmfa fa-cube']")
    public WebElement products;

    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement addNewButton;

    @FindBy(xpath = "//*[text()='Lego']")
    public WebElement legoUrun;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;

    @FindBy(xpath = "//*[@id='weight']")
    public WebElement weight;

    //Dropdown menu
    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement processingTime;



    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit_button']")
    public WebElement submit;

    @FindBy(xpath = "//*[@class='button media-button button-primary button-large media-button-select']")
    public WebElement selectProductButton;


    @FindBy(xpath = "(//*[text()='Short Description'])[1]")
    public WebElement shortDescriptionVisible;

    @FindBy(xpath = "//body[@data-id='excerpt']")
    public WebElement shortDescriptionText;

    @FindBy(xpath = "//body[@data-id='description']")
    public WebElement descriptionText;

    @FindBy(xpath = "(//*[text()='Description'])[1]")
    public WebElement descriptionVisible;

    @FindBy(xpath ="(//div[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;


    @FindBy(xpath = "(//span[@class='fields_collapser attributes_collapser wcfmfa fa-arrow-circle-down'])[2]")
    public WebElement colorOk;

    @FindBy(xpath = "(//span[@class='fields_collapser attributes_collapser wcfmfa fa-arrow-circle-down'])[3]")
    public WebElement sizeOk;
}
