package docuexec.EnduserAllModules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Reports extends Baseclass {
	@Test
	public void paymentTransactionhistory()throws Exception
	{
		SoftAssert softAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testLogin();
		driver.findElement(By.xpath("(/html/body/div/div/div[2]/div[1]/div[2]/div[5]/div)[1]")).click();//click on reports
		Thread.sleep(2000);
		driver.findElement(By.linkText("Payment History")).click();//click on paymenthistory
		WebElement paymentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//*[@id=\"paymentReportContainer\"]/div[2]/div/div[1]/div[1]/span")
			));	//wait untill payment details	
		driver.findElement(By.xpath("//*[@id=\"invoicePDFBttn\"]")).click();//download pdf
		Thread.sleep(3000);
//		driver.quit();
		
	}

	@Test
	public void transactionhistory()throws Exception
	{
		SoftAssert softAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testLogin();
	driver.findElement(By.xpath("(/html/body/div/div/div[2]/div[1]/div[2]/div[5]/div)[1]")).click();//click on reports
	Thread.sleep(2000);
	
	driver.findElement(By.linkText("Transaction History")).click();//click on transaction summary
	Thread.sleep(2000);
	for (int i = 0; i < 3; i++) {
	    try {
	        WebElement transactionDetails = wait.until(ExpectedConditions
	            .visibilityOfElementLocated(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/span")));
	        
	        String detailsText = transactionDetails.getText(); // or any interaction
	        break; // success
	    } catch (StaleElementReferenceException e) {
	        Thread.sleep(1000); // wait and retry
	    }
	}

	driver.findElement(By.xpath("//*[@id=\"summaryPDFBttn\"]")).click();//download pdf
	}
}
