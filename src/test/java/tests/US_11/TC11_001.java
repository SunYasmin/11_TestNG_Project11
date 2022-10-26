package tests.US_11;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.ProductsPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethods;
public class TC11_001 {
    ProductsPage productsPage;
    MyAccountPage myAccountPage;
    StoreManagerPage storeManager;
    @Test
    public void test1_urunSayfasınaGit() {
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
        //10. Products listesinde ilk satırdaki ürünü seçer
        myAccountPage.storeMan.click();
        storeManager.products.click();
        ReusableMethods.waitFor(2);
        Select select1=new Select(productsPage.allProductsTypes);
        productsPage.allProductsTypes.click();
        select1.selectByVisibleText("Simple Product");
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(productsPage.urunListesindenAl);
        ReusableMethods.waitFor(2);
        productsPage.urunListesindenAl.click();
        ReusableMethods.waitFor(2);    }
    @Test(dependsOnMethods = "test1_urunSayfasınaGit")
    public void test2_pieceType() {
        productsPage=new ProductsPage();
        myAccountPage=new MyAccountPage();
        storeManager=new StoreManagerPage();
        //11.Toptan ürün gösterme ayarları linkini görür ve tıklar
        ReusableMethods.scrollIntoView(productsPage.catalogVisibility);
        ReusableMethods.waitFor(2);
        productsPage.toptanUrunGostermeAyarlariSekmesi.click();
        ReusableMethods.waitFor(2);
        //12. Piece type kutucuğunu tıklar
        //13. Ürün parça çeşidini seçer
        Select select = new Select(productsPage.pieceType);
        productsPage.pieceType.click();
        ReusableMethods.waitFor(2);
        select.selectByVisibleText("Piece");
        ReusableMethods.waitFor(2);
        //14. SUBMIT butonunu tıklar
        ReusableMethods.scrollIntoView(productsPage.submit);
        ReusableMethods.waitFor(2);
        productsPage.submit.click();
        ReusableMethods.waitFor(2);
        //15. Ürünün başarıyla kaydedildiğini test eder
        Assert.assertTrue(productsPage.productSuccessfullyPublished.isDisplayed());
        //16.Sayfayı kapatır
        Driver.closeDriver();    }
}

