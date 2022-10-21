package tests.US_005;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatihPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_0002 {
    FatihPage fatihpage=new FatihPage();


    @Test
    public void addNew() {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));

        ReusableMethods.myAccount();
        fatihpage.storeManager.click();
        fatihpage.products.click();
        fatihpage.addNew.click();

        WebElement virtual=Driver.getDriver().findElement(By.xpath("//*[@id='is_virtual']"));
        Assert.assertTrue(virtual.isDisplayed());

        WebElement downloadable=Driver.getDriver().findElement(By.xpath("//*[@id='is_downloadable']"));
        Assert.assertTrue(downloadable.isDisplayed());
    }
}
