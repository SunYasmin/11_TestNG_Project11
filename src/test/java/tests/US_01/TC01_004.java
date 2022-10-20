package tests.US_01;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class TC01_004 {
    /*
    Vendor, url'ye gider
    Vendor, register butonuna tıklar
    Vendor, açılan ekranda become a vendor linkine tıklar
    Vendor, Password kutusuna tıklar.
    Vendor, Password kutusuna geçerli password girer
    Vendor, Confirm Password kutusuna tıklar.
    Vendor, Confirm Password kutusuna, geçerli password girer
    Vendor, Register butonuna tıklar
    Vendor, "Email: This field is required." uyarısının çıktığını test eder.
     */

    RegistrationPage registrationPage;
    Actions actions;
    @Test
    public void testEmailRequired02() {
        ReusableMethods.becomeAVendor();
        registrationPage = new RegistrationPage();
        registrationPage.passwordBox.sendKeys(ConfigReader.getProperty("validRegistrationPassword"));
        registrationPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("validRegistrationPassword"));
        ReusableMethods.scrollIntoView(registrationPage.registerButton);
        ReusableMethods.waitFor(1);
        registrationPage.registerButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(registrationPage.emailRequired.isDisplayed());
    }
}
