package tests.US_005;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CesurPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_0002 {

    CesurPage fatihpage=new CesurPage();

    @Test
    public void addNew() throws IOException {

        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();
        fatihpage.addNewButton.click();

        WebElement virtual=Driver.getDriver().findElement(By.xpath("//*[@id='is_virtual']"));
        virtual.click();
        ReusableMethods.getScreenshot("TC0002", virtual);
        Assert.assertTrue(virtual.isDisplayed());


        WebElement downloadable=Driver.getDriver().findElement(By.xpath("//*[@id='is_downloadable']"));

        downloadable.click();
        ReusableMethods.getScreenshot("TC0002", downloadable);
        Assert.assertTrue(downloadable.isDisplayed());
    }
}
