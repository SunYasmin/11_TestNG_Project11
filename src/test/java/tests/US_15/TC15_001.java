package tests.US_15;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.MyAccountPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC15_001 {


    /*
    ---------------------LIMITLEMELER-------------
    Usage limit per coupon / kupon basina kullanım limiti eklenebilmeli
    Limit usage to X items/ Belli urunlere kupon kullanım limiti uygula
    Usage limit per user / belli kimselere kullanım limiti koy mesela çok
                            kullanan userlara
    */

    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    CouponPage couponPage;
    Actions actions;

    @Test
    public void testLimits() {

        myAccountPage = new MyAccountPage();
        storeManagerPage = new StoreManagerPage();
        couponPage = new CouponPage();
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

        //KUPON KODU GIRILIR
        couponPage.code.click();
        couponPage.code.sendKeys("654");
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(storeManagerPage.products);
        ReusableMethods.waitFor(2);
        // KUPON TANIMLAMASI GIRILIR
        couponPage.descrip.click();
        ReusableMethods.waitFor(2);

        ReusableMethods.scrollIntoView(couponPage.coupRestriction);
        ReusableMethods.waitFor(2);
        //LIMIT BUTONU TIKLANIR
        couponPage.coupLimit.click();
        ReusableMethods.waitFor(2);
        //KULLANICI LIMITI SEKMESI TIKLANIR
        couponPage.usageLimit.click();
        ReusableMethods.waitFor(2);
        //KUPON KULLANICI LIMITI/URUN BASINA SINIRLAMA/KAC KEZ KULLANILACAGI GIRILIR
        couponPage.usageLimit.sendKeys("1");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys("1")
                .perform();
        couponPage.submitButon.click();
    }
}

