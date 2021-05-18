package opensourcedemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;//to declare as globally
    @Before
    public void setUp() {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/\n";


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");//learn by heart
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//it will wait to load browser
        driver.get(baseUrl);
    }
    @Test
    public void veryFySignInformation() {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        String expectedWelcomeMessage = "Welcome paul";
        WebElement welcomeMessage = driver.findElement(By.id("welcome"));
        String actualWelcomeMessage = welcomeMessage.getText();
        Assert.assertEquals("welcome message is correct", expectedWelcomeMessage, actualWelcomeMessage);

    }
    @Test
    public void veriFyMessageAfterLogout(){
        String expectedLogoutMessage= "Login Panel";
        WebElement logoutPanel = driver.findElement(By.id("logInPanelHeading"));
        String actualLogoutMessage= logoutPanel.getText();
        Assert.assertEquals("User logout successfully", expectedLogoutMessage,actualLogoutMessage);
    }
    @After
    public void tearDown(){
        driver.quit();
    }





}


//Homework – 4
//https://opensource-demo.orangehrmlive.com/
//( Username : Admin | Password : admin123 )
//Enter username
//Enter password
//Click login
//Verify that the text “Welcome Paul”
//After Paul one symbol there so click on symbol for logout.
//Verify that the below text.
//LOGIN Panel