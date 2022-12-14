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

    @FindBy(xpath = "//a[@class='btn btn-dark btn-rounded btn-icon-left continue-shopping mb-4 mr-auto']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "(//*[@href='https://pearlymarket.com/checkout-2/'])[3]")
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

    @FindBy(xpath = "//*[@id='scroll-top']")
    public WebElement scrollTop;

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


    //Hali
    @FindBy(xpath = "(//a[@href='https://pearlymarket.com/urun/hali/'])[1]")
    public WebElement hali;   //sayfa 3 hali
    //  (//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[46]

    @FindBy(xpath = "//*[.='98 in stock']")
    public WebElement haliStok;

    @FindBy(xpath = "(//*[@href='https://pearlymarket.com/urun/hali/'])[2]")
    public WebElement haliBaslik;   //sayfa 3 hali

    @FindBy(xpath = "(//a[@data-product_id='14880'])[1]")
    public WebElement haliAddToCart;
    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement haliDetayAddToCart;

    @FindBy(xpath = "(//span[@class='cart-count'])[1]")
    public WebElement haliDetayCartSimgesi;

    @FindBy(xpath = "(//*[.='2'])[1]")     //    (//*[.='2'])[1]
    public WebElement haliDetayCarttakiSayi;

    @FindBy(xpath = "//*[@id='quantity_63573c9eb3d88']")
    public WebElement haliDetayAdetKutusu;

    @FindBy(xpath = "//*[@class='quantity-plus w-icon-plus']")
    public WebElement haliDetayPlus;

    //Ikili Yastik
    @FindBy(xpath = "(//*[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[2]")
    public WebElement ikiliYastik;

    @FindBy(xpath = "//*[@data-product_id='15242']")
    public WebElement ikiliYastikAddToCartSimgesi;

    //shop
    @FindBy(xpath = "//*[@class='elementor-widget-wrap elementor-element-populated']")
    public WebElement shopSayfasiToolBox;

    @FindBy(xpath = "(//*[@type='search'])[1]")
    public WebElement searchBox;

    @FindBy(xpath = "(//*[@class='woocommerce-cart-form__cart-item cart_item'])[1]")
    public WebElement cartIlkUrun;

    @FindBy(xpath = "//p[@class='woocommerce-shipping-destination']")
    public WebElement cartAdresBilgileri;

    @FindBy(xpath = "//*[@name='clear_cart']")
    public WebElement clearCartButton;

    @FindBy(xpath = "//*[@class='button wc-backward btn btn-rounded btn-dark']")
    public WebElement reTurnToShop;

    @FindBy(xpath = "//*[@class='button checkout wc-forward']")  //acilir pencere checkout
    public WebElement checkOut2;

}
