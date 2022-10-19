package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;
    /*
    Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu için her test methodu için yeni bir pencere(driver)
    açıyor. Eğer dirver'e bir değer atanmamışsa yani driver==null; ise bir kere driver'i çalıştırır diyerek bir kere if()
    içini çalıştıracak.Ve driver artik bir kere calistigi icin ve deger atandigi icin null olmayacak ve direk return edecek ve diger
    testlerimiz ayni pencere(driver) uzerinde calisacak.
     */

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")){

                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }


        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }




    public static void closeDriver(){
        if (driver!=null) {//driver'a deger atanmissa
            driver.close();
            driver=null;//kapandiktan sonra sonraki acmalari garanti altina almak icin driver'i tekrar
            //null yaptik.
        }

    }

    public static void quitDriver(){
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }


}
