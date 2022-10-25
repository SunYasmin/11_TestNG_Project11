package tests.US_01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC01_017 {
    /*
    1) Vendor, url'ye gider
    2) Vendor, register butonuna tıklar
    3) Vendor, açılan ekranda become a vendor linkine tıklar
    4) Vendor, email kutusuna tıklar.
    5) Vendor, yeni sekmede geçici email sitesi url'sine gider
    6) Vendor, geçici email sitesinden yeni bir e-mail alır.
    7) Vendor, email kutusuna, geçici email sitesinden aldığı email adresini girer girer
    8) Vendor, Verification Code kutusuna tıklar.
    9) Vendor "Verification code sent to your email:" uyarısının çıktığını görür.
    10) Vendor, geçici email sitesine gider, sayfayı yeniler ve gönderilen Verification Code'u alır.
    11) Vendor, Verification Code kutusuna tıklar ve verification code’u girer
    12) Vendor, password kutusuna tıklar.
    13) Vendor, geçerli password girer.
    14) Vendor, Confirm Password kutusuna tıklar
    15) Vendor geçerli password girer
    16) Vendor register butonunu tıklar
    17) Vendor, register yapılabildiğini görür
    18) Vendor, diğer sekmede geçici email adresine gider ve sayfayı yeniler
    19) Vendor, geçici email sitesine "[Pearly Market] Successfully Registered" başlıklı emailin geldiğini test eder.
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
        Driver.getDriver().switchTo().window(hashCodeFirstTab);
        registrationPage.verificationCodeBox.sendKeys(verificationCode);
        registrationPage.passwordBox.sendKeys(ConfigReader.getProperty("strongPassword"));
        registrationPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("strongPassword"));
        ReusableMethods.scrollIntoView(registrationPage.registerButton);
        ReusableMethods.waitFor(2);
        registrationPage.registerButton.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().window(hashCodeSecondTab);
        registrationPage.tempEmailRefreshButton.click();
        ReusableMethods.waitFor(5);
        registrationPage.tempEmailRefreshButton.click();
        ReusableMethods.waitFor(5);
        String actualPearlyMarketMessage = "";
        List<WebElement> emailTitles = registrationPage.emailTitleList;
        for (WebElement w:emailTitles
             ) {
            actualPearlyMarketMessage+=w.getText();
        }
        System.out.println(actualPearlyMarketMessage);
        String expectedPearlyMarketMessage = "[Pearly Market] Successfully Registered";
        Assert.assertTrue(actualPearlyMarketMessage.contains(expectedPearlyMarketMessage));

    }
}
