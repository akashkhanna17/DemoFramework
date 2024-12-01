import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
   WebDriver driver;
   LoginPage loginPage;
   
   @BeforeMethod
   public void setup() {
	   driver = new ChromeDriver();
	   driver.get("https://www.saucedemo.com/");
	   loginPage=new LoginPage(driver);
   }
   
   @Test
   public void testLoginSuccess() {
	   loginPage.login("standard_user", "secret_sauce");
	   String expectedUrl = "https://www.saucedemo.com/inventory.html";
	   Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	   System.out.println("Login is successful");
   }
   
   
   @Test
   public void testLoginFailure() {
	   loginPage.login("invalid_user", "kbhbkhbhbh");
	   String errorMessage = loginPage.getErrorMessage();
	   Assert.assertTrue(errorMessage.contains("Username and password do not match"));
   }
   
   
   @AfterMethod
   public void teardown() {
	   driver.quit();
   }
   
}
