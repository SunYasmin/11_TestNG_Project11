package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ReportsPage {
    public ReportsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//span[@class='text'])[11]")
    public WebElement followers;

    @FindBy (xpath = "(//span[@class='text'])[14]")
    public WebElement reports;

    @FindBy (xpath = "(//span[@class='text'])[3]")
    public WebElement articles;

    @FindBy (xpath = "//*[text()='Year']")
    public WebElement yearReports;

    @FindBy (xpath = "//*[text()='Last Month']")
    public  WebElement lastMonthReports;

    @FindBy (xpath = "//*[text()='This Month']")
    public WebElement thisMonthReports;

    @FindBy (xpath = "//*[text()='Last 7 Days']")
    public WebElement lastSevenDaysReports;

    @FindBy (xpath = "//div[@class='inside chart-with-sidebar']//li")
    public List<WebElement> salesNumbersList;

    @FindBy (xpath = "//input[@name='wcfm-date-range']")
    public WebElement customDateReports;

    @FindBy (xpath = "//table[@class='month1']//tbody//tr[3]//td[4]")
    public WebElement twelveOfOctober2022;

    @FindBy (xpath = "//table[@class='month1']//tbody//tr[5]//td[5]")
    public WebElement twentySevenOfOctober2022;




}
