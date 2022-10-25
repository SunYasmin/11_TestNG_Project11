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
    Vendor password kutusuna tıklar
    Vendor "Verification code sent to your email" uyarısının çıktığını görür
    Vendor, yeni bir sekme açarak geçerli email url'sine gider
    Vendor açılan ekranda "Oturum Açın" linkine tıklar
    Vendor, açılan ekranda "E-posta veya telefon" kutusuna geçerli email adresini girer
    Vendor, açılan ekranda Şifre kutusuna geçerli email şifresini girer
    Vendor, geçerli email inbox'ına gider
    Vendor, inbox'tan Verification Code'u alır.
    Vendor, Verification Code'u Verification Code kutusuna girer.
    Vendor Password kutusuna tıklar
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
        ReusableMethods.becomeAVendor();
        String hashCodeFirstTab = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("uniqueEmailUrl"));
        Driver.getDriver().manage().deleteAllCookies();
        String hashCodeSecondTab = Driver.getDriver().getWindowHandle();
        registrationPage.uniqueEmailSignInButton.click();
        ReusableMethods.waitFor(3);
        registrationPage.uniqueEmailBox.sendKeys(ConfigReader.getProperty("uniqueEmailAddress"), Keys.ENTER);
        ReusableMethods.waitFor(3);
        registrationPage.uniqueEmailPasswordBox.sendKeys(ConfigReader.getProperty("uniqueEmailPassword"), Keys.ENTER);
        ReusableMethods.waitFor(3);
        String verificationCode = registrationPage.firstEmailTitleText.getText().replaceAll("\\D", "");
        Driver.getDriver().switchTo().window(hashCodeFirstTab);
        registrationPage.verificationCodeBox.sendKeys(verificationCode);
        ReusableMethods.waitFor(3);
        registrationPage.registerButton.click();
        String expectedResultText = "This Email already exists. Please login to the site and apply as vendor.";
        String actualResultText = registrationPage.uniqueEmailWarningText.getText();
        Assert.assertEquals(actualResultText, expectedResultText);

    }
}
