package docuexec.Addressbook;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class esignTopup extends Baseclass{
	
	@Test
	public void esigntopup() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		testLogin();
		// Initialize WebDriverWait
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Thread.sleep(2000);
		try {
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[4]/div/div")).click();//click on Topup btn
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[4]/div/div[2]/a[1]")).click();//click on Topup btn

		}
		catch (Exception e) 
		{			Thread.sleep(3000);

			driver.findElement(By.cssSelector("#defaultBackGround > div.sidebar > div > ul > li:nth-child(4) > a")).click();//click on Topup btn
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[4]/div/div[2]/a[1]")).click();//click on esign-Topup btn
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"rateCardTopup\"]/div[2]/div/div[2]/div/div/div/table/tbody/tr[1]/td[4]/button/img")).isEnabled();
		driver.findElement(By.xpath("//*[@id=\"rateCardTopup\"]/div[2]/div/div[2]/div/div/div/table/tbody/tr[2]/td[4]/button/img")).isEnabled();
		driver.findElement(By.xpath("//*[@id=\"rateCardTopup\"]/div[2]/div/div[2]/div/div/div/table/tbody/tr[3]/td[4]/button/img")).isEnabled();
		driver.findElement(By.xpath("//*[@id=\"rateCardTopup\"]/div[2]/div/div[2]/div/div/div/table/tbody/tr[4]/td[4]/button/img")).isEnabled();
		driver.findElement(By.xpath("//*[@id=\"rateCardTopup\"]/div[2]/div/div[2]/div/div/div/table/tbody/tr[5]/td[4]/button/img")).isEnabled();
		driver.findElement(By.xpath("//*[@id=\"rateCardTopup\"]/div[2]/div/div[2]/div/div/div/table/tbody/tr[6]/td[4]/button/img")).isEnabled();
		driver.findElement(By.xpath("//*[@id=\"rateCardTopup\"]/div[2]/div/div[2]/div/div/div/table/tbody/tr[7]/td[4]/button/img")).isEnabled();

		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')]//button)[1]")).click();//click on topup btn
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"paymentOptionTbody\"]/tr[1]/td[4]/span")).click();//Topup btn click
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div[2]/div[2]/div/span")).click();//pay btn click
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
		     
		  // Click OK on the message
				WebElement okButton = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
				okButton.click();
				softAssert.assertAll();

	}
	
	
	
}
