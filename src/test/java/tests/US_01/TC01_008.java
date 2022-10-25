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
    Vendor, url'ye gider
    Vendor, register butonuna tıklar
    Vendor, açılan ekranda become a vendor linkine tıklar
    Vendor email kutusuna daha önceden kullanılmış, geçerli bir email girer.
    Vendor, Verification Code kutusuna, verification code'u girer
    Vendor password kutusuna tıklar
    Vendor password'ü girer
    Vendor, Confirm Password kutusuna tıklar
    Vendor, geçerli password'ü tekrar girer
    Vendor, Register butonuna tıklar.
    Vendor, "This Email already exists. Please login to the site and apply as vendor." uyarısının çıktığını test eder.

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
