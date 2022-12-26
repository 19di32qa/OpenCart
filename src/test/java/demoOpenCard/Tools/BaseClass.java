package demoOpenCard.Tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    public WebDriver  driver;
    public Logger logger = LoggerFactory.getLogger(BaseClass.class);

    @BeforeTest
    public void deleteScreens() throws IOException {
        File directory = new File("C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\Screens");
        FileUtils.cleanDirectory(directory);
    }

    @BeforeClass
    public void SetUp() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Webdriver is started");
    }
//    @AfterClass
//    public void TearDown() {
//        driver.close();
//    }
    @AfterMethod
    public void Screens(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            SnapShot snapShot = new SnapShot();
            snapShot.takeSnapShot(driver,"C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\Screens\\"+result.getName()+Math.random()*2+".png");
        }
    }

    public void getPage(String string) {
        driver.navigate().to(string);
    }
}
