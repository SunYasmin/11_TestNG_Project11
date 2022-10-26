package tests.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01_002 {
    /*
    Vendor, url'ye gider
    Vendor, register butonuna tıklar
    Vendor, açılan ekranda become a vendor linkine tıklar
    Vendor, registration sayfasında email kutusunun kullanılabildiğini test eder.
    Vendor, registration sayfasında password kutusunun kullanılabildiğini test eder.
    Vendor, registration sayfasında confirm password kutusunun kullanılabildiğini test eder.
     */

    RegistrationPage registration;
    @Test
    public void testRegistrationBoxes() {
        ReusableMethods.becomeAVendor();
        registration = new RegistrationPage();
        Assert.assertTrue(registration.emailBox.isEnabled());
        Assert.assertTrue(registration.passwordBox.isEnabled());
        Assert.assertTrue(registration.confirmPasswordBox.isEnabled());
        Driver.closeDriver();
    }
}
