package tests.US_22;

import org.testng.annotations.Test;
import pages.CustomerPage;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_03 {
    CustomerPage customerPage=new CustomerPage();
    // Kullanici url'ye adresine gider
    // Kullanici signin butonuna tiklar
    // Kullanici gecerli bir username girer
    // Kullanici gecerli bir password girer
    // Kullanici signin butonuna basar
    // Kullanici indirimli urunlerin tumunu gor linkinin görünür oldugunu dogrular
    // Kullanici kategorinin ana sayfasina gider
    // Kullanici siralama button'a tiklar
    // Kullanici fiyata göre sırala: düsükten yükseğe tiklar


    @Test
    public void urunleriListeleme3() throws IOException {
        ReusableMethods.myAccount();
        customerPage.anaSayfaLink.click();
        ReusableMethods.getScreenshot02("indirimli urunlerin tumunu gor linkini gorunmuyor3");
    }

}




