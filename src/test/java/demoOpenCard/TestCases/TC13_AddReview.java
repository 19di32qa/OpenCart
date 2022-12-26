package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Customer.CustomerLoginPage;
import demoOpenCard.PageObjects.Customer.Dashboard;
import demoOpenCard.PageObjects.Customer.TopNavBar;
import demoOpenCard.PageObjects.Customer.WriteAReview;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.ElementClickIntercepted;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC13_AddReview extends BaseClass {
    @Test
    public void WriteReviewTest() throws InterruptedException {
        Dashboard dashboard= new Dashboard(driver);
        dashboard.getPage();

        TopNavBar topNavBar = new TopNavBar(driver);
        topNavBar.getMyAccount().click();
        topNavBar.getLoginPage().click();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.BaseLogin();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//i[@class=\"fas fa-home\"]"))).doubleClick().build().perform();
        ElementClickIntercepted elementClickIntercepted = new ElementClickIntercepted();
        elementClickIntercepted.clickRecursively(selectProduct(),5);

        clickWriteReview();

        WriteAReview writeAReview = new WriteAReview(driver);
        String review = "It's good but there are some problems with plying games";
        String num = "4";
        writeAReview.setText(review);
        List<WebElement> ratings = writeAReview.getRating();
        for (WebElement el:ratings) {
            if (el.getAttribute("value").equals(num)) {
                System.out.println("val");
                elementClickIntercepted.clickRecursively(el,5);
                break;
            }
        }
        elementClickIntercepted.clickRecursively(writeAReview.saveReview(),5);
        //writeAReview.saveReview();
    }
    public WebElement selectProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4//*[text()=\"MacBook\"]")));
    }
    public void clickWriteReview() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()=\"Write a review\"]"))).click();
    }
}
