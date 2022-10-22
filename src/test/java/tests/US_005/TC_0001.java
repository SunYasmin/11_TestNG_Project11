package tests.US_005;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatihPage;
import pages.HomePage;
import pages.FatihPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_0001 {
FatihPage fatihPage=new FatihPage();

    @Test
    public void urunListem() {
        ReusableMethods.myAccount();
        fatihPage.storeManager.click();
        fatihPage.products.click();

        WebElement status = Driver.getDriver().findElement(By.xpath("(//*[@class='sorting_disabled'])[4]"));
        Assert.assertTrue(status.isDisplayed());

        WebElement stock = Driver.getDriver().findElement(By.xpath("(//*[@class='sorting_disabled'])[5]"));
        Assert.assertTrue(status.isDisplayed());

        WebElement price = Driver.getDriver().findElement(By.xpath("(//*[@class='sorting'])[2]"));
        Assert.assertTrue(status.isDisplayed());

        WebElement date = Driver.getDriver().findElement(By.xpath("(//*[@class='sorting'])[4]"));
        Assert.assertTrue(status.isDisplayed());


    }
}
