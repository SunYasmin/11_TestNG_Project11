package tests.US_005;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FatihPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class TC_0004 {

  FatihPage fatihpage=new FatihPage();

    @Test
    public void resimEkle() throws InterruptedException, AWTException {
        ReusableMethods.myAccount();
        fatihpage.storeManager.click();
        fatihpage.products.click();
        fatihpage.addNew.click();

        WebElement resimeklee= Driver.getDriver().findElement(By.id("featured_img_display"));
        resimeklee.click();

        WebElement selectFiles=Driver.getDriver().findElement(By.id("__wp-uploader-id-1"));
        selectFiles.click();

        Robot rb =new Robot();
        StringSelection str=new StringSelection("C:\\Users\\fatih\\Documents\\resim.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        WebElement loadMore=Driver.getDriver().findElement(By.xpath("//*[@class='button load-more button-primary']"));
        loadMore.click();

        fatihpage.addproductSelect.click();
    }
}
