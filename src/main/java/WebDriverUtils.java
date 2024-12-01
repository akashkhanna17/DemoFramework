import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class will contain generic methods that are reusable
 */
public class WebDriverUtils {
    private WebDriver driver;
    
    
    /**
     * Constructor to initialize WebDriver 
     * @param driver
     */
    public WebDriverUtils(WebDriver driver) {
    	this.driver=driver;
    }
    
    
    /**
     * This method is for wait for an element to be vsisble
     * @param locator
     * @param timeoutInSeconds
     */
    public void waitForElementToBeVisible(By locator,int timeoutInSeconds) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    
    /**
     * This method is for to wait for an element to be clickable
     * @param locator
     * @param timeoutInSeconds
     */
    public void waitForElementToBeClickable(By locator,int timeoutInSeconds) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    	wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    
    /**
     * This method is for click an element with implicit wait
     */
    public void clickElement(By locator) {
    	WebElement ele = driver.findElement(locator);
    	ele.click();
    }
    
    
    /**
     * This method sends text to an element
     * @param locator
     * @param text
     */
    public void sendText(By locator,String text) {
    	WebElement ele = driver.findElement(locator);
    	ele.sendKeys(text);
    }
    
    
    /**
     * This method will handle alert pop-ups and accept the alert
     */
    public void acceptAlert() {
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    }
    
    
    /**
     * Handle alert pop-ups dismiss an alert
     */
    public void dismissAlert() {
    	Alert alert = driver.switchTo().alert();
    	alert.dismiss();
    }
    
    
    
    /**
     * @param filePath
     * This method will take schreenshot
     */
    public void takeScreenshot(String filePath) {
    	
    }
    
}
