package tests.US_005;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CesurPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_0003 {

    CesurPage fatihpage=new CesurPage();
    @Test
    public void productTitle() throws InterruptedException {



        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));

        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();
        fatihpage.addNewButton.click();

        WebElement productTitle=Driver.getDriver().findElement(By.id("pro_title"));
        productTitle.sendKeys("Kot Pantolon");

        WebElement productPrice=Driver.getDriver().findElement(By.xpath("//*[@id='sale_price']"));
        productPrice.sendKeys("20" );

        String actualTitle="Kot Pantolon";
        Assert.assertTrue(actualTitle.contains(productTitle.getText()));

        String actualPrice="20";
        Assert.assertTrue(actualPrice.contains(productPrice.getText()));

    }

}
