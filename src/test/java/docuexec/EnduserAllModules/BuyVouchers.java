package docuexec.EnduserAllModules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(MyTestListener.class)
public class BuyVouchers extends Baseclass {

	int time =2000;
	@Test
	public void samevouchers() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		testLogin();
		// Initialize WebDriverWait
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));		
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[8]/div/div[1]")).click();//click on vouchers
		try {Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div/ul/li[10]")).click();//clickon Buyvouchers
		Thread.sleep(3000);
		}
	catch(Exception e) {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Buy Vouchers")).click();//click on Buyvouchers
		Thread.sleep(3000);
	   }
		Thread.sleep(time);
		driver.findElement(By.xpath("//*[@id=\"subCard0\"]/div[4]/button")).click();//buy voucher button
		Thread.sleep(time);
		driver.findElement(By.id("voucherQnty")).sendKeys("1");//Enter no of vouchers code
		driver.findElement(By.id("exampleSelect")).click();//
		WebElement selectcode = driver.findElement(By.id("exampleSelect"));
		Select s=new Select(selectcode);
		s.selectByVisibleText("Same Voucher Code");//VoucherType
		driver.findElement(By.id("userCodeCheckbox")).click();
		driver.findElement(By.id("userCodeVouch")).sendKeys("UIOUOqUILK");//ALPHANUMERICcase
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div/div[3]/div[1]")).click();//submit button
		Thread.sleep(3000);
		try{Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='PayBtn buttonHover']//span)[1]")).click();//pay button 
		}
		catch(Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"invoicepayBtn\"]")).click();//pay button
			}			
		Thread.sleep(6000);
		//Request initiated successfully
		  WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
		    String message = Emessage.getText().trim();

		    // Check if the message contains the specific text and extract it
		    String successMessage = message.contains("Request initiated successfully") ? 
		                            "Request initiated successfully" : 
		                            message;

		    System.out.println(successMessage);
		 // Assertion to check if the success message is as expected
		    String expectedSuccessMessage = "Request initiated successfully";
		   
		    softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG
		     Thread.sleep(2000);
		  // Click OK on the message
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();//press ok button for the model
				softAssert.assertAll();
				testLogout();

		}
	
	
	public void topUp() {
		driver.findElement(By.xpath("(//div[@class='sidebar-item']//div)[1]")).click();
	}
	
	//Click Subscription topup feature under Topup
	public void subscriptionTopUpClick() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='eSign TopUp']/following-sibling::a")).click();
	}
	
	@Test
	public void differentVouchers() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		testLogin();
		// Initialize WebDriverWait
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));		
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[8]/div/div[1]")).click();//click on vouchers
		try {Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div/ul/li[10]")).click();//clickon Buyvouchers
		Thread.sleep(3000);
		}
	catch(Exception e) {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Buy Vouchers")).click();//click on Buyvouchers
		Thread.sleep(3000);
	   }
		Thread.sleep(time);
		driver.findElement(By.xpath("//*[@id=\"subCard0\"]/div[4]/button")).click();//buy voucher button
		Thread.sleep(time);
		driver.findElement(By.id("voucherQnty")).sendKeys("1");//Enter no of vouchers code
		driver.findElement(By.id("exampleSelect")).click();//			
		driver.findElement(By.xpath("//*[@id=\"exampleSelect\"]")).click();//click on dropdown
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"exampleSelect\"]/option[2]")).click();//click on different voucher code
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div/div[3]/div[1]")).click();//submit button
		Thread.sleep(3000);
		try{Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='PayBtn buttonHover']//span)[1]")).click();//pay button 
		}
		catch(Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"invoicepayBtn\"]")).click();//pay button
			}			
		Thread.sleep(6000);
		//Request initiated successfully
		  WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
		    String message = Emessage.getText().trim();

		    // Check if the message contains the specific text and extract it
		    String successMessage = message.contains("Request initiated successfully") ? 
		                            "Request initiated successfully" : 
		                            message;

		    System.out.println(successMessage);
		 // Assertion to check if the success message is as expected
		    String expectedSuccessMessage = "Request initiated successfully";
		   
		    softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG
		     Thread.sleep(2000);
		  // Click OK on the message
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();//press ok button for the model
				softAssert.assertAll();
				testLogout();
	}

	//this method is for registered user already having a plan
	@Test
	public void Vouchersummary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(3000);

		testLogin();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[8]/div/div[1]"))).click(); // click on vouchers
		Thread.sleep(2000);
		
		
		 driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[8]/div/div[2]/a[2]")).click();
	
		 Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"voucherCodesInfo\"]"))).click(); // click voucher codes

			String voucherCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"voucherCodeModalContainer\"]/div/div[4]/div/div[2]"))).getText();


			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"voucherSummaryContainer\"]/div[3]/div/div[3]/div[2]/span"))).click(); // click export button

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"voucherSummaryContainer\"]/div[3]/div/div[3]/div[1]/span"))).click(); // click ok button

			topUp(); // clicks the topUp in sidebar
			subscriptionTopUpClick(); // clicks the subscription topup under topup in sidebar

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("redeemVoucherCode"))).sendKeys(voucherCode); // enter voucher

			wait.until(ExpectedConditions.elementToBeClickable(By.id("redeemVouch"))).click(); // click redeem
			Thread.sleep(3000);
			Thread.sleep(3000);

			WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
			String message = Emessage.getText().trim();


		String successMessage = message.contains("Already have an upcoming plan. Purchasing another plan is not allowed at this time")
				? "Already have an upcoming plan. Purchasing another plan is not allowed at this time"
				: message;

		System.out.println(successMessage);

		String expectedSuccessMessage = "Already have an upcoming plan. Purchasing another plan is not allowed at this time";

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(successMessage, expectedSuccessMessage);

		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton.click();

		softAssert.assertAll();

		testLogout(); // make logout
	}

	//this method automates buying voucher for a new user
	@Test
	public void newUserVouchersummary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		Thread.sleep(3000);

		testLogin();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[8]/div/div[1]"))).click(); // click on vouchers
		Thread.sleep(2000);

		WebElement Scroll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sidebar-children']//a)[2]")));
		Scroll.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down by 100 pixels
		js.executeScript("window.scrollBy(0, 1000)");

		Point Destination;
		try {
			Destination = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Voucher Summary"))).getLocation();
		} catch (Exception e) {
			Destination = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div/ul/li[9]/ul/li[2]/a"))).getLocation();
		}

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0," + Destination + ")");

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 100)");

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Voucher Summary"))).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[8]/div/div[2]/a[2]"))).click();
		}

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"voucherCodesInfo\"]"))).click(); // click voucher codes

		String voucherCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"voucherCodeModalContainer\"]/div/div[4]/div/div[2]"))).getText();


		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"voucherSummaryContainer\"]/div[3]/div/div[3]/div[2]/span"))).click(); // click export button

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"voucherSummaryContainer\"]/div[3]/div/div[3]/div[1]/span"))).click(); // click ok button

		topUp(); // clicks the topUp in sidebar
		subscriptionTopUpClick(); // clicks the subscription topup under topup in sidebar

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("redeemVoucherCode"))).sendKeys(voucherCode); // enter voucher

		wait.until(ExpectedConditions.elementToBeClickable(By.id("redeemVouch"))).click(); // click redeem
		Thread.sleep(3000);
		Thread.sleep(3000);

		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
		String message = Emessage.getText().trim();

		String successMessage = message.contains("Voucher redeemed successfully.")
				? "Voucher redeemed successfully."
				: message;

		System.out.println(successMessage);

		String expectedSuccessMessage = "Voucher redeemed successfully.";

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(successMessage, expectedSuccessMessage);

		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton.click();

		softAssert.assertAll();

		testLogout(); // make logout
	}

//	
	
}
