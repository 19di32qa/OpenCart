package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.WebDriver;

public class Dashboard {
    private WebDriver driver;
    public String url = "http://localhost/demoOpenCard/upload/";
    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.get(url);
    }

}
