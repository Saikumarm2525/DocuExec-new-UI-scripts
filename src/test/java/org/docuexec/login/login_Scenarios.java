package org.docuexec.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login_Scenarios {
	static WebDriver driver;
    public String uaturl="https://uat.docuexec.com/login";   
    public String produrl;
    public String dc="https://docuxecstage.finfotech.co.in/login";
    public String p2pl="https://p2puat.finfotech.co.in/login";
    public String Stagingurl="https://docuxecstage.finfotech.co.in/login";
//    String username = "6026602660"//9011901190on uat///6011601160staging
//    		+ "";//"8182818282";//"8081808180";  // Replace with your username//6380695905
//    String password = "Test@123";//Replace with your Password
    @BeforeClass
    public void setUp() {
        // Use WebDriverManager to handle the ChromeDriver setup
        WebDriverManager.chromedriver().setup();

        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
   @Test
    public void testLogin() {
        try {
        	// Open the application URL
        	driver.get(Stagingurl);

        	// Initialize WebDriverWait with a timeout of 10 seconds
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        	// Locate the username input field using XPath and wait until it's present
        	WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='emailMobile'])[1]")));

        	// Locate the password input field using XPath and wait until it's present
        	WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='password'])[1]")));

        	// Enter the username into the username field
        	usernameField.sendKeys("637489943");

        	// Enter the password into the password field
        	passwordField.sendKeys("Test@123");
        	
        	// Locate the visibility toggle icon
        	WebElement visibilityToggle = driver.findElement(By.xpath("(//img[@class='lock'])[2]"));

        	// Click the visibility toggle icon
        	visibilityToggle.click();

        	// Locate the login button using XPath and wait until it's clickable
        	WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(text())='login']")));

        	// Click the login button to submit the login form
        	loginButton.click();

        	// Locate the user profile image using XPath and wait until it's present
        	WebElement userProfileImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='userProfile hoverclass']//img[1]")));

        	// Click on the user profile image to open the profile menu
        	userProfileImage.click();

        	// Locate the profile details header using XPath and wait until it's present
        	WebElement profileHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Profile Details']")));

        	// Assert that the profile header is displayed to confirm successful navigation to the profile page
        	Assert.assertTrue(profileHeader.isDisplayed(), "Profile page header is not displayed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
   
   
   @Test
   public void InvalidMobileno() {
       try {
    	// Open the application URL
    	   driver.get(Stagingurl);

    	   // Initialize WebDriverWait with a timeout of 10 seconds
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	   // Locate the username input field using XPath and wait until it's present
    	   WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='emailMobile'])[1]")));

    	   // Locate the password input field using XPath and wait until it's present
    	   WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='password'])[1]")));

    	   // Enter the username into the username field
    	   usernameField.sendKeys("637489943");

    	   // Enter the password into the password field
    	   passwordField.sendKeys("Test@123");
    	// Locate the visibility toggle icon
    	   WebElement visibilityToggle = driver.findElement(By.xpath("(//img[@class='lock'])[2]"));

    	   // Click the visibility toggle icon
    	   visibilityToggle.click();

    	   // Locate the login button using XPath and wait until it's clickable
    	   WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(text())='login']")));

    	   // Click the login button to submit the login form
    	   loginButton.click();

    	   // Locate the user profile image using XPath and wait until it's present
    	   WebElement userProfileImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='userProfile hoverclass']//img[1]")));

    	   // Click on the user profile image to open the profile menu
    	   userProfileImage.click();

    	   // Locate the profile details header using XPath and wait until it's present
    	   WebElement profileHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Profile Details']")));

    	   // Assert that the profile header is displayed to confirm successful navigation to the profile page
    	   Assert.assertTrue(profileHeader.isDisplayed(), "Profile page header is not displayed.");
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           driver.quit();
       }
   }
   @Test
   public void InvalidPassword() {
       try {
           // Open the application URL
           driver.get(Stagingurl);

           // Initialize WebDriverWait with a timeout of 10 seconds
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           // Locate the username input field using XPath and wait until it's present
           WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='emailMobile'])[1]")));

           // Locate the password input field using XPath and wait until it's present
           WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='password'])[1]")));

           // Enter the username into the username field
           usernameField.sendKeys("6374899434");

           // Enter an incorrect password into the password field
           passwordField.sendKeys("WrongPassword@123");
           
        // Locate the visibility toggle icon
           WebElement visibilityToggle = driver.findElement(By.xpath("(//img[@class='lock'])[2]"));

           // Click the visibility toggle icon
           visibilityToggle.click();

           // Locate the login button using XPath and wait until it's clickable
           WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(text())='login']")));

           // Click the login button to submit the login form
           loginButton.click();

           // Wait for the error message to be visible
           WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message']")));

           // Capture the actual error message
           String actualErrorMsg = errorMessage.getText();

           // Define the expected error message
           String expectedErrorMsg = "Invalid username or password";

           // Assert that the actual error message matches the expected message
           Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message does not match the expected message.");

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   @Test
   public void WithoutUsername() {
       try {
           // Open the application URL
           driver.get(Stagingurl);

           // Initialize WebDriverWait with a timeout of 10 seconds
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           // Locate the username input field using XPath and wait until it's present
           WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='emailMobile'])[1]")));

           // Locate the password input field using XPath and wait until it's present
           WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='password'])[1]")));

           // Leave the username field empty
           usernameField.clear();

           // Enter an incorrect password into the password field
           passwordField.sendKeys("Test@123");
           
           
        // Locate the visibility toggle icon
           WebElement visibilityToggle = driver.findElement(By.xpath("(//img[@class='lock'])[2]"));

           // Click the visibility toggle icon
           visibilityToggle.click();

           // Locate the login button using XPath and wait until it's clickable
           WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(text())='login']")));

           // Click the login button to submit the login form
           loginButton.click();

           // Wait for the error message to be visible
           WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message']")));

           // Capture the actual error message
           String actualErrorMsg = errorMessage.getText();

           // Define the expected error message
           String expectedErrorMsg = "Invalid username or password";

           // Assert that the actual error message matches the expected message
           Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message does not match the expected message.");

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   @Test
   public void WithoutPassword() {
       try {
           // Open the application URL
           driver.get(Stagingurl);

           // Initialize WebDriverWait with a timeout of 10 seconds
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           // Locate the username input field using XPath and wait until it's present
           WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='emailMobile'])[1]")));

           // Locate the password input field using XPath and wait until it's present
           WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='password'])[1]")));

           // Enter a valid username into the username field
           usernameField.sendKeys("6374899434");

           // Leave the password field empty
           passwordField.clear();
           
        // Locate the visibility toggle icon
           WebElement visibilityToggle = driver.findElement(By.xpath("(//img[@class='lock'])[2]"));

           // Click the visibility toggle icon
           visibilityToggle.click();

           // Locate the login button using XPath and wait until it's clickable
           WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(text())='login']")));

           // Click the login button to submit the login form
           loginButton.click();

           // Wait for the error message to be visible
           WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message']")));

           // Capture the actual error message
           String actualErrorMsg = errorMessage.getText();

           // Define the expected error message
           String expectedErrorMsg = "Password is required";

           // Assert that the actual error message matches the expected message
           Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message does not match the expected message.");

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   @Test
   public void BothFieldsEmpty() {
       try {
           // Open the application URL
           driver.get(Stagingurl);

           // Initialize WebDriverWait with a timeout of 10 seconds
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           // Locate the username input field using XPath and wait until it's present
           WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='emailMobile'])[1]")));

           // Locate the password input field using XPath and wait until it's present
           WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='password'])[1]")));

           // Leave both fields empty
           usernameField.clear();
           passwordField.clear();
           
        // Locate the visibility toggle icon
           WebElement visibilityToggle = driver.findElement(By.xpath("(//img[@class='lock'])[2]"));

           // Click the visibility toggle icon
           visibilityToggle.click();

           // Locate the login button using XPath and wait until it's clickable
           WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(text())='login']")));

           // Click the login button to submit the login form
           loginButton.click();

           // Wait for the error message to be visible
           WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message']")));

           // Capture the actual error message
           String actualErrorMsg = errorMessage.getText();

           // Define the expected error message
           String expectedErrorMsg = "Please enter both username and password";

           // Assert that the actual error message matches the expected message
           Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message does not match the expected message.");

       } catch (Exception e) {
           e.printStackTrace();
       }
   }

}

