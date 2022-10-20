package tests.US_02;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ReusableMethods;

public class TC02_001 {
    /*
    Vendor Pearly Market anasayfasına gider
    Vendor, Sign In butonuna tıklar
    Vendor, Username or email address kutusuna tıklar
    Vendor, Username or email address kutusuna geçerli email girer
    Vendor, Password kutusuna tıklar
    Vendor, Password kutusuna geçerli şifre girer.
    Vendor, Sign In butonuna tıklar
    Vendor, açılan sayfada My Account linkinin görülebildiğini test eder.
     */
    HomePage home;
    @Test
    public void testSignIn() {
        ReusableMethods.signIn();
        home = new HomePage();
        ReusableMethods.scrollIntoView(home.myAccount);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(home.myAccount.isDisplayed());
    }

}
