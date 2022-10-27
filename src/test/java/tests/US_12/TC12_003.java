package tests.US_12;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
public class TC12_003 {
    MyAccountPage myAccountPage;
    @Test
    public void test_addresses() {
        myAccountPage=new MyAccountPage();
        //1. vendor url'ye gider
        //2. vendor signin butonuna tıklar
        //3. vendor Username or email address kutucuğuna geçerli bir username girer
        //4. vendor Password kutucuğuna geçerli bir password girer
        //5. vendor sign in butonuna tıklar
        //6. vendor My Account'u görür ve tıklar
        ReusableMethods.myAccount();
        //7. Açılan My Account sayfasında Addresses'ı tıklar
        myAccountPage.addresses.click();
        ReusableMethods.waitFor(2);
        //8. Fatura ve gönderim adreslerinin listelendiğini test eder
        List<WebElement> adresBilgileri= myAccountPage.addressAllCell;
        int sayac=1;
        for (int i = 0; i < adresBilgileri.size() ; i++) {
            Assert.assertTrue(adresBilgileri.get(i).isDisplayed());
            sayac++;        }
        String metin="";
        List<WebElement> addressTexts=myAccountPage.addressAllCell;
        for (WebElement each: addressTexts) {
            System.out.println(each.getText());
            metin+=each.getText();        }
        Assert.assertTrue(metin.contains("Turkey"));
        //9. Sayfayı kapatır
        Driver.closeDriver();
    }

}
