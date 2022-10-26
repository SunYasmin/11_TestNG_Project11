package tests.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01_001 {
    /*
        Vendor, url'ye gider
        Vendor, register butonuna tıklar
        Vendor, açılan ekranda become a vendor linkine tıklar
        Vendor, Vendor Registration ekranının görüldüğünü test eder.
         */
    HomePage home;
    @Test
    public void testVendorRegistration() {
        ReusableMethods.becomeAVendor();
        home = new HomePage();
        Assert.assertTrue(home.vendorRegistration.isDisplayed());
        Driver.closeDriver();
    }
}
