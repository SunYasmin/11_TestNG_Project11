package tests.US_20;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.MyAccountPage;
import pages.ReviewsPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC20_002 {

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

        //Rating  basliginin altindaki tum degerleri yazdir.
        List<WebElement> rating = reviewsPage.rating;
        for (WebElement y : reviewsPage.rating) {
            System.out.println("Rating Value: " + y.getText());
        }
        //Dated  basliginin altindaki tum degerleri yazdir.
        List<WebElement> dated = reviewsPage.dated;
        for (WebElement z : reviewsPage.dated) {
            System.out.println("Dated Value: " + z.getText());
        }

    }
}