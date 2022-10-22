package tests.US_02;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import utilities.ReusableMethods;

public class TC02_002 {
    /*
    Vendor Pearly Market anasayfasına gider
    Vendor, Sign In butonuna tıklar
    Vendor, Username or email address kutusuna tıklar
    Vendor, Username or email address kutusuna geçerli email girer
    Vendor, Password kutusuna tıklar
    Vendor, Password kutusuna geçerli şifre girer.
    Vendor, Sign In butonuna tıklar
    Vendor, açılan sayfada My Account linkine tıklar.
    Vendor, My Account sayfasında ORDERS, DOWNLOADS, ADDRESSES, ACCOUNT DETAILS, WHISLIST ve LOGOUT linklerinin varlığını test eder.

     */
    MyAccountPage myAccount;
    @Test
    public void testMyAccountPageLinks() {
        ReusableMethods.myAccount();
        myAccount = new MyAccountPage();
        Assert.assertTrue(myAccount.orders.isDisplayed());
        Assert.assertTrue(myAccount.downloads.isDisplayed());
        Assert.assertTrue(myAccount.addresses.isDisplayed());
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(myAccount.accountDetails);
        Assert.assertTrue(myAccount.accountDetails.isDisplayed());
        Assert.assertTrue(myAccount.wishlist.isDisplayed());
        Assert.assertTrue(myAccount.logOut.isDisplayed());


    }
}
