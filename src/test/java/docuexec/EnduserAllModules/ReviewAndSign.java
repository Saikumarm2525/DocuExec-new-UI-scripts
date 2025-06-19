package docuexec.EnduserAllModules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		Thread.sleep(3000);
		// Wait for the 'Review and sign' button to be clickable
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/button[2]"))).click();;
            
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
        Finish();
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
		Thread.sleep(3000);
		// Wait for the 'Review and sign' button to be clickable
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/button[2]"))).click();;
            
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
        
        //click Discard andSign
        DiscardandSign(); 
        
//    	enterAllPage();
//    	sealpositionsdata();
		performElectronicSigning();
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
		Thread.sleep(3000);
		// Wait for the 'Review and sign' button to be clickable
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/button[2]"))).click();;
            
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
       
Thread.sleep(5000);
      driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/span")).isDisplayed();//check inbox title is displayed
		
		 }
	
	
	
	// Method to check in inbox
	private void clickInboxLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(3000);
		// Wait for the Inbox link to be clickable and click it
		WebElement inboxLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div")));
		inboxLink.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[1]")).click();//clcik documents
     Thread.sleep(3000);
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
			driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/div/div[2]/button[2]")).click();// click on preview btn
		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/div/div[2]/button[3]")).click();// click on preview btn
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button[1]")).click();// clicking
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
			driver.findElement(By.cssSelector("button.discardSign.hoverclass")).click();// click on discard
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='discardSign hoverclass']")).click();// click on discard
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button[1]")).click();
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
        driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[3]/a")).click(); // Click sidebaraccount deatils
        
	}
	public static void enterAllPage() throws Exception {
		Thread.sleep(6000);
		try {
			driver.findElement(By.cssSelector("#allPage")).click();
		} 
		catch (NoSuchElementException e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[normalize-space(text())='All pages']")).click();

		}catch (Exception e) {
			Thread.sleep(4000);

			driver.findElement(By.xpath("(//*[@id=\"allPage\"])[1]")).click();
		}
		Thread.sleep(2000);
		seal();
		handleConfirmation();

	}
	public static void seal() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"docuPageTest1\"]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.id("signaturePage")).click();// Add Seal 1
		Thread.sleep(2000);
		WebElement seal1 = driver.findElement(By.cssSelector("div[id='draggable1']"));// Drag the Seal
		int x1 = seal1.getLocation().getX();
		int y1 = seal1.getLocation().getY();
		Actions Move1 = new Actions(driver);
		// ((JavascriptExecutor) dri).executeScript("document.body.style.zoom='80%'");

		JavascriptExecutor js = (JavascriptExecutor) driver;// scrolling to below
//		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		Move1.clickAndHold(seal1).dragAndDropBy(seal1, 2, 140).perform();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		Move1.clickAndHold(seal1).dragAndDropBy(seal1, 120, 10).perform();// position the seal

		js.executeScript("window.scrollBy(0,1000)");

		Move1.clickAndHold(seal1).dragAndDropBy(seal1, 10, 10).perform();// position the seal

	}
	
	private static void handleConfirmation() throws InterruptedException {
		try {
			Thread.sleep(2000); // Small wait to allow the dialog to appear
			driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div[2]/button[2]/span")).click(); // Click
																												// OK in
																												// confirmation
		} catch (NoSuchElementException e) {
			Thread.sleep(4000);
			driver.findElement(By.className("confirmBtn")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.className("confirmBtn")).click();
		}
	}
	
	// Method to perform electronic signing actions
		private void performElectronicSigning() throws Exception {
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor) driver;// scrolling to below

			try {
				WebElement electronicModeRadio = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("electronicModeRadio")));
				electronicModeRadio.click();
			} catch (Exception e) {
				WebElement electronicModeRadioFallback = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"electronicModeRadio\"]")));
				electronicModeRadioFallback.click();
			}


			WebElement submitButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='SUBMIT']")));
			submitButton.click();

			try {
				
				WebElement checkbox=wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//*[@id=\"TandCID\"])[1]")));
				checkbox.click();
				WebElement proceed = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//span[normalize-space(text())='PROCEED']")));
				proceed.click();
			} catch (Exception e) {
				WebElement checkbox=wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//*[@id=\"TandCID\"])[1]")));
				checkbox.click();
				WebElement proceed = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//span[@class='btnLable'])[1]")));
				proceed.click();

				js.executeScript("window.scrollBy(0,-1000)");


			}
		}
		
	
}