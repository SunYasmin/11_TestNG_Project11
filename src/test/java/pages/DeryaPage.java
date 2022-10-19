package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeryaPage {
    public DeryaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
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






}
