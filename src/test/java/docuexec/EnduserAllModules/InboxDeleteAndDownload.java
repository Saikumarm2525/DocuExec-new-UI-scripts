package docuexec.EnduserAllModules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(MyTestListener.class)
public class InboxDeleteAndDownload extends Baseclass {

	@Test
	public void Delete()throws Exception
	{
		
		SoftAssert softAssert = new SoftAssert();
		// Initialize WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		testLogin();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div"))).click(); // Wait for Inbox to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[1]"))).click();;//click on documents
        Thread.sleep(5000);
        
for(int i=0;i<=10;i++)
{
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("(//span[normalize-space(text())='Actions']/following::input)[1]")).click();
		// Wait for the delete button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/div[2]/i"))).click();

		// Wait for the confirm button to be clickable and click it
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button[1]"))).click();

		// Wait for the confirmation message to be visible and extract it
		WebElement Emessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("Document deleted") ? "Document deleted" : message;

		System.out.println("Delete inbox document: " + successMessage);

		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "Document deleted";
		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG
        Thread.sleep(2000);
		// Wait for the OK button to be clickable and click it
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='OK']")));
		okButton.click();
}
		softAssert.assertAll(); // Ensure assertions are executed

		testLogout();


	
	}
	
	

//	    @Test
//	    public void Delete() throws Exception {
//	        SoftAssert softAssert = new SoftAssert();
//	        
//	        // Initialize WebDriverWait
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	        // Log in to the application
//	        testLogin();
//	        
//	        // Navigate to Inbox
//	        driver.findElement(By.linkText("Inbox")).click();
//	        
//	        // Wait for the table to load
//	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tr[contains(@class, 'MuiTableRow-root')]")));
//
//	        // Get all rows in the inbox table
//	        java.util.List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@class, 'MuiTableRow-root')]"));
//	        
//	        WebElement latestRow = null;
//	        Date latestTimestamp = null;
//
//	        // Iterate through each row to find the one with the most recent timestamp
//	        for (WebElement row : rows) {
//	            // Extract timestamp text from the 6th column (Last Updated)
//	            String timestampText = row.findElement(By.xpath("td[6]")).getText().trim();
//
//	            // Parse the timestamp to Date object
//	            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy, h:mm:ss a");
//	            Date timestamp = sdf.parse(timestampText);
//
//	            // Update the latest timestamp and row
//	            if (latestTimestamp == null || timestamp.after(latestTimestamp)) {
//	                latestTimestamp = timestamp;
//	                latestRow = row;
//	            }
//	        }
//
//	        // If the latest document is found, click the delete button
//	        if (latestRow != null) {
//	            // Click on the delete button (assuming the delete button is in the 7th column)
//	            WebElement deleteButton = latestRow.findElement(By.xpath(".//td[7]//button[@title='Delete']"));
//	            deleteButton.click();
//
//	            // Click confirm button in the delete confirmation dialog
//	            driver.findElement(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div[2]/button[1]")).click();
//
//	            // Wait for confirmation message
//	            WebElement confirmationMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div")));
//	            String message = confirmationMessage.getText().trim();
//
//	            // Check if the message contains the expected text
//	            String successMessage = message.contains("Document deleted") ? "Document deleted" : message;
//	            System.out.println("Delete inbox document: " + successMessage);
//
//	            // Assert if the success message is as expected
//	            softAssert.assertEquals(successMessage, "Document deleted");
//
//	            // Click the OK button on the confirmation message
//	            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button")));
//	            okButton.click();
//	        } else {
//	            System.out.println("No document found to delete.");
//	        }
//
//	        // Ensure that the assertions are executed and passed
//	        softAssert.assertAll();
//
//	        // Log out from the application
//	        testLogout();
//	    }
	

	@Test
	public void Download()throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		// Initialize WebDriverWait with a 40-second timeout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		testLogin();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div"))).click(); // Wait for Inbox to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[1]"))).click();//click on documents
      
		// Wait for the Download button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[7]/div/button[1]/span[1]/img"))).click(); // Click on Download

		testLogout();

	}
	
	@Test
	public void comment()throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		// Initialize WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		testLogin();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div"))).click(); // Wait for Inbox to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[1]"))).click();//click on documents
      		Thread.sleep(2000);

		try {
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[8]/div/button/span[1]/svg"))).click();
		} catch (NoSuchElementException e) {
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[8]/div/button/span[1]"))).click(); // Wait for 3 dots button to be clickable
		} catch (Exception e) {
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"))).click(); // Wait for 3 dots button to be clickable
		}

		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td/div/div[2]/div/div[1]/span/span")).click();//click comment button
		
     WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("No comments for the document.") ? "No comments for the document."
				: message;

		System.out.println("email inbox feature:"+successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "No comments for the document.";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

     driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();//click ok button in model
	testLogout();

	
   }
	@Test
	public void Email()throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		// Initialize WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		testLogin();
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div"))).click(); // Wait for Inbox to be clickable
	       
		}
		catch (NoSuchElementException e) 
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[normalize-space(text())='Inbox']")).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//a[@class='sidebar-link'])[3]")).click();//click on Inbox
		}
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[1]"))).click();;//click on documents
	     
		Thread.sleep(2000);
		
		try {
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[8]/div/button/span[1]/svg"))).click();
		} catch (NoSuchElementException e) {
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[8]/div/button/span[1]"))).click(); // Wait for 3 dots button to be clickable
		} catch (Exception e) {
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"))).click(); // Wait for 3 dots button to be clickable
		}

		try{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td/div/div[2]/div/div[2]/span")).click();//click on email
		}
		catch (Exception e)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//img[@loading='lazy']/following-sibling::span)[2]")).click();//click on email
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[2]/div[2]/input")).sendKeys(emailid);//enter mail in To textfield
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[2]/div[3]/span")).click();//click cc field
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[3]/div[2]/input")).sendKeys(ccEmailid);//enter mailid in cc textfield
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[4]/div[2]/input")).sendKeys("signed document");//enter the subject
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[5]/div[2]/textarea")).sendKeys("document was signed ");//enter the body
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[8]/div[1]/span")).click();//click send btn
		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("Email request has been initiated successfully.") ? "Email request has been initiated successfully."
				: message;

		System.out.println("email inbox feature:"+successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "Email request has been initiated successfully.";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

//		 Click OK on the message
		WebElement okButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton.click();
		softAssert.assertAll();
		testLogout();
		}
	@Test
	public void view() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Initialize WebDriverWait with a 40-second timeout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

		testLogin();

		// Wait for the Inbox link to be clickable
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div"))).click(); // Wait for Inbox to be clickable
	           
		}
		catch (NoSuchElementException e) 
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[normalize-space(text())='Inbox']")).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//a[@class='sidebar-link'])[3]")).click();//click on Inbox
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[1]"))).click();//click on documents
		   
		// Wait for the "three dots" button to be clickable
		try {
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[8]/div/button/span[1]/svg"))).click();
		} catch (NoSuchElementException e) {
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[8]/div/button/span[1]"))).click(); // Wait for 3 dots button to be clickable
		} catch (Exception e) {
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"))).click(); // Wait for 3 dots button to be clickable
		}

		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td/div/div[2]/div/div[3]/span/span"))).click(); // Click view button
		// Wait for the back button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div[1]/button"))).click(); // Click back button

		testLogout();
;
	}

		
	
}
