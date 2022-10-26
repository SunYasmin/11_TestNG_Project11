package tests.US_01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01_008 {
    /*
    1) Vendor, url'ye gider
    2) Vendor, register butonuna tıklar
    3) Vendor, açılan ekranda become a vendor linkine tıklar
    4) Vendor email kutusuna daha önceden kullanılmış, geçerli bir email girer.
    5) Vendor, Verification Code kutusuna, verification code'u girer
    6) Vendor password kutusuna tıklar
    7) Vendor password'ü girer
    8) Vendor, Confirm Password kutusuna tıklar
    9) Vendor, geçerli password'ü tekrar girer
    10) Vendor, Register butonuna tıklar.
    11) Vendor, "This Email already exists. Please login to the site and apply as vendor." uyarısının çıktığını test eder.

     */
    RegistrationPage registrationPage;
    HomePage homepage;
    Actions actions;

    @Test
    public void testUniqueEmail() {
        registrationPage = new RegistrationPage();
        homepage = new HomePage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.becomeAVendor();
        registrationPage.emailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        registrationPage.verificationCodeBox.sendKeys("111111");
        ReusableMethods.waitFor(5);
        registrationPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        registrationPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.scrollIntoView(registrationPage.registerButton);
        ReusableMethods.waitFor(3);
        registrationPage.registerButton.click();
        Assert.assertTrue(registrationPage.existingEmailWarningText.isDisplayed());
        Driver.closeDriver();

    }
}
