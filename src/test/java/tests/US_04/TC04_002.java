package tests.US_04;

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

public class TC04_002 {

    //1_https://pearlymarket.com adresine git
    //2_ "giriş yap" sekmesine tıkla
    //3_ Email kutusuna geçerli email gir
    //4_ password kutusuna geçerli paralo gir
    //5_ "giriş yap" butonuna tıkla
    //6_"Hesabım" sekmesine tıkla
    //7_"Siparişler" butonuna tıkla
    //8_"Go Shop" butonuna tıkla
    //9_ 2 urun icin sepete ekle ikonuna tıkla
    //10_"Sepetim" butonuna tıkla
    //11_"Sepeti Görüntüle" butonuna tıkla
    //12_Ürünlerin sepette görüldügünü test et
    //13_"Ürün" "Fiyat"  "Miktar"  "Ara Toplam"  yazisinin görüldüğünü test et
    //14_"+(artı)" butonuna tıkla
    //15_"Sepeti yenile" butonuna tıkla
    //16_Fiyatın guncellendigini test et
    //17_Miktarın arttıgını test et
    //18_"-(eksi)" butonuna tıkla
    //19_"Sepeti yenile" butonuna tıkla
    //20_"Miktarın eksildigini test et


    MyAccountPage myAccountPage;
    HomePage homePage;
    CartPage cartPage;
    Actions actions;
    JavascriptExecutor jse;

    @Test
    public void testCase02() throws InterruptedException {
        MyAccountPage myAccountPage = new MyAccountPage();
        HomePage homePage = new HomePage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


        ReusableMethods.goShop();

        actions.moveToElement(cartPage.ikiliYastikAddToCartSimgesi).perform();
        ReusableMethods.waitFor(4);
        actions.moveToElement(cartPage.ikiliYastikAddToCartSimgesi).click().perform();
        ReusableMethods.waitFor(6);

        actions.moveToElement(cartPage.shopSayfasiToolBox);
        actions.moveToElement(cartPage.searchBox).doubleClick();
        ReusableMethods.waitFor(3);
        cartPage.searchBox.sendKeys("Halı", Keys.ENTER);
        ReusableMethods.waitFor(3);
        actions.moveToElement(cartPage.haliDetayAddToCart).perform();
        ReusableMethods.waitFor(4);
        cartPage.haliDetayAddToCart.click();


        ReusableMethods.waitFor(6);
        String cartUrunSayisiStr = cartPage.haliDetayCarttakiSayi.getText();
        String expctdSepUrunSayisi = "2";
        Assert.assertTrue(cartUrunSayisiStr.contains(expctdSepUrunSayisi));


        ReusableMethods.waitFor(6);

        WebElement ekle = cartPage.haliDetayAddToCart;
        WebElement haliAdetKutusu = cartPage.haliDetayAdetKutusu;

        Thread.sleep(1000);


        actions.moveToElement(cartPage.haliDetayPlus).perform();
        int sayac = 0;
        for (int i = 0; i < 105; i++) {

            cartPage.haliDetayPlus.click();
            sayac++;

        }
        String sayacStr = String.valueOf(sayac);
        System.out.println("Hali click sayisi :" + sayac);
        ReusableMethods.waitFor(4);
        ekle.click();
        ReusableMethods.waitFor(4);
        Assert.assertFalse(sayacStr.equals(cartPage.haliDetayCartSimgesi.getText()));


        //ReusableMethods.click(ekle);
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.haliDetayCarttakiSayi.getText(), "2");
        ReusableMethods.waitFor(6);

        actions.moveToElement(cartPage.haliDetayCartSimgesi).perform();
        ReusableMethods.waitFor(3);
        cartPage.haliDetayCartSimgesi.click();
        ReusableMethods.waitFor(3);


        actions.moveToElement(cartPage.viewCart).perform();
        ReusableMethods.waitFor(3);
        cartPage.viewCart.click();
        ReusableMethods.waitFor(6);
        Driver.getDriver().getCurrentUrl();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));


        //Secilen ürünler View Cartta görülmeli; Rakam, miktar ve toplam olarak görülmeli

        List<WebElement> urunBilgileri = cartPage.cartPrdouctCells;
        int count = 1;
        for (int i = 0; i < urunBilgileri.size(); i++) {
            Assert.assertTrue(urunBilgileri.get(i).isDisplayed());
            count++;
        }

        ReusableMethods.waitFor(2);
        cartPage.cartQuantityPlus.click();
        ReusableMethods.waitFor(1);
        cartPage.cartQuantityPlus.click();
        ReusableMethods.waitFor(1);
        cartPage.cartQuantityMinus.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.scrollIntoView(cartPage.updateCartButton);
        ReusableMethods.waitFor(2);
        cartPage.updateCartButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(cartPage.cartUpdated.isDisplayed());
        ReusableMethods.waitFor(4);


    }
}