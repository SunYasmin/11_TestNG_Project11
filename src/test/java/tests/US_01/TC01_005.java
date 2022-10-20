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
    Vendor, geçici email sitesinden yeni bir email adresi alır.
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
        System.out.println(verificationCode);
        Driver.getDriver().switchTo().window(hashCodeFirstTab);
        registrationPage.verificationCodeBox.sendKeys(verificationCode);
        registrationPage.passwordBox.sendKeys(ConfigReader.getProperty("strongPassword"));
        registrationPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("strongPassword"));
        ReusableMethods.scrollIntoView(registrationPage.registerButton);
        ReusableMethods.waitFor(2);
        registrationPage.registerButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(registrationPage.welcomeText.isDisplayed());
    }
}
