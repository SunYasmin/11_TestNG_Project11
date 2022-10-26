package tests.US_04;

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

public class TC04_004 {

    //1_https://pearlymarket.com adresine gidilir
    //2_ "giriş yap" sekmesine tıklanir
    //3_ Email kutusuna geçerli email girilir
    //4_ password kutusuna geçerli paralo girilir
    //5_ "giriş yap" butonuna tıklanir
    //6_"Hesabım" sekmesine tıklanir
    //7_"Siparişler" butonuna tıklanir
    //8_"Go Shop" butonuna tıklanir
    //9_5 urun icin sepete ekle ikonuna tıklanir
    //10_"Sepetim" butonuna tıklanir
    //11_"Sepeti Görüntüle" butonuna tıklanir
    //12-Clear Cart a tiklanir ve Cart is empty yazisinin gorunurlugu test edilir
    //13-Tetur ToShop butonunun goruldugu test edilir


    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Actions actions = new Actions(Driver.getDriver());

    CartPage cartPage = new CartPage();


    @Test
    public void testCase04() throws InterruptedException {

        ReusableMethods.myAccount();
        ReusableMethods.waitFor(4);
        myAccountPage.orders.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(myAccountPage.goToShop);
        ReusableMethods.waitFor(3);
        myAccountPage.goToShop.click();
        ReusableMethods.waitFor(4);

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

        //Clear Cart
        ReusableMethods.waitFor(3);
        actions.moveToElement(cartPage.clearCartButton).perform();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(cartPage.clearCartButton.isDisplayed());
        cartPage.clearCartButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(cartPage.cartEmptyYaziWe.isDisplayed());
        Assert.assertTrue(cartPage.reTurnToShop.isDisplayed());
        ReusableMethods.waitFor(3);
        Driver.closeDriver();


    }
}