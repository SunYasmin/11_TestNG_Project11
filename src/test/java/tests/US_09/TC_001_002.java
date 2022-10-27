package tests.US_09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ShippingPage;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_001_002 {
    HomePage home;
    ShippingPage storeManager=new ShippingPage();
    Actions actions =new Actions(Driver.getDriver());
    Select select;


    @Test(priority = 1)
    public void tC001_shippingOpsiyonu() {

        //Tek bir adimda tum islemleri yaptik..
        // (Sayfaya gider,
        // Sign in butonunan tiklar,
        // userEmail ve password girer,
        // Sayfaya giris yapar,
        // My Account butonuna tiklar.
        ReusableMethods.myAccount();

        //Store Manager butonuna tiklar
        storeManager.storeMan.click();

        //Products butonuna tiklar
        storeManager.products.click();
        ReusableMethods.waitFor(2);

        //Urunler sayfasina  gider
        ReusableMethods.scrollIntoView(storeManager.baslikName);
        ReusableMethods.waitFor(2);

        //All Product Type--> simple product secenegini tiklar
        WebElement productType = Driver.getDriver().findElement(By.xpath("//*[@id='dropdown_product_type']"));
        Select select = new Select(productType);
        select.selectByIndex(1); //simple product secenegini secer index=1
        productType.click();

        //Tabloda 1.satir 3.sutundaki bulunan urunu secer
        storeManager.urunSecimi.click();
        ReusableMethods.waitFor(2);
    }

    @Test(priority = 2)
    public void tC002_shippingOpsiyonu() {

        //Product bolumunde Shipping Opsiyonunun bulundugu bolume iner
        //Shipping butonuna tiklar
        //Weight (kg) textbok'ina data bilgisini girer
        //Dimensions (cm)  textbox'ina sirasiyla data bilgilerini girer
        //Processing Time'da teslimat suresini secer
        //Submit butonuna tiklar
        //Product Successfully Published. yazisinin gorunurlugunu test eder
        ReusableMethods.shipping();
    }

    @Test(priority = 3)
    public void CloseDriver() {
        Driver.closeDriver();
    }
}





