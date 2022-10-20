package tests.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.ReusableMethods;

public class TC01_003 {
    /*
    Vendor, url'ye gider
    Vendor, register butonuna tıklar
    Vendor, açılan ekranda become a vendor linkine tıklar
    Vendor, email kutusuna tıklar
    Vendor, email kutusuna herhangi bir şey yazmadan password kutusuna tıklar
    Vendor, "Email: This field is required." uyarısının çıktığını test eder.
     */

    RegistrationPage registrationPage;
    @Test
    public void testEmailRequired01() {
        ReusableMethods.becomeAVendor();
        registrationPage = new RegistrationPage();
        registrationPage.emailBox.click();
        registrationPage.passwordBox.click();
        Assert.assertTrue(registrationPage.emailRequired.isDisplayed());
    }
}
