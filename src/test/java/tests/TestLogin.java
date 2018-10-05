package tests;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import static org.junit.Assert.*; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import pageobjects.Login;

public class TestLogin {
private WebDriver driver;
private Login login;
 
@Before
public void setUp() throws Exception{
    driver = new FirefoxDriver();
    login = new Login(driver);
}
 
@Test
public void succeeded() throws Exception {
    login.with("tomsmith", "SuperSecretPassword!");
    assertTrue("success message not present",
            login.successMessagePresent());
}

@Test public void failed() throws Exception { 
    login.with("tomsmith", "bad password"); 
    assertTrue("failure message wasn't present after providing bogus credentials", login.failureMessagePresent()); 
}
 
@After
public void tearDown() {
    driver.quit();
}
}