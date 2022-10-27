package tests.US_08;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.ProductsPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Random;
public class TC08_001 {
    MyAccountPage myAccountPage;
    StoreManagerPage storeManager;
    ProductsPage productsPage;
    @Test
    public void test1_manageStockClick() {
        productsPage=new ProductsPage();
        myAccountPage=new MyAccountPage();
        storeManager=new StoreManagerPage();
        //1. vendor url'ye gider
        //2. vendor signin butonuna tıklar
        //3. vendor Username or email address kutucuğuna geçerli bir username girer
        //4. vendor Password kutucuğuna geçerli bir password girer
        //5. vendor sign in butonuna tıklar
        //6. vendor My Account linkini görür ve tıklar
        ReusableMethods.myAccount();
        //7. Store Manager linkini tıklar
        //8. Products linkini tıklar
        //9. Products ekranından simple product türünü seçer
        //10.Products listesinde ilk satırdaki ürünü seçer
        myAccountPage.storeMan.click();
        storeManager.products.click();
        ReusableMethods.waitFor(2);
        Select select = new Select(productsPage.allProductsTypes);
        productsPage.allProductsTypes.click();
        select.selectByVisibleText("Simple Product");
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(productsPage.urunListesindenAl);
        ReusableMethods.waitFor(2);
        productsPage.urunListesindenAl.click();
        ReusableMethods.waitFor(2);
        //11. Manage Stock kutucuğu işaretli değilse işaretler
        ReusableMethods.scrollIntoView(productsPage.manageStockBox);
        ReusableMethods.waitFor(2);
        if (!productsPage.manageStockBox.isSelected()) {productsPage.manageStockBox.click();
            ReusableMethods.waitFor(2);}    }
        @Test(dependsOnMethods = "test1_manageStockClick")
        public void test2_stockQty() {
        productsPage=new ProductsPage();
        myAccountPage=new MyAccountPage();
        storeManager=new StoreManagerPage();
        //12. Stock Qty kutucuğundaki ürün miktarını temizler, numerik ürün miktarı girer
        ReusableMethods.scrollIntoView(productsPage.stockQtyBox);
        productsPage.stockQtyBox.click();
        ReusableMethods.waitFor(2);
        productsPage.stockQtyBox.clear();
        Random rndm=new Random();
        int sayi=rndm.nextInt(10000);
        String stockQty= String.valueOf(sayi);
        productsPage.stockQtyBox.sendKeys(stockQty);
        ReusableMethods.waitFor(2);
        //13. SUBMIT butonunu tıklar
        ReusableMethods.scrollIntoView(productsPage.submit);
        ReusableMethods.waitFor(2);
        productsPage.submit.click();
        ReusableMethods.waitFor(2);
        //14. Ürünün başarıyla kaydedildiğini test eder
        Assert.assertTrue(productsPage.productSuccessfullyPublished.isDisplayed());
        //15.Sayfayı kapatır
        Driver.closeDriver();
    }

}
