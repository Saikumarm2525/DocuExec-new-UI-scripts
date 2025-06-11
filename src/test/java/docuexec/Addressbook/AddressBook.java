package docuexec.Addressbook;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddressBook extends Baseclass {

	@Test
	public void AddIndividual() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testLogin();

		// Locate the scrollable menu bar
		WebElement menuBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='userActionMenus menuBarScroll']")));

		WebElement AddressBook = driver.findElement(By.xpath("//a[normalize-space(text())='Address Book']"));
		AddressBook.click();

		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
		WebElement AddIconind = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]")));
		AddIconind.click();

		// Locate and interact with the Name text field
		WebElement nameField = driver
				.findElement(By.xpath("(//label[normalize-space(text())='Name']/following::input)[1]")); // Replace with
																											// actual
																											// locator
		nameField.sendKeys("John Doe");

		// Locate and interact with the Mobile text field
		WebElement mobileField = driver
				.findElement(By.xpath("(//label[normalize-space(text())='Mobile']/following::input)[1]")); // Replace
																											// with
																											// actual
																											// locator
		mobileField.sendKeys("8934567890");

		// Locate and interact with the Email text field
		WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Enter Email Id']")); // Replace with
																										// actual
																										// locator
		emailField.sendKeys("john.doe@example.com");

		try { // Locate and click the Submit button
			WebElement submitButton = driver.findElement(By.xpath("//span[normalize-space(text())='Submit']")); // Replace
																												// with
																												// actual
																												// locator
			submitButton.click();
		} catch (Exception e) {
			// Locate and click the Submit button
			WebElement submitButton = driver.findElement(By.cssSelector(
					"#adressBookContainer > div.modalCustomoverlay > div > div.submitDiv > div:nth-child(1) > span")); // Replace
																														// with
																														// actual
																														// locator
			submitButton.click();
		}

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
		WebElement Emessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("New contact added to address book.")
				? "New contact added to address book."
				: message;

		System.out.println(successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "New contact added to address book.";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

		// Click OK on the message
		WebElement okButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton.click();
		softAssert.assertAll();
		testLogout();

//        // Optionally, locate and click the Close button (if needed)
//        WebElement closeButton = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div[2]/button[1]")); // Replace with actual locator
//        closeButton.click(); 
//	Contact removed successfully//New contact added to address book.

	}

	@Test
	public void removeuser() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testLogin();
		// Locate the scrollable menu bar
		WebElement menuBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='userActionMenus menuBarScroll']")));

		WebElement AddressBook = driver.findElement(By.xpath("//a[normalize-space(text())='Address Book']"));
		AddressBook.click();

		Thread.sleep(3000);
		Thread.sleep(2000);

		try {
			// navigate next page
//		WebElement nextpage=driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[4]/div/div/ul/li[5]/button"));
//		nextpage.click();
			Thread.sleep(2000);
			// select the user
			WebElement selectthecontact = driver.findElement(By.xpath(
					"//*[@id=\"adressBookContainer\"]/div[3]/div/div[2]/div/div/div/table/tbody/tr[1]/td[1]/span/span[1]/input"));
			selectthecontact.click();
			// click remove button
			WebElement remove = driver.findElement(By.xpath("(//*[@id=\"removeAddbkBttn\"])[1]"));
			remove.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
			WebElement Emessage = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]")));
			String message = Emessage.getText().trim();

			// Check if the message contains the specific text and extract it
			String successMessage = message.contains("Contact removed successfully") ? "Contact removed successfully"
					: message;

			System.out.println(successMessage);
			// Assertion to check if the success message is as expected
			String expectedSuccessMessage = "Contact removed successfully";

			softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

			// Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();
			softAssert.assertAll();
		} catch (Exception e) {
			// select the user
			WebElement selectthecontact = driver
					.findElement(By.xpath("//tr[td[3][text() = '8934567890']]//input[@type='checkbox']\r\n"));
			selectthecontact.click();
			// click remove button
			WebElement remove = driver.findElement(By.xpath("(//*[@id=\"removebttn\"])[1]"));
			remove.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
			WebElement Emessage = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]")));
			String message = Emessage.getText().trim();

			// Check if the message contains the specific text and extract it
			String successMessage = message.contains("Contact removed successfully") ? "Contact removed successfully"
					: message;

			System.out.println(successMessage);
			// Assertion to check if the success message is as expected
			String expectedSuccessMessage = "Contact removed successfully";

			softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

			// Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();
			softAssert.assertAll();
		}
		testLogout();
	}

	@Test
	public void AddGroup() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testLogin();
		// Locate the scrollable menu bar
		WebElement menuBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='userActionMenus menuBarScroll']")));

		WebElement AddressBook = driver.findElement(By.xpath("//a[normalize-space(text())='Address Book']"));
		AddressBook.click();

		Thread.sleep(3000);
		Thread.sleep(2000);

		Thread.sleep(3000);
		// click add group
		WebElement AddGroup = driver.findElement(By.xpath("(//*[@id=\"addGrpBttn\"])[1]"));
		AddGroup.click();
		Thread.sleep(3000);
		// enter group name
		WebElement groupname = driver.findElement(By.xpath("//*[@id=\"grpName\"]"));
		groupname.sendKeys("Integra");
		Thread.sleep(3000);

		// click add member
		WebElement addmember = driver.findElement(By.xpath("(//*[@id=\"addButton\"])[1]"));
		addmember.click();
		Thread.sleep(3000);

		// select member
		WebElement selectuser1 = driver.findElement(By.xpath(
				"//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div/div[4]/div/div[2]/div/div/div/table/tbody/tr[1]/td[1]/span/span[1]/input"));
		selectuser1.click();
		Thread.sleep(1000);

		WebElement selectuser2 = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/div[4]/div/div[2]/div/div/div/table/tbody/tr[2]/td[1]/span/span[1]/input"));
		selectuser2.click();
		// click add button
		driver.findElement(By.xpath("(/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/button)[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
		WebElement Emessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("'Integra' created successfully.") ? "'Integra' created successfully."
				: message;

		System.out.println(successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "'Integra' created successfully.";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

		// Click OK on the message
		WebElement okButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton.click();
		softAssert.assertAll();
		testLogout();
	}

	@Test
	public void removeGroup() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testLogin();
		// Locate the scrollable menu bar
		WebElement menuBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='userActionMenus menuBarScroll']")));

		WebElement AddressBook = driver.findElement(By.xpath("//a[normalize-space(text())='Address Book']"));
		AddressBook.click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"adressBookContainer\"]/div[3]/div/div[1]/div[1]/span")));
		try {
			// navigate next page

			WebElement nextpage = driver.findElement(
					By.xpath("//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[4]/div/div/ul/li[5]/button"));
			nextpage.click();
			Thread.sleep(2000);
			// select integra grp
			driver.findElement(
					By.xpath("(//td[text()='Integra']/preceding-sibling::td[1]//input[@type='checkbox'])[1]")).click();

			Thread.sleep(2000);
			// click on Delete
			driver.findElement(By.xpath("(//*[@id=\"removeAddbkBttn\"])[1]")).click();
			// Group deleted successfully

			driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
			WebElement Emessage = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]")));
			String message = Emessage.getText().trim();

			// Check if the message contains the specific text and extract it
			String successMessage = message.contains("Group deleted successfully") ? "Group deleted successfully"
					: message;

			System.out.println(successMessage);
			// Assertion to check if the success message is as expected
			String expectedSuccessMessage = "Group deleted successfully";

			softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

			// Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();
			softAssert.assertAll();
		} catch (Exception e) {
			// select integra grp
			driver.findElement(
					By.xpath("(//td[text()='Integra']/preceding-sibling::td[1]//input[@type='checkbox'])[1]")).click();
			Thread.sleep(2000);
			// click on Delete
			driver.findElement(By.xpath("(//*[@id=\"removeAddbkBttn\"])[1]")).click();
			// Group deleted successfully

			driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
			WebElement Emessage = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]")));
			String message = Emessage.getText().trim();

			// Check if the message contains the specific text and extract it
			String successMessage = message.contains("Group deleted successfully") ? "Group deleted successfully"
					: message;

			System.out.println(successMessage);
			// Assertion to check if the success message is as expected
			String expectedSuccessMessage = "Group deleted successfully";

			softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

			// Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();
			softAssert.assertAll();
		}
		testLogout();

	}

	public void Scenario1() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testLogin();
		// Locate the scrollable menu bar
		WebElement menuBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='userActionMenus menuBarScroll']")));

		WebElement AddressBook = driver.findElement(By.xpath("//a[normalize-space(text())='Address Book']"));
		AddressBook.click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"adressBookContainer\"]/div[3]/div/div[1]/div[1]/span")));

		
		try{
			//Remove all User
        driver.findElement(By.xpath("(/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/div[3]/div/div[2]/div/div/div/table/thead/tr/th[1]/span/span[1]/input)[1]")).click();
     // click on Delete
     			driver.findElement(By.xpath("(//*[@id=\"removeAddbkBttn\"])[1]")).click();
     			// Group deleted successfully
     		// Wait for the confirmation alert to appear
     			WebElement Emessage = wait.until(
     			    ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]"))
     			);

     			// Get the text from the element
     			String message = Emessage.getText().trim();
     			System.out.println("Actual message: " + message);

     			// Expected static part of the message
     			String expectedPartialMessage = "contacts are selected, are you sure you want to delete?";

     			// Soft assertion: check if actual message contains the expected static message
     			softAssert.assertTrue(
     			    message.contains(expectedPartialMessage),
     			    "Expected message to contain: '" + expectedPartialMessage + "' but was: '" + message + "'"
     			);

     			// Click the OK button on the confirmation dialog
     			WebElement okButton = wait.until(
     			    ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='react-confirm-alert-button-group']/button[text()='OK']"))
     			);
     			okButton.click();

     			// Evaluate all soft assertions
     			softAssert.assertAll();

		}
		catch(Exception e) {
			WebElement removeButton = driver.findElement(By.xpath("(//*[@id='removeAddbkBttn'])[1]"));

			// Option 1: Using isEnabled() to check if it’s interactable
			boolean isEnabled = removeButton.isEnabled();
			System.out.println("Is button enabled? " + isEnabled);
			
		}
		// Contact Data: Each entry is a name, mobile, and email
		String[][] contactData = {
		    {"aathiv", "6026602660", "lavanyapriya0108@gmail.com"},
		    {"anil", "9090909090", "anil2@gmail.com"},
		    {"amir", "8989898818", "amir@gmail.com"},
		    {"lavanya", "6374899434", "lavanyab@integramicro.co.in"}
		};

		for (String[] contact : contactData) {
		    String name = contact[0];
		    String mobile = contact[1];
		    String email = contact[2];

		    // Click Add Icon
		    WebElement addIcon = wait.until(ExpectedConditions.elementToBeClickable(
		            By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]")));
		    addIcon.click();

		    // Fill Name
		    WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(
		            By.xpath("(//label[normalize-space(text())='Name']/following::input)[1]")));
		    nameField.sendKeys(name);

		    // Fill Mobile
		    WebElement mobileField = driver.findElement(
		            By.xpath("(//label[normalize-space(text())='Mobile']/following::input)[1]"));
		    mobileField.sendKeys(mobile);

		    // Fill Email
		    WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Enter Email Id']"));
		    emailField.sendKeys(email);

		    // Click Submit Button
		    try {
		        WebElement submitButton = driver.findElement(By.xpath("//span[normalize-space(text())='Submit']"));
		        submitButton.click();
		    } catch (Exception e) {
		        WebElement submitFallback = driver.findElement(By.cssSelector(
		                "#adressBookContainer > div.modalCustomoverlay > div > div.submitDiv > div:nth-child(1) > span"));
		        submitFallback.click();
		    }

		    // Wait and handle confirmation popup
		    WebElement messageElement = wait.until(ExpectedConditions
		            .visibilityOfElementLocated(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]")));
		    String message = messageElement.getText().trim();

		    // Validate message
		    String expectedMessage = "New contact added to address book.";
		    String actualMessage = message.contains(expectedMessage) ? expectedMessage : message;

		    System.out.println("Confirmation: " + actualMessage);
		    softAssert.assertEquals(actualMessage, expectedMessage, "Contact addition confirmation mismatch!");

		    // Click OK in confirmation
		    WebElement okButton = wait.until(ExpectedConditions
		            .elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		    okButton.click();

		    // Wait before next loop (adjust if needed)
		    Thread.sleep(2000);
		}

		// Final assertion
		softAssert.assertAll();

	}
	

}
