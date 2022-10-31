package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class CouponPage {
    public CouponPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Store Manager']")
    public  WebElement storeManager;
    @FindBy(xpath = "(//*[@class='text'])[6]")
    public WebElement coupon;

    @FindBy(xpath = "(//a[@class=\"wcfm_menu_item \"])[1]")
    public WebElement home;

    @FindBy(xpath = "//*[@id='title']")
    public WebElement code;

    @FindBy(xpath = "//*[@id='description']")
    public WebElement descrip;

    @FindBy(xpath = "//*[@id='discount_type']")
    public WebElement disType;

    @FindBy(xpath = "//*[@id='coupon_amount']")
    public WebElement coupAmount;

    @FindBy(xpath = "//*[@id='expiry_date']")
    public WebElement expDate;

    @FindBy(xpath = "//*[@id='free_shipping']")
    public WebElement freeShip;

    @FindBy(xpath = "//*[@id='show_on_store']")
    public WebElement showStore;

    //-------------------------TEST CASE 14----------------
    @FindBy(xpath = "//*[@id='coupons_manage_restriction']")
    public WebElement coupRestriction;

    @FindBy(xpath = "//*[@id='minimum_amount']")
    public WebElement minSpend;

    @FindBy(xpath = "//*[@id='maximum_amount']")
    public WebElement maxSpend;

    @FindBy(xpath = "(//*[@class='text'])[15]")
    public WebElement ledgerBooks;

    @FindBy(xpath = "//*[@id='individual_use']")
    public WebElement indUseOnly;

    @FindBy(xpath = "//*[@id='exclude_sale_items']")
    public WebElement excSaleItems;

    @FindBy(xpath = "(//*[@class='select2-selection select2-selection--multiple'])[1]")
    public WebElement filtProducts;

    @FindBy(xpath = "(//*[@class='select2-selection select2-selection--multiple'])[2]")
    public WebElement filtExProducts;

    @FindBy(xpath = "(//*[@class='select2-selection select2-selection--multiple'])[3]")
    public WebElement proCategories;

    @FindBy(xpath = "(//*[@class='select2-selection select2-selection--multiple'])[4]")
    public WebElement exCategories;

    @FindBy(xpath = "//*[@id='coupons_manage_limit']")
    public WebElement coupLimit;

    @FindBy(xpath = "//*[@id='usage_limit']")
    public WebElement usageLimit;

    @FindBy(xpath = "//*[@id=limit_usage_to_x_items]")
    public WebElement usageLimitXItems;

    @FindBy(xpath = "//*[@id='usage_limit_per_user']")
    public WebElement usageLimitPerUser;

    @FindBy (xpath = "//input[@value='Submit']")
    public WebElement submitButon;

    @FindBy(xpath = "//span[@class='wcfmfa fa-money fa-money-bill-alt']")
    public WebElement snl;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNewCoupon;
}
