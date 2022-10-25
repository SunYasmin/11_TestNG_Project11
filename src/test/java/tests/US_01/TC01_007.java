package tests.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class TC01_007 {
    /*
    Vendor, url'ye gider
    Vendor, register butonuna tıklar
    Vendor, açılan ekranda become a vendor linkine tıklar
    Vendor email kutusuna tıklar.
    Vendor, @ işaretinden sonra nokta içermeyen bir geçersiz email girer
    Vendor password kutusuna tıklar
    Vendor "Please provide a valid email address." uyarısının çıktığını test eder.

     */
    RegistrationPage registrationPage;

    @Test
    public void testWrongEmail02() {
        ReusableMethods.becomeAVendor();
        registrationPage = new RegistrationPage();
        registrationPage.emailBox.sendKeys(ConfigReader.getProperty("wrongEmail02"));
        registrationPage.passwordBox.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(registrationPage.wrongEmailText.isDisplayed());
    }
}
