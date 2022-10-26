package tests.US_22;

import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_01 {
    CustomerPage customerPage=new CustomerPage();
    // Kullanici url'ye adresine gider
    // Kullanici signin butonuna tiklar
    // Kullanici gecerli bir username girer
    // Kullanici gecerli bir password girer
    // Kullanici signin butonuna basar
    // Kullanici indirimli urunlerin tumunu gor linkinin görünür oldugunu dogrular
    // Kullanici kategorinin ana sayfasina gider

    @Test
    public void urunleriListeleme() throws IOException {
        ReusableMethods.myAccount();
        customerPage.anaSayfaLink.click();
        ReusableMethods.getScreenshot02("indirimli urunlerin tumunu gor linkini gorunmuyor");
    }

    }
