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

public class TC04_006 {

    //1_https://pearlymarket.com adresine gidilir
    //2_ "giriş yap" sekmesine tıklanir
    //3_ Email kutusuna geçerli email girilir
    //4_ password kutusuna geçerli paralo girilir
    //5_ "giriş yap" butonuna tıklanir
    //6_"Hesabım" sekmesine tıklanir
    //7_"Siparişler" butonuna tıklanir
    //8_"Go Shop" butonuna tıklanir
    //9_ 2 urun icin sepete ekle ikonuna tıklanir
    //10_"Sepetim" butonuna tıklanir
    //11_"Sepeti Görüntüle" butonuna tıklanir
    //12_Ürünlerin sepette görüldügünü test etnir
    //13_Coupon seceneginin gorunur oldugu test edilir



    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Actions actions = new Actions(Driver.getDriver());

    CartPage cartPage = new CartPage();


    @Test
    public void testCase06() throws InterruptedException {

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


        //ReusableMethods.scrollIntoView(ekle);
        Thread.sleep(1000);
        //haliAdetKutusu.clear();
        //ReusableMethods.waitFor(3);
        //haliAdetKutusu.click();
        //haliAdetKutusu.clear();
        //haliAdetKutusu.sendKeys("98");
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

        // TC02 (+) ve (-) butonlarinin urunu sırayla arttirdigi ve eksildigi test edilir
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

        //TC03 Stok fazlasi urun eklenememeli ve update cart ile guncellendigi gorunur oldugu test edilir
        actions.moveToElement(cartPage.cartQuantityPlusHali).perform();
        int say = 0;
        for (int i = 0; i < 100; i++) {

            cartPage.cartQuantityPlusHali.click();
            say++;
        }
        Assert.assertTrue(cartPage.updateCartButton.isDisplayed());

        //TC07 Shipping bilgilerinin gorunur oldugu test edilir)

        ReusableMethods.waitFor(3);
        Assert.assertTrue(cartPage.shippingBilgileri.isDisplayed());
        Assert.assertTrue(cartPage.cartTotals.isDisplayed());
        Assert.assertTrue(cartPage.subTotal.isDisplayed());


        //TC05(Apply coupon)

        ReusableMethods.scrollIntoView(cartPage.applyCoupon);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(cartPage.applyCoupon.isDisplayed());
        Assert.assertTrue(cartPage.couponDiscountYaziWe.isDisplayed());


        //TC06(Tekrar Shopping devam butonu olmali)


        ReusableMethods.waitFor(3);
        Assert.assertTrue(cartPage.continueShoppingButton.isDisplayed());
        Assert.assertTrue(cartPage.continueShoppingButton.isEnabled());
        ReusableMethods.waitFor(4);
        actions.moveToElement(cartPage.continueShoppingButton);
        ReusableMethods.waitFor(4);
        //Driver.getDriver().get("https://pearlymarket.com/shop/");
        cartPage.continueShoppingButton.click();
        ReusableMethods.waitFor(4);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("shop"));
        ReusableMethods.waitFor(4);
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(4);


    }
}