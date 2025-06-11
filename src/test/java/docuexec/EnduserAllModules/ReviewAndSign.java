package docuexec.EnduserAllModules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(MyTestListener.class)
public class ReviewAndSign extends Baseclass{

	//this method clicks review and sign and then finshes the signing 
	@Test
	public void ReviewandSignfinish() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(20)));
		SoftAssert softAssert = new SoftAssert();
		testLogin();
		
		// Wait for the 'Review and sign' button to be clickable
        WebElement reviewAndSignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button[2]")));
        reviewAndSignButton.click();
        
     // Wait for the "Sign" icon to be clickable and click on it
     		WebElement signIcon = wait.until(ExpectedConditions.elementToBeClickable(
     				By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div/div[2]/div/div[2]/div/div/div/table/tbody/tr[1]/td[6]/img"))); // Replace
     																										// with
     																										// the
     																										// actual
     																										// ID,
     																										// class,
     																										// or
     																										// XPath
     		signIcon.click();
        //click finish
//        Finish();
        //inbox
        clickInboxLink();
		
		 }
	
	
	//this method clicks review and sign and then discards and resign the signing 
	@Test
	public void ReviewandSignDiscardAndSign() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(20)));
		SoftAssert softAssert = new SoftAssert();
		testLogin();
		
		// Wait for the 'Review and sign' button to be clickable
        WebElement reviewAndSignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='primary']")));
        reviewAndSignButton.click();
     // Wait for the "Sign" icon to be clickable and click on it
     		WebElement signIcon = wait.until(ExpectedConditions.elementToBeClickable(
     				By.xpath("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')]//img)[2]"))); // Replace
     																										// with
     																										// the
     																										// actual
     																										// ID,
     																										// class,
     																										// or
     																										// XPath
     	signIcon.click();
        
        //click Discard andSign
        DiscardandSign();        //inbox
       driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[11]/a")).click();//click pending actions
     // Wait for the "Sign" icon to be clickable and click on it
 		WebElement signIcon1 = wait.until(ExpectedConditions.elementToBeClickable(
 				By.xpath("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')]//img)[2]"))); // Replace
 																										// with
 																										// the
 																										// actual
 																										// ID,
 																										// class,
 																										// or
 																										// XPath
 		signIcon1.click();
 		Finish();
 		 //inbox
        clickInboxLink();
		
 		
		 }
	
	//this method clicks review and sign and then discards the signing 
	@Test
	public void ReviewandSigndiscard() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(20)));
		SoftAssert softAssert = new SoftAssert();
		testLogin();
		
		// Wait for the 'Review and sign' button to be clickable
        WebElement reviewAndSignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button[2]")));
        reviewAndSignButton.click();
        
     // Wait for the "Sign" icon to be clickable and click on it
     		WebElement signIcon = wait.until(ExpectedConditions.elementToBeClickable(
     				By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div/div[2]/div/div[2]/div/div/div/table/tbody/tr[1]/td[6]/img"))); // Replace
     																										// with
     																										// the
     																										// actual
     																										// ID,
     																										// class,
     																										// or
     																										// XPath
     		signIcon.click();
    
            Discard();
        //inbox
        	WebElement inboxLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/a/img")));
    		inboxLink.click();
Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/span")).isDisplayed();//check inbox title is displayed
		
		 }
	
	
	
	// Method to check in inbox
	private void clickInboxLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the Inbox link to be clickable and click it
		WebElement inboxLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/a/img")));
		inboxLink.click();

		// Wait for the table row to be present
		WebElement file = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("doc_name_td")));
		String pdfname = file.getText().trim();
		System.out.println(pdfname);

		// Split the pdfname into parts and extract the filename
		String[] parts = pdfname.split(" ");
		String filename = parts[0].trim();
		System.out.println("filename: " + filename);
	}
	
	
	// Method to finish	
	public void Finish() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver; // scrolling to below
		js.executeScript("window.scrollBy(0,-10000)");
		Thread.sleep(3000);

		try {
			Thread.sleep(3000);
			driver.findElement(By.id("completeSigningBtn")).click(); // click on Finish
		} catch (NoSuchElementException e) {
			try {;
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='finishSign hoverclass']")).click(); // click on Finish
			} catch (NoSuchElementException ex) {
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@class='furturAction']//button)[1]")).click(); // click
																														// on
																														// Finish
			}
		}
	}
	
	
	// Method to DAS
	public void DiscardandSign() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;// scrolling to below
		js.executeScript("window.scrollBy(0,10000)");
		Thread.sleep(3000);
		try {
			Thread.sleep(3000);
			driver.findElement(By.id("previewSignAgainBtn")).click();// click on preview btn
		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='discardAndSign hoverclass']")).click();// click on preview btn
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button']/following-sibling::button)[2]")).click();// clicking
																												// alert
		Thread.sleep(3000);

	}

	// Method to Discard	
	public void Discard() throws Exception {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;// scrolling to below
		js.executeScript("window.scrollBy(0,-700)");
		Thread.sleep(3000);
		try {
			Thread.sleep(3000);
			driver.findElement(By.id("cancelSigningBtn")).click();// click on discard
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='discardSign hoverclass']")).click();// click on discard
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='furturAction']//button)[3]")).click();
		// click alert okk
	}
	
	
	public void testLogin() throws InterruptedException {
	     
        // Open the URL
        driver.get(Stagingurl);

        // Wait until the username field is present
        Thread.sleep(5000); // Wait for page load
        driver.findElement(By.xpath("(//input[@id='emailMobile'])[1]")).sendKeys(username); // Enter username
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(password); // Enter password
        Thread.sleep(6000); // Wait before login
        driver.findElement(By.xpath("(//div[@class='box signUp']//button)[1]")).click(); // Click login
        Thread.sleep(5000); // Wait after login
        driver.findElement(By.xpath("//a[normalize-space(text())='Account Details']")).click(); // Click sidebaraccount deatils

        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize explicit wait
			

        String text = driver.findElement(By.xpath("//span[normalize-space(text())='Current Plan']")).getText();
		Assert.assertEquals(text, "Current Plan");
		System.out.println("*************************************************");
		System.out.println("           Signs Completed status                ");
		System.out.println("*************************************************");
		System.out.println(driver.findElement(By.className("signCountStatus")).getText());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("*************************************************");
		System.out.println("           Storage used status                ");
		System.out.println("*************************************************");
		System.out.println(driver.findElement(By.className("storageCountStatus")).getText());
    
	
		
	}
	
}