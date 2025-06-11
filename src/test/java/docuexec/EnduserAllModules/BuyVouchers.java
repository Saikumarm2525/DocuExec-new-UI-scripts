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
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		Thread.sleep(3000);
	    driver.findElement(By.xpath("(//div[@class='sidebar-item']//div)[3]")).click();//click on vouchers
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
		driver.findElement(By.xpath("(//div[@class='getVoucher__sub']//button)[1]")).click();//buy voucher button
		Thread.sleep(time);
		driver.findElement(By.id("voucherQnty")).sendKeys("1");//Enter no of vouchers code
		driver.findElement(By.id("exampleSelect")).click();//
		WebElement selectcode = driver.findElement(By.id("exampleSelect"));
		Select s=new Select(selectcode);
		s.selectByVisibleText("Same Voucher Code");//VoucherType
		driver.findElement(By.id("userCodeCheckbox")).click();
		driver.findElement(By.id("userCode")).sendKeys(vouchercode);//ALPHANUMERICcase
		driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();//submit button
		Thread.sleep(3000);
		try{Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='PayBtn buttonHover']//span)[1]")).click();//pay button 
		}
		catch(Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"invoicepayBtn\"]")).click();//pay button
			}			
		Thread.sleep(3000);
		//Request initiated successfully
		  WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
		    String message = Emessage.getText().trim();

		    // Check if the message contains the specific text and extract it
		    String successMessage = message.contains("Request initiated successfully") ? 
		                            "Request initiated successfully" : 
		                            message;

		    System.out.println(successMessage);
		 // Assertion to check if the success message is as expected
		    String expectedSuccessMessage = "Request initiated successfully";
		   
		    softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG
		     
		  // Click OK on the message
				WebElement okButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
				okButton.click();
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

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Thread.sleep(3000);

	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sidebar-item']//div)[3]"))).click(); // click on vouchers

	    try {
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div/ul/li[10]"))).click(); // click on Buy Vouchers
	        Thread.sleep(3000);
	    } catch (Exception e) {
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Buy Vouchers"))).click(); // click on Buy Vouchers fallback
	        Thread.sleep(3000);
	    }

	    Thread.sleep(time);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='getVoucher__sub']//button)[1]"))).click(); // buy voucher button

	    Thread.sleep(time);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucherQnty"))).sendKeys("1"); // Enter no of vouchers code

	    wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleSelect"))).click(); // Click dropdown

	    WebElement selectcode = wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleSelect")));
	    Select s = new Select(selectcode);
	    Thread.sleep(3000);
	    s.selectByVisibleText("Different Voucher Code"); // VoucherType

	    Thread.sleep(2000);


	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='actionBtn']//span)[1]"))).click(); // submit button
	    Thread.sleep(3000);

	    try {
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='PayBtn buttonHover']//span)[1]"))).click(); // pay button
	    } catch (Exception e) {
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoicepayBtn\"]"))).click(); // fallback pay button
	    }

	    Thread.sleep(3000);

	    WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
	    String message = Emessage.getText().trim();

	    String successMessage = message.contains("Request initiated successfully")
	            ? "Request initiated successfully"
	            : message;

	    System.out.println(successMessage);

	    String expectedSuccessMessage = "Request initiated successfully";
	    softAssert.assertEquals(successMessage, expectedSuccessMessage); // assertion

	    WebElement okButton = wait.until(ExpectedConditions
	            .elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
	    okButton.click();

	    softAssert.assertAll();
	    testLogout();
	}

	@Test
	public void Vouchersummary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(3000);

		testLogin();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sidebar-item']//div)[3]"))).click(); // click on vouchers
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
					By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div/ul/li[9]/ul/li[2]/a"))).click();
		}

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')]//button)[1]"))).click(); // click voucher codes

		String voucherCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='vouchercodeLists']//div)[3]"))).getText();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Export']"))).click(); // click export button

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='OK']"))).click(); // click ok button

		topUp(); // clicks the topUp in sidebar
		subscriptionTopUpClick(); // clicks the subscription topup under topup in sidebar

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("redeemVoucherCode"))).sendKeys(voucherCode); // enter voucher

		wait.until(ExpectedConditions.elementToBeClickable(By.id("redeemVouch"))).click(); // click redeem
		Thread.sleep(3000);
		Thread.sleep(3000);

		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
		String message = Emessage.getText().trim();

		String successMessage = message.contains("Already you have a plan in queue.")
				? "Already you have a plan in queue."
				: message;

		System.out.println(successMessage);

		String expectedSuccessMessage = "Already you have a plan in queue.";

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(successMessage, expectedSuccessMessage);

		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton.click();

		softAssert.assertAll();

		testLogout(); // make logout
	}

	
	@Test
	public void newUserVouchersummary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(3000);

		testLogin();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sidebar-item']//div)[3]"))).click(); // click on vouchers
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
					By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div/ul/li[9]/ul/li[2]/a"))).click();
		}

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')]//button)[1]"))).click(); // click voucher codes

		String voucherCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='vouchercodeLists']//div)[3]"))).getText();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Export']"))).click(); // click export button

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='OK']"))).click(); // click ok button

		topUp(); // clicks the topUp in sidebar
		subscriptionTopUpClick(); // clicks the subscription topup under topup in sidebar

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("redeemVoucherCode"))).sendKeys(voucherCode); // enter voucher

		wait.until(ExpectedConditions.elementToBeClickable(By.id("redeemVouch"))).click(); // click redeem
		Thread.sleep(3000);
		Thread.sleep(3000);

		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
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
