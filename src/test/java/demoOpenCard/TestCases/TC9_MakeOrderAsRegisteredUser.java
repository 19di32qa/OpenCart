package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Customer.*;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.ElementClickIntercepted;
import dev.failsafe.TimeoutExceededException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC9_MakeOrderAsRegisteredUser extends BaseClass {
    @Test
    public void MakeOrderTest() {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.getPage();
        TopNavBar topNavBar = new TopNavBar(driver);
        topNavBar.getMyAccount().click();
        topNavBar.getLoginPage().click();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.BaseLogin();
        customerLoginPage.validLogin();

        dashboard.getPage();
        Featured featured = new Featured(driver);
        String elementToBuy = "iPhone";
        featured.getElement(elementToBuy).click();
        Product product = new Product(driver);
        product.getAddBtn().click();
        goToCheckout();
        Checkout checkout = new Checkout(driver);
        checkout.shippingMethodBtnClick();
        checkout.getShippingMethod().click();
        checkout.getShippingMethodOption().click();
        checkout.getPaymentMethod().click();
        checkout.getPaymentOption().click();
        ElementClickIntercepted elementClickIntercepted = new ElementClickIntercepted();
        elementClickIntercepted.clickRecursively(checkout.getConfirmOrderBtn(),5);
        checkResult();
    }
    public void checkResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()=\"Your order has been placed!\"]")));
        Assert.assertTrue(element.isDisplayed());
    }
    public void goToCheckout() {
        try {
            HeaderCart headerCart = new HeaderCart(driver);
            headerCart.openHeadCart();
            headerCart.clickCheckout();
        }catch (TimeoutException n) {
            System.out.println("Test1");
            goToCheckout();
        }
    }


}
