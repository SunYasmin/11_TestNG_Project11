package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//*[@class='w-icon-cart'])[1]")
    public WebElement cart;

    @FindBy(xpath = "//*[text()='View cart']")
    public WebElement viewCart;

    @FindBy(xpath = "//a[@href='https://pearlymarket.com/checkout-2/']")
    public WebElement checkOut;

    @FindBy(xpath = "//tr[@class='woocommerce-cart-form__cart-item cart_item']//td")
    public List<WebElement> cartPrdouctCells;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus'][1]")
    public WebElement cartQuantityPlus;

    @FindBy(xpath = "//button[@class='quantity-minus w-icon-minus'][1]")
    public WebElement cartQuantityMinus;

    @FindBy(xpath = "//button[@name='update_cart']")    //  (//button[@type='submit'])[3]
    public WebElement updateCartButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement cartUpdated;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement cartQuantitySayiGirme;

    @FindBy(xpath = "(//*[@class='quantity-plus w-icon-plus'])[2]")
    public WebElement cartQuantityPlusHali;

    @FindBy(xpath = "(//*[@class='quantity-minus w-icon-minus'])[2]")
    public WebElement cartQuantityMinusHali;


    @FindBy(xpath = "//*[@name='apply_coupon']")
    public WebElement applyCoupon;

    @FindBy(xpath = "//*[.='Coupon Discount']")
    public WebElement couponDiscountYaziWe;

    @FindBy(xpath = "//*[.='Coupon Discount']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//*[.='Coupon Discount']")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "(//*[.='Shipping'])[2]")
    public WebElement shippingBilgileri;

    @FindBy(xpath = "//*[.='Cart Totals']")
    public WebElement cartTotals;

    @FindBy(xpath = "(//*[.='Subtotal'])[2]")
    public WebElement subTotal;

    @FindBy(xpath = "//*[@class='btn btn-rounded btn-outline btn-default btn-border-thin mb-4 ml-2 mr-2 clear-cart-button']")
    public WebElement clearCart;


    @FindBy(xpath = "//*[@class='cart-empty woocommerce-info']")
    public WebElement cartEmptyYaziWe;

    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement siparisAlindiTesk;

    @FindBy(xpath = "//h3[.='Billing details']")
    public WebElement billingDetailsYaziWe;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement bilDetFirstName;

    @FindBy(xpath = "//*[@id='billing_last_name']")
    public WebElement bilDetLastName;

    @FindBy(xpath = "//*[@id='billing_company']")
    public WebElement bilDetComName;

    @FindBy(xpath = "//select[@id='billing_country']")
    public WebElement bilDetCountry;

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement bilDetStreetAdres1;

    @FindBy(xpath = "//*[@id='billing_address_2']")
    public WebElement bilDetStreetAdres2;

    @FindBy(xpath = "//*[@id='billing_city']")
    public WebElement bilDetCity;

    @FindBy(xpath = "//*[@id='select2-billing_state-container']")
    public WebElement bilDetProvince;

    @FindBy(xpath = "//*[@id='billing_postcode']")
    public WebElement bilDetZipCode;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//*[@id='payment_method_cod']")
    public WebElement kapidaOdeme;








}
