package tests.US_01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01_005 {
    /*
    Vendor, url'ye gider
    Vendor, register butonuna tıklar
    Vendor, açılan ekranda become a vendor linkine tıklar
    Vendor, yeni bir sekme açarak geçici email sitesi url'sine gider
    Vendor, geçici email sitesinden yeni  bir email adresi alır.
    Vendor, Email kutusuna tıklar.
    Vendor, Email kutusuna, geçici email sitesinden aldığı email adresini girer.
    Vendor, Verification Code kutusuna tıklar.
    Vendor "Verification code sent to your email:" uyarısının çıktığını görür.
    Vendor, diğer sekmede geçici email sitesine gidip sayfadaki refresh butonuna tıklar.
    Vendor, geçici email sitesine gelen Verification Code'u alır.
    Vendor, aldığı kodu, kayıt sayfasındaki Verification Code kutusuna girer
    Vendor, Password kutusuna tıklar.
    Vendor, güçlü password girer.
    Vendor, Confirm Password kutusuna tıklar
    Vendor güçlü password girer
    Vendor register butonunu tıklar
    Vendor, register yapılabildiğini test eder.
     */
    RegistrationPage registrationPage;
    Actions actions;
    @Test
    public void testValidEmail() {
        ReusableMethods.becomeAVendor();
        ReusableMethods.getVerificationCode();
        registrationPage = new RegistrationPage();
        registrationPage.passwordBox.sendKeys(ConfigReader.getProperty("strongPassword"));
        registrationPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("strongPassword"));
        ReusableMethods.scrollIntoView(registrationPage.registerButton);
        ReusableMethods.waitFor(2);
        registrationPage.registerButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.registrationSuccessfullyCompleted.isDisplayed());
        Driver.quitDriver();
    }
}
