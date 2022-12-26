package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    WebDriver driver;
    public Checkout(WebDriver driver) {
        this.driver = driver;
    }
    private final By shippingMethod = By.name("shipping_method");
    private final By shippingMethodOption = By.xpath("//option[text()=\"Flat Shipping Rate - $5.00\"]");
    private final By paymentMethod = By.name("payment_method");
    private final By paymentMethodOption = By.xpath("//option[text()=\"Cash On Delivery\"]");
    private final By confirmOrderBtn = By.id("button-confirm");
    private final By shippingMethodBtn = By.id("button-shipping-method");

    public void shippingMethodBtnClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(shippingMethodBtn)).click();
    }

    public WebElement getConfirmOrderBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(confirmOrderBtn));
    }

    public WebElement getPaymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(paymentMethod));
    }
    public WebElement getPaymentOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(paymentMethodOption));
    }
    public WebElement getShippingMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(shippingMethod));
    }
    public WebElement getShippingMethodOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(shippingMethodOption));
    }

}
