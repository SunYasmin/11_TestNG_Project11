package tests.US_16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_03 {
    // Kullanici url'ye adresine gider
    // Kullanici signin butonuna tiklar
    // Kullanici gecerli bir username girer
    // Kullanici gecerli bir password girer
    // Kullanici signin butonuna basar
    // Kullanici My Account'a tiklar

    CustomerPage customerPage = new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void yeniKisiEkleme() {
        ReusableMethods.myAccount();
        // Kullanici Store Manager'a tiklar
        // Kullanici Customers'a tiklar
        // Add new butonunu tiklar
        // Username textbox'a username girer
        // Email textbox'a email girer
        // First Name textbox'a firstname girer
        // Last Name textbox'a lastname girer
        // Submit butonuna tiklar
        // Yeni  kisi eklendigini dogrular

        customerPage.storeManagerBUtton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        customerPage.customerButton.click();
        customerPage.addNewButton.click();
        customerPage.usernameTextBox.sendKeys("ahmet123");
        customerPage.emailTextBox.sendKeys("ahmet454@gmail.com");
        customerPage.firstNameBox.sendKeys("Ahmet");
        customerPage.lastNameBox.sendKeys("Balcı");
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(customerPage.submitButton);
        ReusableMethods.waitFor(3);
        customerPage.submitButton.click();
        customerPage.kisiEklendiDogrulama.isDisplayed();

    }
}
