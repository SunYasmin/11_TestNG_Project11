package tests.US_07;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CesurPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;


public class TC_0001 {
    CesurPage fatihpage = new CesurPage();
    JavascriptExecutor jsx = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {
        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();
        fatihpage.addNewButton.click();
        jsx.executeScript("window.scrollBy(0,800)", "");
        Thread.sleep(5000);
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//*[@id='product_cats_checklist']"));
        for (WebElement x : list) {

            jsx.executeScript("arguments[0].click();", x);
            Assert.assertTrue(x.isDisplayed());

        }
    }
}
