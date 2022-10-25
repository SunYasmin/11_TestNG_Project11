package tests.US_16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TC_02 {
    CustomerPage customerPage = new CustomerPage();
    Actions actions = new Actions(Driver.getDriver());

    // Kullanici url'ye adresine gider
    // Kullanici signin butonuna tiklar
    // Kullanici gecerli bir username girer
    // Kullanici gecerli bir password girer
    // Kullanici signin butonuna basar
    // Kullanici My Account'a tiklar
    // Kullanici Store Manager'a tiklar
    // Kullanici Customers'a tiklar

    @Test
    public void indirmeSecenekleriDogrulama() {
        ReusableMethods.myAccount();
        customerPage.storeManagerBUtton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        customerPage.customerButton.click();

        // Indirme seceneklerini gordugunu dogrular
        // Kullanici tum bilgileri pdf olarak indirir
        // Kullanici tum bilgileri excel olarak indirir
        // Kullanici tum bilgileri cvs olarak indirir

        customerPage.printButton.isEnabled();
        customerPage.pdfButton.isEnabled();
        customerPage.excelButton.isEnabled();
        customerPage.csvButton.isEnabled();
        customerPage.printButton.isDisplayed();
        customerPage.pdfButton.isDisplayed();
        customerPage.excelButton.isDisplayed();
        customerPage.csvButton.isDisplayed();
        customerPage.pdfButton.click();
        String dosyaYoluPdf="C:\\Users\\Samet\\Downloads\\Store Manager - Pearly Market (6).pdf";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluPdf)));
        System.out.println(Files.exists(Paths.get(dosyaYoluPdf)));
        customerPage.excelButton.click();
        String dosyaYoluExcel="C:\\Users\\Samet\\Downloads\\Store Manager - Pearly Market (4).xlsx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluExcel)));
        System.out.println(Files.exists(Paths.get(dosyaYoluExcel)));
        customerPage.csvButton.click();
        String dosyaYolu="C:\\Users\\Samet\\Downloads\\Store Manager - Pearly Market (2).csv";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println(Files.exists(Paths.get(dosyaYolu)));



    }

}


