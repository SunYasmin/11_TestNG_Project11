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

import java.util.List;

public class TC03_003 {


    MyAccountPage myAccountPage;
    HomePage homePage;
    CartPage cartPage;
    Actions actions;
    JavascriptExecutor jse;

    @Test
    public void testCase003() {


    //1-Url'e gidilir https://pearlymarket.com
    //2-Giris yap/Sign In'e tiklanir
    //3-Gecerli kullanici bilgileri girilir
    //3-Giris yap/Sign In'e tiklanir
    //4-Hesabim sayfasina giris yapildigi test edilir
    //5-Acilan sayfada My Account bolumune tiklanir
    //6-MyAccount bolumunde Orders/Siparisler bolumune tiklanir
    //7-Acilan sayfada Browse Products/Go Shop at bolumune tiklanir
    //8-Magaza/Sirket yazisinin gorunur oldugu test edilir
    //9-Rastgele 3 urun secilir ve sepete eklenir
    //10-Sepete/Cart' a tiklanir
    //11-Acilan sayfada checkout tiklanir
    //12-Biiling Details/Fatura Detaylari'nin gorunurlugu test edilir



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

        //homePage.pearlyMarketYazisi.click();
        //ReusableMethods.waitFor(4);


        actions.moveToElement(cartPage.cart);
        ReusableMethods.waitFor(3);
        cartPage.cart.click();
        ReusableMethods.waitFor(3);
        actions.moveToElement(cartPage.checkOut).perform();
        ReusableMethods.waitFor(3);
        cartPage.checkOut.click();
        ReusableMethods.waitFor(6);
        Driver.getDriver().getCurrentUrl();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        ReusableMethods.waitFor(3);

        Assert.assertTrue(cartPage.billingDetailsYaziWe.isDisplayed());
        Driver.closeDriver();


}
}
