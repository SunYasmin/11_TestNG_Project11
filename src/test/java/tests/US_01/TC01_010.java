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

public class TC01_010 {
    /*
    1) Vendor, url'ye gider
    2) Vendor, register butonuna tıklar
    3) Vendor, açılan ekranda become a vendor linkine tıklar
    4) Vendor, yeni bir sekme açarak geçici email sitesi url'sine gider
    5) Vendor, geçici email sitesinden yeni bir email adresi alır.
    6) Vendor, Email kutusuna tıklar.
    7) Vendor, Email kutusuna, geçici email sitesinden aldığı email adresini girer.
    8) Vendor, Verification Code kutusuna tıklar.
    9) Vendor "Verification code sent to your email:" uyarısının çıktığını görür.
    10) Vendor, diğer sekmede geçici email sitesine gidip sayfadaki refresh butonuna tıklar.
    11) Vendor, geçici email sitesine gelen Verification Code'u alır.
    12) Vendor, aldığı kodu, kayıt sayfasındaki Verification Code kutusuna girer
    13) Vendor, Password kutusuna tıklar.
    14) Vendor, iyi password girer.
    15) Vendor, Confirm Password kutusuna tıklar
    16) Vendor iyi password girer
    17) Vendor register butonunu tıklar
    18) Vendor, register yapılamadığını test eder.
     */
    RegistrationPage registrationPage;
    HomePage homepage;
    Actions actions;
    @Test
    public void testGoodPassword01() {
        ReusableMethods.becomeAVendor();
        String hashCodeFirstTab = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("temporaryMailUrl"));
        String hashCodeSecondTab = Driver.getDriver().getWindowHandle();
        registrationPage = new RegistrationPage();
        registrationPage.tempEmailAccountName.click();
        Driver.getDriver().switchTo().window(hashCodeFirstTab);
        registrationPage.emailBox.click();
        actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("v").perform();
        actions.keyUp(Keys.CONTROL).perform();
        registrationPage.verificationCodeBox.click();
        String verificationCodeSentWarning = "Verification code sent to your email";
        Assert.assertTrue(registrationPage.verificationCodeSentMessage.getText().contains(verificationCodeSentWarning));
        Driver.getDriver().switchTo().window(hashCodeSecondTab);
        registrationPage.tempEmailRefreshButton.click();
        ReusableMethods.waitFor(5);
        String verificationCode = registrationPage.tempEmailInboxFirstEmail.getText().replaceAll("\\D", "");
        Driver.getDriver().switchTo().window(hashCodeFirstTab);
        registrationPage.verificationCodeBox.sendKeys(verificationCode);
        registrationPage.passwordBox.sendKeys(ConfigReader.getProperty("goodPassword01"));
        registrationPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("goodPassword01"));
        ReusableMethods.scrollIntoView(registrationPage.registerButton);
        ReusableMethods.waitFor(2);
        registrationPage.registerButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertFalse(registrationPage.registrationSuccessfullyCompleted.isDisplayed(), "Registration sayfasında kalması gerekirken kayıt başarılı oldu");
    }
}
