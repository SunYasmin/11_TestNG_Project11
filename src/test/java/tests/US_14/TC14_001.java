package tests.US_14;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.MyAccountPage;
import pages.ReviewsPage;
import pages.StoreManagerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC14_001 {
    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    CouponPage couponPage;
    ReviewsPage reviewsPage;
    Actions actions;

    /*
    Minimum spend / en az alma miktari girilmeli
    Maximum spend / maksimum alma miktarı girilmeli
    Individual use only / kisisel kullanım sadece secenegi olmalı
    Exclude sale items / bazi satis ürünleri disinda tut
    Exclude categories / bazi kategorileri disinda tut
     */

    @Test
    public void testRestriction() throws InterruptedException {

        myAccountPage = new MyAccountPage();
        storeManagerPage = new StoreManagerPage();
        couponPage = new CouponPage();
        reviewsPage = new ReviewsPage();
        actions = new Actions(Driver.getDriver());

        ReusableMethods.myAccount();
        couponPage.storeManager.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(couponPage.snl);
        ReusableMethods.waitFor(2);
        couponPage.coupon.click();
        ReusableMethods.waitFor(6);
        ReusableMethods.scrollIntoView(couponPage.addNewCoupon);
        ReusableMethods.waitFor(2);
        couponPage.addNewCoupon.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(couponPage.coupRestriction);
        ReusableMethods.waitFor(2);
        couponPage.coupRestriction.click();
        ReusableMethods.waitFor(2);
        // KUPON ILE EN AZ URUN ALMA (MINIMUM SPEND) SINIRLANDIRMASI
        couponPage.minSpend.click();
        ReusableMethods.waitFor(2);
        couponPage.minSpend.sendKeys("2");
        ReusableMethods.waitFor(2);
        // KUPON ILE EN FAZLA URUN ALMA (MAXIMUM SPEND) SINIRLANDIRMASI
        couponPage.maxSpend.click();
        ReusableMethods.waitFor(2);
        couponPage.maxSpend.sendKeys("10");
        // SADECE KISISEL KULLANIM SECENEGI SECILIR
        couponPage.indUseOnly.click();
        // KUPON KAPSAMI DISINDA TUTMA SECENEGI
        couponPage.excSaleItems.click();
        // KUPON KULLANIMI ICIN GEREKLI URUNLERIN SECILMESI
        couponPage.filtProducts.click();
        ReusableMethods.scrollIntoView(couponPage.ledgerBooks);
        couponPage.filtProducts.sendKeys("kal");
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB).perform();
        // KUPON KAPSAMI DISINDA TUTULACAK URUNLERIN GIRILMESI
        couponPage.filtExProducts.sendKeys("set");
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB).perform();
        // KUPONUN GECERLI OLACAGI KATAGORININ SECILMESI
        couponPage.proCategories.sendKeys("rin");
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB).perform();
        // KUPON KAPSAMI DISINDA TUTULACAK KATAGORI BELIRLENMESI
        couponPage.exCategories.sendKeys("nec");
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB).perform();








    }
}