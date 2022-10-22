package tests.US_02;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import utilities.ReusableMethods;

public class TC02_004 {
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
    SUPPORT TICKETS, FOLLOWINGS ve LOGOUT linklerinin varlığını test eder.
     */
    MyAccountPage myAccount;
    @Test
    public void testMyAccountDashboardLinks02() {
        ReusableMethods.myAccount();
        myAccount = new MyAccountPage();
        Assert.assertTrue(myAccount.supportTickets.isDisplayed());
        Assert.assertTrue(myAccount.followings.isDisplayed());
        Assert.assertTrue(myAccount.logoutUnderDashboard.isDisplayed());
    }
}
