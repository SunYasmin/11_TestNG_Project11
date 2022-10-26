package tests.US_19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DeryaPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_001_002 {
    DeryaPage storeManager=new DeryaPage();
    Actions actions=new Actions(Driver.getDriver());
    SoftAssert softAssert= new SoftAssert();

    @Test(priority=1)
    public void test01_followers() {
        //Tek bir adimda tum islemleri yaptik..
        // (Sayfaya gider,
        // Sign in butonunan tiklar,
        // userEmail ve password girer,
        // Sayfaya giris yapar,
        // My Account butonuna tiklar.
        ReusableMethods.myAccount();
        storeManager.storeMan.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(storeManager.followersButton);
        ReusableMethods.waitFor(2);
        storeManager.followersButton.click();
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(Driver.getDriver().getTitle().contains("Followers List"), "Girdiginiz sayfa kelimeyi icermiyor.");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    //====================Followers bolumunun test case'leri===========================
    @Test(priority = 2)
    public void test02_followersTablo() {

        System.out.println("followersTablosuBasliklari : " + storeManager.followerTabloBasliklari.getText());
        System.out.println("=======================================================================================");
        System.out.println("followersDegerleri : " + storeManager.followersTabloDegerleri.getText());
        System.out.println("=======================================================================================");
        //=====================1.dogrulama==============================================
        String expected="No data in the table";
        String actual=storeManager.followersTabloDegerleri.getText();
        softAssert.assertEquals(expected,actual);

        //==============2.dogrulama=====================================================
        String actualResult=storeManager.followersTabloDegerleri.getText();
        softAssert.assertFalse(actualResult.contains("mail.com"));

        ReusableMethods.waitFor(3);




    }
    @Test(priority = 3)
    public void CloseDriver() {
        Driver.closeDriver();
    }
}


