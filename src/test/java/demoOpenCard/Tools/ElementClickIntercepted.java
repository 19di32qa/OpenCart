package demoOpenCard.Tools;

import org.openqa.selenium.WebElement;

public class ElementClickIntercepted {
    private static int num =0;
    public void clickRecursively(WebElement element,int max) {
        if (max>num) {
            try {
                element.click();
            } catch (Exception InvalidOperationException) {
                clickRecursively(element, num++);
            }
        }
    }
}
