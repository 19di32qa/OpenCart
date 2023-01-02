package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Customer.AllLaptopPage;
import demoOpenCard.PageObjects.Customer.Dashboard;
import demoOpenCard.PageObjects.Customer.ProductComparison;
import demoOpenCard.PageObjects.Customer.TopBarForProducts;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.ElementClickIntercepted;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC16_CompareProducts extends BaseClass {

    @Test
    public void compareTwoProducts() throws InterruptedException {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.getPage();

        TopBarForProducts topBarForProducts = new TopBarForProducts(driver);
        topBarForProducts.goToLaptopsPage();

        AllLaptopPage allLaptopPage = new AllLaptopPage(driver);
        ElementClickIntercepted elementClickIntercepted = new ElementClickIntercepted();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,450)", "");
        clickRecursively(allLaptopPage.getAddToComparePage("MacBook Air"),allLaptopPage);
        //allLaptopPage.SuccessMessage();
        //allLaptopPage.getAddToComparePage("HP LP3065").click();
        clickRecursively(allLaptopPage.getAddToComparePage("MacBook"),allLaptopPage);
        //allLaptopPage.SuccessMessage();
        //allLaptopPage.getAddToComparePage("MacBook").click();
        Thread.sleep(1000);
        ProductComparison productComparison = new ProductComparison(driver);
        productComparison.getPage();
        productComparison.elementIsDisplayed("MacBook Air");

        productComparison.elementIsDisplayed("MacBook");

    }
    public void clickRecursively(WebElement element, AllLaptopPage allLaptopPage) {
            try {
                element.click();
                allLaptopPage.SuccessMessage();
            } catch (Exception InvalidOperationException) {
                clickRecursively(element,allLaptopPage);
            }
        }

}
