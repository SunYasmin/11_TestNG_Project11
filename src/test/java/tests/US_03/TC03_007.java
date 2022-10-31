package tests.US_03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03_007 extends TestBaseRapor {

    /*
    -https://www.pearlymarket.com/ adresine git
    -sign in butonuna bas
    -test data user email: trqateam72022@gmail.com ,
    -test data password : 123456team7 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test","Geçerli kullanıcı adı ve password ile giriş yapıldı");
        //-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        extentTest.info("Pearly market pearlyMarketUrl sitesine gidildi");
        //-login butonuna bas
        HomePage homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("sign in butonuna basıldı");
        //-vendorEmail= trqateam72022@gmail.com
        //password= 123456team7
        //-login butonuna tiklayin
        homePage.userEmail.sendKeys(ConfigReader.getProperty("vendorEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"))
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Doğru kullanıcı email ve password girildi");
        extentTest.info("Ikinci sign in butonuna basıldı");
        //-Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = homePage.signOut.getText();
        String expectedUserName = "Sign Out";
        Assert.assertEquals(expectedUserName,actualUserName);
        extentTest.pass("Sayfaya basarili sekilde girildi");
    }
}


