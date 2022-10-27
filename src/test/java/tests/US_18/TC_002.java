package tests.US_18;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShippingPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_002 {
    ShippingPage storeManager=new ShippingPage();

    @Test(priority = 1)
    public void test2_refundRequest() {

        ReusableMethods.myAccount();
        storeManager.storeMan.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(storeManager.refundButtonu);
        ReusableMethods.waitFor(2);
        storeManager.refundButtonu.click();
        ReusableMethods.scrollIntoView(storeManager.refundRequest);
        storeManager.refundRequest.isDisplayed();
        //Refund Request sayfasindaki Tablonun başlıklarıni konsolda yazdır.
        System.out.println("Iade Tablosundaki Basliklar" + storeManager.iadeTablosu.getText());  //Basliklar :Request ID Order ID Store Amount Typ

        //Order ID  basliginin altindaki tum degerleri yazdir.
        String orderIDValue="";
        for (WebElement w: storeManager.orderIDListesi) {
            orderIDValue+=w.getText() + ", ";
            System.out.println("Order ID Value: " + w.getText());
        }
        Assert.assertTrue(orderIDValue.contains("#14094")); //Passed


    }

    @Test(priority = 2)
    public void testKapatma() {
        Driver.quitDriver();
    }

}
