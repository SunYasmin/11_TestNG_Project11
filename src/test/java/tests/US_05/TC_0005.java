package tests.US_05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CesurPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_0005 {
    CesurPage fatihpage=new CesurPage();
    @Test
    public void test0005() throws IOException, InterruptedException {

        ReusableMethods.myAccount();
        fatihpage.storeMan.click();
        fatihpage.products.click();
        fatihpage.addNewButton.click();
        JavascriptExecutor jsx = (JavascriptExecutor)Driver.getDriver();
        jsx.executeScript("window.scrollBy(0,450)", "");

        //Short description, Description kisimlarina bilgi girilebilmeli

        ReusableMethods.waitFor(5);
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe[@id='excerpt_ifr']"));
        frame.click();
        Driver.getDriver().switchTo().frame(frame);
        WebElement text = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        text.sendKeys("Hello World");
        Driver.getDriver().switchTo().defaultContent();

        ReusableMethods.waitFor(3);
        WebElement frame2 = Driver.getDriver().findElement(By.xpath("//iframe[@id='description_ifr']"));
        jsx.executeScript("arguments[0].click();", frame2);
        Driver.getDriver().switchTo().frame(frame2);
        WebElement text2 = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        text2.sendKeys("Hello, world!");


        ReusableMethods.waitFor(2);
        jsx.executeScript("window.scrollBy(0,450)", "");
        ReusableMethods.getScreenshot("TC05descriptionVisible",fatihpage.descriptionText);
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().defaultContent();











    }
}
