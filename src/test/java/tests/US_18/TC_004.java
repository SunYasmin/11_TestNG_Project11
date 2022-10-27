package tests.US_18;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShippingPage;
import utilities.ReusableMethods;

public class TC_004 {
    ShippingPage storeManager=new ShippingPage();

    @Test
    public void test04_refundRequest() {

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

        System.out.println("=================================================================================");

        //Type  basliginin altindaki tum degerleri yazdir.
        String typeValue="";
        for (WebElement w:storeManager.typeListesi) {
            System.out.println("Type Value: " + w.getText());
            typeValue+=w.getText() + ", ";
        }
        Assert.assertTrue(typeValue.contains("Partial Refund"));

        System.out.println("=====================================================================================");

        //Reason  basliginin altindaki tum degerleri yazdir.
        String reasonValue="";
        for (WebElement w:storeManager.reasonListesi) {
            System.out.println("Reason Value: " +w.getText());
            reasonValue+=w.getText() + ", ";

        }
        Assert.assertTrue(reasonValue.contains("Ürünün ambalajı yırtıktı"));

    }
}
