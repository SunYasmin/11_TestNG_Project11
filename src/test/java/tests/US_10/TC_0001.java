package tests.US_10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AddProductPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_0001 {
    AddProductPage fatihpage = new AddProductPage();
    JavascriptExecutor jsx = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test0001() throws IOException {
        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();
        fatihpage.addNewButton.click();
        jsx.executeScript("window.scrollBy(0,1500)", "");
        ReusableMethods.waitFor(3);

        fatihpage.attributes.click();
        ReusableMethods.waitFor(3   );

        fatihpage.colorOk.click();
        WebElement selectAll= Driver.getDriver().findElement(By.xpath("//*[@class='button wcfm_add_attribute_term wcfm_select_all_attributes']"));

        selectAll.click();
        ReusableMethods.getScreenshot02("US_0010_TC_0001");


    }
}
