import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
 
	private WebDriver driver;
	private WebDriverUtils utils;
	
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	
	private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");
    
    
    
    /**
     * Constructor
     * @param driver
     */
    public LoginPage(WebDriver driver) {
    	this.driver=driver;
    	this.utils=new WebDriverUtils(driver);
    }
    
    
    /**
     * Method to enter username
     * @param username
     */
    public void enterUsername(String username) {
    	utils.waitForElementToBeVisible(usernameField, 10);
    	utils.sendText(usernameField, username);
    }
	
    /**
     * Method to enter password
     * @param password
     */
    public void enterPassword(String password) {
    	utils.waitForElementToBeVisible(passwordField, 10);
    	utils.sendText(passwordField, password);
    }
    
    /**
     * Login action method
     */
    public void clickLoginButton() {
    	utils.waitForElementToBeClickable(loginButton, 10);
    	utils.clickElement(loginButton);
    }
    
    
    /**
     * This will Login
     * @param username
     * @param password
     */
    public void login(String username,String password) {
    	enterUsername(username);
    	enterPassword(password);
    	clickLoginButton();
    }
    
    
    /**
     * Check for error message
     */
    public String getErrorMessage() {
    	utils.waitForElementToBeVisible(errorMessage, 10);
    	return driver.findElement(errorMessage).getText();
    }
    
        
    
}
