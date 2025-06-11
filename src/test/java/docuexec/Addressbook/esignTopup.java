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
		driver.findElement(By.partialLinkText("TopUp")).click();//click on Topup btn
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//*[@id=\"defaultBackGround\"]/div[1]/div/ul/li[4])[1]")).click();//click on Topup btn

		}
		catch (Exception e) 
		{			Thread.sleep(3000);

			driver.findElement(By.cssSelector("#defaultBackGround > div.sidebar > div > ul > li:nth-child(4) > a")).click();//click on Topup btn
		}
		Thread.sleep(5000);
		
		try 
		{			driver.findElement(By.xpath("(/html/body/div/div/div/div[1]/div/ul/li[4]/ul/li[1]/a)[1]")).click();			//click on e-signTopup button 1			

		
		}
			catch(NoSuchElementException e)
			{
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("#defaultBackGround > div.sidebar > div > ul > li.nav-item.nav-dropdown.open > ul > li:nth-child(1) > a")).click();//click on Topup btn

			}	
		try{Thread.sleep(2000);
		driver.findElement(By.partialLinkText("eSign TopUp")).click();
		}
		catch(Exception e)
		{
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#eSignTopUpId")).click();

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"paymentOptionTbody\"]/tr[1]/td[4]")).click();//click on topup btn
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"paymentOptionTbody\"]/tr[1]/td[4]/span")).click();//Topup btn click
		Thread.sleep(2000);
		driver.findElement(By.id("invoicepayBtn")).click();//pay btn click
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

	}
	public void withoutvkycEsign_topup() {
		
	}
	
	
}
