package tests.US_13;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.MyAccountPage;
import pages.ReportsPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC13_001
{
    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    CouponPage couponPage;
    Actions actions;

    @Test
    public void testCoupon() {
        /*
        Coupon kodu verilmeli
        Tanimlama yazilmali
        Indirim sekli / discount
        Coupon amount
        Coupon expiry date / urun kuponu son kullanim tarihi girilmeli
        Free shipping uygulanmali
        Show on store
         */
        myAccountPage = new MyAccountPage();
        storeManagerPage = new StoreManagerPage();
        couponPage = new CouponPage();
        actions = new Actions(Driver.getDriver());

        //----------------------KUPON EKLEME--------------
        ReusableMethods.myAccount();
        couponPage.storeManager.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(couponPage.snl);
        ReusableMethods.waitFor(2);
        //KUPON SEKMESINE TIKLANIR
        couponPage.coupon.click();
        ReusableMethods.scrollIntoView(couponPage.addNewCoupon);
        ReusableMethods.waitFor(2);
        // YENI KUPON EKLEME SEKMESINE TIKLANIR
        couponPage.addNewCoupon.click();
        ReusableMethods.waitFor(2);
        //KUPON KODU GIRILIR
        couponPage.code.click();
        couponPage.code.sendKeys("654");
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(storeManagerPage.products);
        ReusableMethods.waitFor(2);
        // KUPON TANIMLAMASI GIRILIR
        couponPage.descrip.click();
        ReusableMethods.waitFor(2);
        couponPage.descrip.sendKeys("Super Kupon");
        ReusableMethods.waitFor(2);
        // KUPON TIPI SECLIR
        Select select = new Select(couponPage.disType);
        select.selectByVisibleText("Fixed Product Discount");
        ReusableMethods.waitFor(2);
        //KUPON MIKTARI GIRILIR
        couponPage.coupAmount.click();
        ReusableMethods.waitFor(2);
        couponPage.coupAmount.clear();
        couponPage.coupAmount.sendKeys("700");
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(couponPage.addNewCoupon);
        ReusableMethods.waitFor(2);
        // KUPON GECERLILIK TARIHI GIRILIR
        couponPage.expDate.click();
        ReusableMethods.waitFor(2);
        couponPage.expDate.sendKeys("2022-10-27");
        ReusableMethods.waitFor(2);
        //UCRETSIZ KARGO SECENEGI SECILIR
        couponPage.freeShip.click();
        ReusableMethods.waitFor(2);
        // STORE DE GÖSTERME SECENEGI SECILIR
        couponPage.showStore.click();


    }
}