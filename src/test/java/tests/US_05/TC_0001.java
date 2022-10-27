package tests.US_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProductPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_0001 {
AddProductPage fatihpage=new AddProductPage();
    @Test
    public void urunListem() throws IOException {
        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();




        WebElement status = Driver.getDriver().findElement(By.xpath("(//*[@class='sorting_disabled'])[4]"));
        Assert.assertTrue(status.isDisplayed());

        WebElement stock = Driver.getDriver().findElement(By.xpath("(//*[@class='sorting_disabled'])[5]"));
        Assert.assertTrue(status.isDisplayed());

        WebElement price = Driver.getDriver().findElement(By.xpath("(//*[@class='sorting'])[2]"));
        Assert.assertTrue(status.isDisplayed());

        WebElement date = Driver.getDriver().findElement(By.xpath("(//*[@class='sorting'])[4]"));
        Assert.assertTrue(status.isDisplayed());

        ReusableMethods.getScreenshot02("US05TC01");

        Driver.closeDriver();




    }
}
