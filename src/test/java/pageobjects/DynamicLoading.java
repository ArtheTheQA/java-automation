package pageobjects;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends Base {
By startButton = By.xpath("//*[@id='start']/button");
By finishText  = By.id("finish");
 
public DynamicLoading(WebDriver driver) throws Exception{
    super(driver);
}
 
public void loadExample(String exampleNumber) throws Exception {
    driver.get("http://the-internet.herokuapp.com/dynamic_loading/" + exampleNumber);
    driver.findElement(startButton).click();
}
 
public Boolean finishTextPresent() throws Exception {
    return waitForIsDisplayed(finishText, 10);
}
 
}