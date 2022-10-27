package tests.US_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AddProductPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TC_0004 {

    AddProductPage fatihpage=new AddProductPage();

    @Test
    public void resimEkle() throws InterruptedException, AWTException, IOException {
        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();
        fatihpage.addNewButton.click();

        WebElement resimeklee= Driver.getDriver().findElement(By.id("featured_img_display"));
        resimeklee.click();

        WebElement selectFiles=Driver.getDriver().findElement(By.id("__wp-uploader-id-1"));
        selectFiles.click();

        Robot rb =new Robot();
        StringSelection str=new StringSelection("C:\\Users\\fatih\\Documents\\resim.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);
        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        Thread.sleep(3000);
        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(3000);
        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        WebElement loadMore=Driver.getDriver().findElement(By.xpath("//*[@class='button load-more button-primary']"));
        loadMore.click();
        Thread.sleep(15000);
        fatihpage.selectProductButton.click();
        Thread.sleep(5000);
        ReusableMethods.getScreenshot02("TC0004");
    }
}
