package tests.US_18;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShippingPage;
import utilities.ReusableMethods;

public class TC_001 {
    ShippingPage storeManager = new ShippingPage();

    @Test()
    public void test1_refundRequest() {

        //Tek bir adimda tum islemleri yaptik..
        // (Sayfaya gider,
        // Sign in butonunan tiklar,
        // userEmail ve password girer,
        // Sayfaya giris yapar,
        // My Account butonuna tiklar.
        ReusableMethods.myAccount();
        //Store Manager butonuna tiklar.
        storeManager.storeMan.click();
        ReusableMethods.waitFor(2);
        //Refund butonununa gelene kadar sayfayi indirir
        ReusableMethods.scrollIntoView(storeManager.refundButtonu);
        ReusableMethods.waitFor(2);
        //Refund butonuna tiklar
        storeManager.refundButtonu.click();
        //Acilan sayfanin Refund Reguest oldugunu dogrular.
        ReusableMethods.scrollIntoView(storeManager.refundRequest);
        System.out.println(storeManager.refundRequest.isDisplayed());
        System.out.println("=======================================================================================");

        //Refund Request sayfasindaki Tablonun başlıklarıni konsolda yazdır.
        System.out.println("Basliklar : " + storeManager.iadeTablosu.getText());  //Basliklar :Request ID Order ID Store Amount Type Reason Date
        System.out.println("=======================================================================================");

        //Request ID  basliginin altindaki tum degerleri yazdir.
        String requestIDValue = "";
        for (WebElement w : storeManager.requestIDListesi) {
            requestIDValue += w.getText() + ", ";
            System.out.println("Request ID Value: " + w.getText());
        }
        Assert.assertTrue(requestIDValue.contains("# 1")); //Passed
        System.out.println("=======================================================================================");

    }
}
