package docuexec.Addressbook;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	static WebDriver driver;
    public String uaturl="https://uat.docuexec.com/login";   
    public String produrl;
    public String dc="https://docuxecstage.finfotech.co.in/login";
    public String p2pl="https://p2puat.finfotech.co.in/login";
    public String Stagingurl="https://docuxecstage.finfotech.co.in/login";
    String username = "8999999999"//9011901190on uat///6011601160staging
    		+ "";//"8182818282";//"8081808180";  // Replace with your username//6380695905
    String password = "Test@123";//Replace with your Password
    String profilemail="thiya@gmail.com";//provide profile mail id to perform Third party signing
    String otp="654321";
    String name="lavanyaa";
    String mail="lavanyab401@gmail.com";
    String mob="6374899399";
    String wotp="654321";
    String vouchercode="uatst00004";//Enter Voucher Code 
    String filePath="C:\\Users\\lavanyab.FINFOTECH\\Downloads\\Statement finvu.pdf";//Replace File path
    String tdate="11-11-2024";
    String bulksigningpdffile="C:\\Users\\lavanyab.FINFOTECH\\Desktop\\Docu Exec\\bulkSigningPDF.pdf";
    String bulksigningcsvfile="C:\\Users\\lavanyab.FINFOTECH\\Desktop\\Docu Exec\\bulkSigningUpload.csv";
    String bulksigningHTMLfile="C:\\Users\\lavanyab.FINFOTECH\\Desktop\\Docu Exec\\BulkSigningHTML\\code of conduct (3).html";
    String bulksigningHTMLcsvfile="C:\\Users\\lavanyab.FINFOTECH\\Desktop\\Docu Exec\\BulkSigningHTML\\bulkSigningUpload (1).csv";
    
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
            // Open the URL
            driver.get(Stagingurl);

            // Wait until the username field is present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='emailMobile'])[1]")));// Adjust the locator as needed
            WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='password'])[1]")));  // Adjust the locator as needed

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            Thread.sleep(2000);

            // Find and click the Login button
            WebElement LoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/button")));  // Adjust the locator as needed
            LoginButton.click();

            Thread.sleep(2000);
            
            WebElement userProfileImage = driver.findElement(By.xpath("//span[@class='userProfile hoverclass']//img[1]"));
            userProfileImage.isDisplayed();
//            Assert.assertTrue(profileHeader.isDisplayed(), "Profile page header is not displayed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
		}
    
    public void scroll(String untilPath) {
	    // Using JavascriptExecutor to scroll until the element with the specified text is visible
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[contains(text(),'" + untilPath + "')]")));
	}
    @Test
	public void testLogout()throws Exception 
	{
//    	Thread.sleep(2000);
//		driver.navigate().to(Stagingurl + "/accountInfo");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/span[1]/div/button")).click();//click on name
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/span[1]/div/div/button[2]")).click();//click on login

	}
    @AfterClass
    public void close()throws Exception
    {
    Thread.sleep(2000);
    driver.close();
   
    }
    
}
