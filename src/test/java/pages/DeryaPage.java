package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

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

    @FindBy(xpath = "//*[@class='wcfm-tabWrap']")
    public WebElement shippingBolumu;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;

    @FindBy(xpath = "//*[@id='weight']")
    public WebElement weight;

    //Dropdown menu
    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement processingTime;



    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit_button']")
    public WebElement submit;

    //==================Tablodaki name yazisini gorene kadar in==================//
    @FindBy(xpath = "//*[@class='wcfm-container wcfm-top-element-container']")
    public WebElement baslikName;


    @FindBy(xpath = "//tbody//tr[1]//td[3]//a")
    public WebElement urunSecimi;






    @FindBy(xpath = " //*[contains(text(), 'Product Successfully Published.')]")
    public WebElement productSuccessfullyPublished;


    //==========US_18 Locate ============================  (//*[@class='text'])[5]

    @FindBy(xpath = "(//*[@class='text'])[8]")
    public WebElement refundButtonu;

    @FindBy(xpath = "(//*[text()='Refund Requests'])[3]")
    public WebElement refundRequest; //Refund Request sayfasinin gorunurlugu icin aldigim locate


    @FindBy(xpath = "//thead//tr")
    public WebElement iadeTablosu;


    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement> requestIDListesi;

    @FindBy(xpath = "//tbody//tr//td[3]")
    public List<WebElement> orderIDListesi;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public List<WebElement> amountListesi;

    @FindBy(xpath = "//tbody//tr//td[5]")
    public List<WebElement> typeListesi;

    @FindBy(xpath = "//tbody//tr//td[6]")
    public List<WebElement> reasonListesi;


    //==========================US_019 Locate'leri===============================


    @FindBy(xpath = "(//*[@class='text'])[11]")
    public WebElement followersButton;


    @FindBy(xpath = "//thead//tr")
    public WebElement followerTabloBasliklari;

    @FindBy(xpath = "//tbody")
    public WebElement followersTabloDegerleri;








}
