package pageobjects;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    protected WebDriver driver;

public Base(WebDriver driver) {
    this.driver = driver;
	}

public Boolean waitForIsDisplayed(By locator, Integer... timeout) throws Exception{ 
    try { 
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator), 
                (timeout.length > 0 ? timeout[0] : null)); 
    } catch (org.openqa.selenium.TimeoutException exception) {
         return false; 
    } return true; 
}

private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) throws Exception{
timeout = timeout != null ? timeout : 5;
WebDriverWait wait = new WebDriverWait(driver, timeout);
wait.until(condition);
}

}