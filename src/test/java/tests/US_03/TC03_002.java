package tests.US_03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC03_002 {

    MyAccountPage myAccountPage;
    HomePage homePage;
    CartPage cartPage;
    Actions actions;
    JavascriptExecutor jse;


    @Test
    public void testCase02() throws InterruptedException {

        //1.Ur'lye gidilir
        //2.Giris Yap/SignIn ' e tiklanir
        //3.Gecerli Kullanici bilgileri girilir
        //4.Giris Yap'a tiklanir
        //5.Hesabim sayfasina giris yapildigi test edilir
        //6.Acilan sayfada My Orders'a/Siparisler tiklanir
        //7.Acilan sayfada Browse Products/Go Shop butonuna tiklanir
        //8.Magaza butonunun gorunur oldugu test edilir
        //9.Rastgele 3 urun secilir ve sepete eklenir
        //10.Sepete gidilir ve urunlerin sepette oldugu test edilir


        MyAccountPage myAccountPage = new MyAccountPage();
        HomePage homePage = new HomePage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        ReusableMethods.goShop();
        List<WebElement> urunListesi = homePage.urunList12li;
        int count = 0;
        int index = 0;
        //Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i <= urunListesi.size(); i++) {
            index = i + 1;
            WebElement tiklanacakURun = Driver.getDriver().findElement(By.xpath("(//*[@class='product-media'])[" + index + "]"));
            jse.executeScript("arguments[0].scrollIntoView(true);", tiklanacakURun);
            actions.moveToElement(tiklanacakURun).perform();
            if (homePage.addToCartSimgesi.isDisplayed()) {
                homePage.addToCartSimgesi.click();
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            count = Integer.parseInt(homePage.cartUrunSayisiWe.getText());
            if (count == 3) {
                break;
            }
        }
        actions.sendKeys(Keys.HOME).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.waitForClickablility(homePage.pearlyMarketYazisi, 5);
        homePage.pearlyMarketYazisi.click();

        Driver.closeDriver();
    }


}
