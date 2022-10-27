package tests.US_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductPage;



import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_0002 {
    AddProductPage fatihpage=new AddProductPage();

    @Test
    public void addNew() throws IOException {

        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();
        fatihpage.addNewButton.click();

        WebElement virtual=Driver.getDriver().findElement(By.xpath("//*[@id='is_virtual']"));
        virtual.click();
        ReusableMethods.getScreenshot02("TC0002");
        Assert.assertTrue(virtual.isDisplayed());


        WebElement downloadable=Driver.getDriver().findElement(By.xpath("//*[@id='is_downloadable']"));

        downloadable.click();
        ReusableMethods.getScreenshot02("TC0002");
        Assert.assertTrue(downloadable.isDisplayed());
        Driver.closeDriver();
    }
}
