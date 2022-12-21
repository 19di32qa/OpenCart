package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDashboard {
    WebDriver driver;
    public AdminDashboard(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle() {
        System.out.println(driver.getTitle());
        return driver.getTitle();
    }
}
