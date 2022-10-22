package tests.US_005;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FatihPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_0005 {
FatihPage fatihpage=new FatihPage();
    @Test
    public void test0005() {

        ReusableMethods.myAccount();
        fatihpage.storeManager.click();
        fatihpage.products.click();
        fatihpage.addNew.click();

        WebElement shortDescription= Driver.getDriver().findElement(By.xpath("(//*[@lang='en-US'])[3])"));
        shortDescription.click();
        shortDescription.sendKeys("hello world");



    }
}
