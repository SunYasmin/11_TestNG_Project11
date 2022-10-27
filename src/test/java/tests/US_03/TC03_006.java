package tests.US_03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC03_006 {


    @DataProvider
    public static Object[][] kullanici() {  //2 boyutlu array kullanimi
        return new Object[][]{{"trqateam72022@gmail.com", "123456team7"}};
    }

    @Test(dataProvider = "kullanici")
    public void test01(String userEmail, String password) {
        //https://www.pearlymarket.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));

        //login butonuna bas
        HomePage homePage = new HomePage();
        homePage.signInButton.click();

        //Data provider ile vendorEmail ve password girelim
        //login butonuna tiklayin
        homePage.userEmail.sendKeys(userEmail);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(password)
                .sendKeys(Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(homePage.signOut.isDisplayed());
        Driver.closeDriver();
    }


}
