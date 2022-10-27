package tests.US_12;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
public class TC12_002 {
    MyAccountPage myAccountPage;
    @Test
    public void test_wishlist() {
        myAccountPage=new MyAccountPage();
        //1. vendor url'ye gider
        //2. vendor signin butonuna tıklar
        //3. vendor Username or email address kutucuğuna geçerli bir username girer
        //4. vendor Password kutucuğuna geçerli bir password girer
        //5. vendor sign in butonuna tıklar
        //6. vendor My Account'u görür ve tıklar
        ReusableMethods.myAccount();
        //7. Açılan My Account sayfasında Wishlist'i tıklar
        ReusableMethods.scrollIntoView(myAccountPage.subscribe);
        ReusableMethods.waitFor(3);
        myAccountPage.wishlistLink.click();
        ReusableMethods.waitFor(3);
        //8. Wishlist listesinde ürünlerin listelendiğini test eder
        List<WebElement> wishesBilgileri = myAccountPage.wishlistAllCell;
        int sayac=1;
        for (int i = 0; i < wishesBilgileri.size() ; i++) {
            Assert.assertTrue(wishesBilgileri.get(i).isDisplayed());
            sayac++;        }
        String metin="";
        List<WebElement> wishNumberTexts=myAccountPage.wishCellText;
        for (WebElement each: wishNumberTexts) {
            System.out.println(each.getText());
            metin+=each.getText();        }
        Assert.assertTrue(metin.contains("Hope Cup"));
        //9. Sayfayı kapatır
        Driver.closeDriver();
    }
}
