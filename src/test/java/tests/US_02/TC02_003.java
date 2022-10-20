package tests.US_02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class TC02_003 {
    /*
    - Vendor Pearly Market anasayfasına gider
    - Vendor, Sign In butonuna tıklar
    - Vendor, Username or email address kutusuna tıklar
    - Vendor, Username or email address kutusuna geçerli email girer
    - Vendor, Password kutusuna tıklar
    - Vendor, Password kutusuna geçerli şifre girer.
    - Vendor, Sign In butonuna tıklar
    - Vendor, açılan sayfada My Account linkine tıklar.
    - Vendor, My Account sayfasında Dashboard linki altında,
    STORE MANAGER, ORDERS, DOWNLOADS, ADDRESSES, ACCOUNT DETAILS,
    APPOINTMENTS ve WHISLIST linklerinin varlığını test eder.
     */

    MyAccountPage myAccount;
    Actions actions;
    @Test
    public void testMyAccountDashboardLinks01() throws IOException {
        ReusableMethods.myAccount();
        myAccount = new MyAccountPage();
        Assert.assertTrue(myAccount.storeMan.isDisplayed());
        Assert.assertTrue(myAccount.ordersUnderDashboard.isDisplayed());
        Assert.assertTrue(myAccount.downloadsUnderDashboard.isDisplayed());
        Assert.assertTrue(myAccount.addressesUnderDashboard.isDisplayed());
        Assert.assertTrue(myAccount.accountDetailsUnderDashboard.isDisplayed());
        Assert.assertTrue(myAccount.wishlistUnderDashboard.isDisplayed());
        List<WebElement> myAccountLinksList = myAccount.linkListOfMyAccount;
        String myAccountLinksStr = "";
        for (WebElement w:myAccountLinksList
             ) {
            myAccountLinksStr+=w+", ";
        }
        myAccountLinksStr = myAccountLinksStr.toLowerCase();
        System.out.println(myAccountLinksStr);
        String expectedStr = "appointments";
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("NoAppointments");
        Assert.assertTrue(myAccountLinksStr.contains(expectedStr), "Appointments linki bulunamadı");
    }
}
