package tests.US_21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.ReportsPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC21_001 {
    /*
    -  Vendor Pearly Market anasayfasına gider
    -  Vendor, Sign In butonuna tıklar
    -  Vendor, Username or email address kutusuna tıklar
    -  Vendor, Username or email address kutusuna geçerli email girer
    -  Vendor, Password kutusuna tıklar
    -  Vendor, Password kutusuna geçerli şifre girer.
    -  Vendor, Sign In butonuna tıklar
    -  Vendor, açılan sayfada My Account linkine tıklar.
    -  Vendor, My Account sayfasında Store Manager linkine tıklar
    -  Vendor, açılan sayfada My Store başlığı altında bulunan Reports linkine tıklar
    -  Vendor, Reports sekmesi altında, yıllık, en son ay,
       içinde bulunulan ay, son 7 gün ve belirli bir tarih aralığına ait
       satış raporlarının yer aldığını test eder.
     */

    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    ReportsPage reportsPage;
    Actions actions;

    @Test
    public void testReports() {
        myAccountPage = new MyAccountPage();
        storeManagerPage = new StoreManagerPage();
        actions = new Actions(Driver.getDriver());
        reportsPage = new ReportsPage();
        ReusableMethods.myAccount();
        myAccountPage.storeMan.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(reportsPage.followers);
        ReusableMethods.waitFor(2);
        reportsPage.reports.click();
        ReusableMethods.waitFor(2);

        reportsPage.yearReports.click();
        ReusableMethods.waitFor(5);
        List<WebElement> salesReports = reportsPage.salesNumbersList;
        for (WebElement w: salesReports
             ) {
            Assert.assertTrue(w.isDisplayed());
        }

        reportsPage.lastMonthReports.click();
        ReusableMethods.waitFor(5);
        for (WebElement w: salesReports
        ) {
            Assert.assertTrue(w.isDisplayed());
        }

        reportsPage.thisMonthReports.click();
        ReusableMethods.waitFor(5);
        for (WebElement w: salesReports
        ) {
            Assert.assertTrue(w.isDisplayed());
        }
        reportsPage.lastSevenDaysReports.click();
        ReusableMethods.waitFor(5);
        for (WebElement w: salesReports
        ) {
            Assert.assertTrue(w.isDisplayed());
        }

        reportsPage.customDateReports.click();
        ReusableMethods.waitFor(5);
        ReusableMethods.scrollIntoView(reportsPage.articles);
        ReusableMethods.waitFor(3);
        reportsPage.twelveOfOctober2022.click();
        ReusableMethods.waitFor(1);
        reportsPage.twentySevenOfOctober2022.click();
        ReusableMethods.waitFor(3);
        for (WebElement w: salesReports
        ) {
            Assert.assertTrue(w.isDisplayed());
        }
    }
}
