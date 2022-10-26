package tests.US_006;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CesurPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;


public class TC_0001 {
    CesurPage fatihpage=new CesurPage();
    JavascriptExecutor jsx = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() throws InterruptedException {

        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();
        fatihpage.addNewButton.click();

        jsx.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(5000);

        List<WebElement> categorie = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']"));

        for (WebElement w : categorie) {

            jsx.executeScript("arguments[0].click();", w);
            Assert.assertTrue(w.isDisplayed());

        }

        Driver.closeDriver();


    }
}
