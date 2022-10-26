package tests.US_12;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
public class TC12_001 {
MyAccountPage myAccountPage;
    @Test
    public void test_orders() {
        myAccountPage=new MyAccountPage();
        //1. vendor url'ye gider
        //2. vendor signin butonuna tıklar
        //3. vendor Username or email address kutucuğuna geçerli bir username girer
        //4. vendor Password kutucuğuna geçerli bir password girer
        //5. vendor sign in butonuna tıklar
        //6. vendor My Account'u görür ve tıklar
        ReusableMethods.myAccount();
        //7. Açılan My Account sayfasında orders'ı tıklar
        myAccountPage.orders.click();
        ReusableMethods.waitFor(3);
        //8. Orders listesinde siparişlerin sıralandığını test eder
        List<WebElement> orderBilgileri = myAccountPage.orderAllCell;
        int sayac=1;
        for (int i = 0; i < orderBilgileri.size() ; i++) {
            Assert.assertTrue(orderBilgileri.get(i).isDisplayed());
            sayac++;        }
        String metin="";
        List<WebElement> orderNumberTexts=myAccountPage.orderNumberText;
        for (WebElement each: orderNumberTexts) {
            System.out.println(each.getText());
            metin+=each.getText();        }
        Assert.assertTrue(metin.contains("#18270"));
        //9. Sayfayı kapatır
        Driver.closeDriver();
    }
}
