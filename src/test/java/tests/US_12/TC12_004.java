package tests.US_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Random;

public class TC12_004 {
    MyAccountPage myAccountPage;
    HomePage hmPage;
    @Test
    public void test_accountDetails() {
        //1. Vendor, url'ye gider
        //2. Vendor, register butonuna tıklar
        //3. Vendor, açılan ekranda become a vendor linkine tıklar
        //4. Vendor, yeni bir sekme açarak geçici email sitesi url'sine gider
        //5. Vendor, geçici email sitesinden yeni bir email adresi alır.
        //6. Vendor, Email kutusuna, geçici email sitesinden aldığı email adresini girer.
        //7. Vendor, Verification Code kutusuna tıklar.
        //8. Vendor "Verification code sent to your email:" uyarısının çıktığını görür.
        //9. Vendor, diğer sekmede geçici email sitesine gidip sayfadaki refresh butonuna tıklar.
        //10.Vendor, geçici email sitesine gelen Verification Code'u alır, kayıt sayfasındaki Verification Code kutusuna girer
        //11.Vendor, Password kutusuna güçlü password girer
        //12.Vendor, Confirm Password kutusuna güçlü password girer
        //13.Registor butonunu tıklar
        //14.Register yapılabildiğini görür
        //15.Açılan sayfada not right away linkini tıklar
        myAccountPage=new MyAccountPage();
        hmPage=new HomePage();
        ReusableMethods.becomeAVendor();
        ReusableMethods.validRegistration();
        myAccountPage.notRightNow.click();
        ReusableMethods.waitFor(3);
        //16. vendor My Account'u görür ve tıklar
        ReusableMethods.scrollIntoView(hmPage.myAccount);
        ReusableMethods.waitFor(2);
        hmPage.myAccount.click();
        ReusableMethods.waitFor(3);
        //17. Account Details linkini tıklar
        ReusableMethods.scrollIntoView(myAccountPage.subscribe);
        ReusableMethods.waitFor(2);
        myAccountPage.accountDetails.click();
        ReusableMethods.waitFor(3);
        //18. Account Details sayfasında firstname kutucuğunda isim bilgisini görür, temizler, yeni isim girer
        myAccountPage.firstnameBox.clear();
        myAccountPage.firstnameBox.sendKeys("Ahmet");
        //19. Lastname kutucuğunda soyadı bilgisini görür,temizler, yeni soyisim girer
        myAccountPage.lastnameBox.clear();
        myAccountPage.lastnameBox.sendKeys("Yar");
        //20. Display name kutucuğunda, görünen isim bilgisini görür, temizler, yeni görünen isim girer
        myAccountPage.displayNameBox.clear();
        myAccountPage.displayNameBox.sendKeys("AhmetYAR");
        //21. Email address kutucuğunda e-posta adresini görür, temizler, yeni e-posta adresi girer
        Random rndm=new Random();
        long sayi= rndm.nextLong();
        myAccountPage.eMailBox.clear();
        myAccountPage.eMailBox.sendKeys("xyz" + sayi + "@gmail.com");
        ReusableMethods.waitFor(2);
        //22. Save Changes butonunu tıklar
        ReusableMethods.scrollIntoView(myAccountPage.saveChangesButton);
        ReusableMethods.waitFor(2);
        myAccountPage.saveChangesButton.click();
        ReusableMethods.waitFor(2);
        //23. isim, soyisim, görünen isim ve e-posta adresinin güncellendiğini test eder
        Assert.assertTrue(myAccountPage.accountDetailsChanged.isDisplayed());
        //24.Sayfayı kapatır
        Driver.quitDriver();
    }
}
