package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ReviewsPage {

    public ReviewsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//*[@class='text'])[16]")
    public WebElement reviews;

    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement producReviews;

    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement> author;

    @FindBy(xpath = "//tbody//tr//td[3]")
    public List<WebElement> comment;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public List<WebElement> rating;

    @FindBy(xpath = "//tbody//tr//td[6]")
    public List<WebElement> dated;

}