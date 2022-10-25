package tests.US_03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03_001 {

    //1-Url'ye gidilir
    //2-Giriş yap/SignIn butonuna tiklanir
    //3-Gecerli kullanici bilgileri girilir
    //4-Giris yap/SignIn'e tiklanir
    //5-Hesabim sayfasina giris yapildigi test edilir
    //6-Acilan sayfada My Orders/Siparislerim butonuna tiklanir
    //7-Acilan sayfada Browse Products' a tiklanir
    //8-Magaza butonunun gorunur oldugu test edilir

    HomePage homePage;

    @Test
    public void testCase_01() {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        HomePage homePage = new HomePage();
        homePage.signInButton.click();
        homePage.userEmail.sendKeys(ConfigReader.getProperty("vendorEmail1"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password1"))
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(homePage.myAccountYaziWe);
        Assert.assertTrue(homePage.myAccountYaziWe.isDisplayed());

        ReusableMethods.waitFor(3);
        homePage.myOrders.click();

        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.browseProduct.click();

        ReusableMethods.scrollIntoView(homePage.companyYaziWe);
        Assert.assertTrue(homePage.companyYaziWe.isDisplayed());
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.aboutUs.isEnabled());

        Driver.closeDriver();
    }




}
