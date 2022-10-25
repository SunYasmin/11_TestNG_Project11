package tests.US_16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC_01 {
    // Kullanici url'ye adresine gider
    // Kullanici signin butonuna tiklar
    // Kullanici gecerli bir username girer
    // Kullanici gecerli bir password girer
    // Kullanici signin butonuna basar
    // Kullanici My Account'a tiklar
    CustomerPage customerPage = new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void kayitliKisileriGorme() {

        ReusableMethods.myAccount();

        // Kullanici Store Manager'a tiklar
        // Kullanici Customers'a tiklar
        // Kullanici kayitli kisilerin isimini gorur
        // Kullanici kayitli kisilerin kullanici adini gorur
        // Kullanici kayitli kisilerin e mailini gorur
        // Kullanici kayitli kisilerin adresini gorur
        // Kullanici kayitli kisilerin harcama miktarini gorur
        // Kullanici kayitli kisilerin son siparisini gorur

        customerPage.storeManagerBUtton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        customerPage.customerButton.click();
        List<WebElement> kisiler2 = customerPage.kisiListesi;
        for (WebElement w : kisiler2) {
            Assert.assertTrue(w.isDisplayed());

        }


    }


}



