package utilities;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.HomePage;
import pages.RegistrationPage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods {

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
    //========ScreenShot Web Element(Bir webelementin resmini alma)=====//
    public static String getScreenshotWebElement(String name, WebElement element) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        File source = element.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String wElementSS = System.getProperty("user.dir") + "/target/WElementScreenshots/" + name + date + ".png";
        File finalDestination = new File(wElementSS);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return  wElementSS;
    }
    //========Switching Window(Pencereler arası geçiş)=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
    //========Hover Over(Elementin üzerinde beklemek)=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }
    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    //   HARD WAIT WITH THREAD.SLEEP
//   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    public static void signIn(){
        //https://pearlymarket.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));

        //Sign-in butonuna tiklar
        HomePage home= new HomePage();
        home.signInButton.click();


        //-test data user email: trqateam72022@gmail.com
        //-test data password : 123456team7 dataları girip sign-in basın

        home.userEmail.sendKeys(ConfigReader.getProperty("vendorEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"))
                .sendKeys(Keys.ENTER).perform();

    }




    public static void myAccount(){
        HomePage home=new HomePage();

        ReusableMethods.signIn();
        ReusableMethods.waitFor(3); //3 saniye beklesin
        ReusableMethods.scrollIntoView(home.myAccount);
        ReusableMethods.waitFor(3);
        home.myAccount.click();

    }



    //========Scroll Into View=====//
    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //========ScrollBy=====//
    public static void scrollBy(long scrollY) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0," + scrollY + ")", "");
    }

    //=======BecomeAVendor======//
    public static void becomeAVendor(){
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        HomePage home= new HomePage();
        home.registerHomePage.click();
        ReusableMethods.waitFor(1);
        home.becomeAVendor.click();
    }

    //==========GetVerificationCode=========//
    public static void getVerificationCode(){
        Actions actions = new Actions(Driver.getDriver());
        RegistrationPage registrationPage = new RegistrationPage();
        String hashCodeFirstTab = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("temporaryMailUrl"));
        String hashCodeSecondTab = Driver.getDriver().getWindowHandle();
        registrationPage = new RegistrationPage();
        registrationPage.tempEmailAccountName.click();
        Driver.getDriver().switchTo().window(hashCodeFirstTab);
        registrationPage.emailBox.click();
        actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("v").perform();
        actions.keyUp(Keys.CONTROL).perform();
        registrationPage.verificationCodeBox.click();
        String verificationCodeSentWarning = "Verification code sent to your email";
        Assert.assertTrue(registrationPage.verificationCodeSentMessage.getText().contains(verificationCodeSentWarning));
        Driver.getDriver().switchTo().window(hashCodeSecondTab);
        registrationPage.tempEmailRefreshButton.click();
        ReusableMethods.waitFor(5);
        String verificationCode = registrationPage.tempEmailInboxFirstEmail.getText().replaceAll("\\D", "");
        Driver.getDriver().switchTo().window(hashCodeFirstTab);
        registrationPage.verificationCodeBox.sendKeys(verificationCode);
    }

















































































































    //GO SHOP - CART - SEPET METHODLAR


    public static void goShop() {
        MyAccountPage myAccountPage = new MyAccountPage();
        ReusableMethods.myAccount();
        myAccountPage.orders.click();
        ReusableMethods.scrollIntoView(myAccountPage.goToShop);
        //ReusableMethods.hover(myAccountPage.goShop);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(myAccountPage.goToShop.isDisplayed());
        myAccountPage.goToShop.click();
        ReusableMethods.waitFor(3);

    }


}
