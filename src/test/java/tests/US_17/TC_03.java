package tests.US_17;

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
    public void yeniKisiEkleme3() {
        ReusableMethods.myAccount();
        // Kullanici Store Manager'a tiklar
        // Kullanici Customers'a tiklar
        // Add new butonunu tiklar
        // Username textbox'a username girer
        // Email textbox'a email girer
        // First Name textbox'a firstname girer
        // Last Name textbox'a lastname girer
        // First Name textbox'a firstname girer
        // Last Name textbox'a lastname girer
        // Company Name textbox'a Company Name girer
        // Phone textbox'a phone number girer
        // Adress 1 textbox'a Adress girer
        // Adress 2 textbox'a (istege bagli) Adress girer
        // Ulke secer
        // City/Town textbox'a City/Town girer
        // State/County textbox'a State/County girer
        // Postcode/Zip textbox'a Postcode/Zip girer
        // Kullanici submit'e tiklar
        // Customer Successfully Saved yazısının gorunur oldugunu dogrular
        customerPage.storeManagerBUtton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        customerPage.customerButton.click();
        customerPage.addNewButton.click();
        customerPage.usernameTextBox.sendKeys("ali123");
        customerPage.emailTextBox.sendKeys("ahmet4454@gmail.com");
        customerPage.firstNameBox.sendKeys("Ali");
        customerPage.lastNameBox.sendKeys("Balcı");
        customerPage.firstNameTextBox2.sendKeys("Ali");
        customerPage.lastNameTextBox2.sendKeys("Balci");
        customerPage.companyTextBox.sendKeys("Insi");
        customerPage.phoneTextBox.sendKeys("545545445454");
        customerPage.adress1TextBox.sendKeys("güney mahallesi yeni cadde BATIKENT/ANKARA");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Turkey", Keys.ENTER).perform();
        customerPage.cityTownTextBox.sendKeys("Ankara/Batikent");
        customerPage.stateCountyTextBox.sendKeys("Ankara");
        customerPage.postcodeZipTextBox.sendKeys("064568");
        ReusableMethods.scrollIntoView(customerPage.sameAsBillingButton);
        ReusableMethods.waitFor(3);
        if (customerPage.sameAsBillingButton.isSelected()) {
            customerPage.sameAsBillingButton.click();
        }
        ReusableMethods.waitFor(3);
        customerPage.farkliFirstName.sendKeys("Ali");
        customerPage.farkliLasntName.sendKeys("Can");
        customerPage.farkliCompanyName.sendKeys("Turk Telekom");
        customerPage.farkliAdress.sendKeys("dogu mahallesi eski cadde ETIMESGUT/SİVAS");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Turkey", Keys.ENTER).perform();
        customerPage.farkliCityTown.sendKeys("SIVAS/ETIMESGUT");
        customerPage.farkliStateCounty.sendKeys("Sivas");
        customerPage.farkliPostacode.sendKeys("554161");
        ReusableMethods.scrollIntoView(customerPage.submitButton);
        ReusableMethods.waitFor(3);
        customerPage.submitButton.click();
        customerPage.kisiEklendiDogrulama.isDisplayed();
    }
}


