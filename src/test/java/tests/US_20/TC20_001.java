package tests.US_20;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.MyAccountPage;
import pages.ReviewsPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;


public class TC20_001 {
    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    CouponPage couponPage;
    ReviewsPage reviewsPage;
    Actions actions;

    @Test
    public void testReviews() {

        myAccountPage = new MyAccountPage();
        storeManagerPage = new StoreManagerPage();
        couponPage = new CouponPage();
        reviewsPage = new ReviewsPage();
        actions = new Actions(Driver.getDriver());

        ReusableMethods.myAccount();
        couponPage.storeManager.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.scrollIntoView(reviewsPage.reviews);
        ReusableMethods.waitFor(2);
        reviewsPage.reviews.click();
        ReusableMethods.waitFor(2);
        reviewsPage.producReviews.click();

        ReusableMethods.scrollIntoView(storeManagerPage.products);

        //Author  basliginin altindaki tum degerleri yazdir.
        List<WebElement> author = reviewsPage.author;
        for (WebElement w : reviewsPage.author) {
            System.out.println("Author Value: " + w.getText());
        }
        //Comment  basliginin altindaki tum degerleri yazdir.
        List<WebElement> comment = reviewsPage.comment;
        for (WebElement x : reviewsPage.comment) {
            System.out.println("Coumment Value: " + x.getText());
        }


    }
}