package docuexec.EnduserAllModules;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(MyTestListener.class)
public class PendingAction extends Baseclass {
	@Test
	public void loginAndSignDocumentsThreeTimes() throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    SoftAssert softAssert = new SoftAssert();
//
	    // Login once before signing
	    testLogin();

	    for (int i = 1; i <= 3; i++) {
	        System.out.println("----- Signing document " + i + " -----");

	        Thread.sleep(4000);
			signDocument();
			enterCurrentPage();
			performElectronicSigning();
			Thread.sleep(2000);;
	    }

	    System.out.println("=== uploaded 3 documents ===");
	    
		testLogin();
		DiscardAndSignPendingAction();
		performElectronicSigning();
		Finish();
		testLogin();
		FinishPendingAction();
		testLogin();
		DiscardPendingAction();


	}
	@Test
	public void E_DSA_PendingActionOnCurrentPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
		performElectronicSigning();
		Thread.sleep(5000);
		DiscardAndSignPendingAction();
//		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void E_DSA_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
		Thread.sleep(5000);
		performElectronicSigning();
		Thread.sleep(2000);
		DiscardAndSignPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void E_DSA_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
		performElectronicSigning();
		Thread.sleep(4000);
		DiscardAndSignPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void O_DSA_PendingActionOnCurrentPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
		performOtpSigning();
		Thread.sleep(2000);
		DiscardAndSignPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void O_DSA_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
		performOtpSigning();
		Thread.sleep(2000);
		DiscardAndSignPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void O_DSA_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
		performOtpSigning();
		Thread.sleep(2000);
		DiscardAndSignPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void DSC_DSA_PendingActionOnCurrentPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
		performDSCSigning(); // Replaced with performDSCSigning
		Thread.sleep(2000);
		DiscardAndSignPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void DSC_DSA_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
		performDSCSigning(); // Replaced with performDSCSigning
		Thread.sleep(6000);
		DiscardAndSignPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void DSC_DSA_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
		performDSCSigning(); // Replaced with performDSCSigning
		Thread.sleep(2000);
		DiscardAndSignPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void E_Finish_PendingActionOnCurrentPage() throws Exception {

		testLogin();
		Thread.sleep(4000);
		signDocument();
		Thread.sleep(2000);
		enterCurrentPage();
		performElectronicSigning();
		Thread.sleep(4000);
		FinishPendingAction();

	}

	@Test
	public void E_Finish_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
		performElectronicSigning();
		Thread.sleep(4000);
		scrollDown(-500); // Scroll down the page
		Thread.sleep(4000);
		FinishPendingAction();
	}

	@Test
	public void E_Finish_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		Thread.sleep(4000);
		enterCustomPages("1,2"); // Enter specific custom pages
		performElectronicSigning();
		Thread.sleep(4000);
		FinishPendingAction();
	}

	@Test
	public void O_Finish_PendingActionOnCurrentPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage(); // Enter the current page
		performOtpSigning();
		Thread.sleep(4000);
		scrollDown(-500); // Scroll down the page
		Thread.sleep(4000);
		FinishPendingAction();
	}

	@Test
	public void O_Finish_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(5000);
		signDocument();
		enterAllPage(); // Enter all pages
		performOtpSigning();
		Thread.sleep(4000);
		scrollDown(-500); // Scroll down the page
		Thread.sleep(4000);
		FinishPendingAction();
	}

	@Test
	public void O_Finish_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2"); // Enter specific custom pages
		performOtpSigning();
		Thread.sleep(4000);
		FinishPendingAction();
	}

	@Test
	public void DSC_Finish_PendingActionOnCurrentPage() throws Exception {
		testLogin();
		Thread.sleep(4000); // Wait for login to complete
		signDocument();
		Thread.sleep(2000); // Wait for the document to be signed
		enterCurrentPage(); // Navigate to the current page
		performDSCSigning(); // Perform DSC (Digital Signature Certificate) signing
		Thread.sleep(4000); // Wait for the DSC signing to complete
		FinishPendingAction(); // Finish pending action after signing
	}

	@Test
	public void DSC_Finish_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(4000); // Wait for login to complete
		signDocument();
		enterAllPage(); // Navigate to all pages
		Thread.sleep(2000); // Wait for pages to load
		performDSCSigning(); // Perform DSC (Digital Signature Certificate) signing
		Thread.sleep(4000); // Wait for the DSC signing to complete
		FinishPendingAction(); // Finish pending action after signing
	}

	@Test
	public void DSC_Finish_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000); // Wait for login to complete
		signDocument();
		Thread.sleep(4000); // Wait for document to be signed
		enterCustomPages("1,2"); // Navigate to custom pages (e.g., pages 1 and 2)
		performDSCSigning(); // Perform DSC (Digital Signature Certificate) signing
		Thread.sleep(6000); // Wait for the DSC signing to complete
		FinishPendingAction(); // Finish pending action after signing
	}

	@Test
	public void E_Discard_PendingActionOnCurrentPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
		performElectronicSigning();
		DiscardPendingAction();
//		driver.manage().window().maximize();
//		performElectronicSigning();
//		Finish();
	}

	@Test
	public void E_Discard_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
		performElectronicSigning();
		Thread.sleep(6000);
		DiscardPendingAction();
		driver.manage().window().maximize();
		Thread.sleep(6000);
		performElectronicSigning();
		Finish();
	}

	@Test
	public void E_Discard_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
		performElectronicSigning();
		Thread.sleep(6000);
		DiscardPendingAction();
		driver.manage().window().maximize();
		performElectronicSigning();
		Finish();
	}

	@Test
	public void O_Discard_PendingActionOnCurrentPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
		performOtpSigning();
		Thread.sleep(6000);
		DiscardPendingAction();
		driver.manage().window().maximize();
		performOtpSigning();
		Finish();
	}

	@Test
	public void O_Discard_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
		performOtpSigning();
		Thread.sleep(6000);
		DiscardPendingAction();
		driver.manage().window().maximize();
		performOtpSigning();
		Finish();
	}

	@Test
	public void O_Discard_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
		performOtpSigning();
		Thread.sleep(6000);
		DiscardPendingAction();
//		driver.manage().window().maximize();
		performOtpSigning();
		Finish();
	}

	@Test
	public void DSC_Discard_PendingActionOnCurrentPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
		performDSCSigning();
		Thread.sleep(6000);
		DiscardPendingAction();
		driver.manage().window().maximize();
		performDSCSigning();
		Finish();
	}

	@Test
	public void DSC_Discard_PendingActionOnAllPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
		performDSCSigning();
		Thread.sleep(6000);
		DiscardPendingAction();
		driver.manage().window().maximize();
		performDSCSigning();
		Finish();
	}

	@Test
	public void DSC_Discard_PendingActionOnCustomPages() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
		performDSCSigning();
		Thread.sleep(6000);
		DiscardPendingAction();
		Thread.sleep(6000);
		driver.manage().window().maximize();
		performDSCSigning();
		Finish();
	}

	@Test
	public void FinishPendingAction() throws InterruptedException {




		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));

//		Thread.sleep(5000);

//		// Locate the scrollable menu bar
//		WebElement menuBar = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div")));
//
//		// Try to find the target element (may not be in view initially)
//		By pendingActionXpath = By.xpath("//a[normalize-space(text())='Pending Action Inbox']");
//
//		boolean found = false;
//		int maxScrolls = 20; // to prevent infinite loops
//		int scrollAttempt = 0;
//
//		while (!found && scrollAttempt < maxScrolls) {
//			try {
//				WebElement pendingActionButton = menuBar.findElement(pendingActionXpath);
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pendingActionButton);
//				wait.until(ExpectedConditions.elementToBeClickable(pendingActionButton)).click();
//				found = true;
//			} catch (Exception e) {
//				// Scroll the menu bar horizontally or vertically depending on layout
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 50;", menuBar);
//				scrollAttempt++;
//			}
//		}
//
//		if (!found) {
//			throw new NoSuchElementException("Could not find 'Pending Action Inbox' after scrolling.");
//		} // actual
//			// ID,
//			// class,
//		By noteXpath = By.xpath(
//				"//p[contains(.,'Note: Once the action is performed successfully, the document will be moved to inbox.')]");
//
//		WebElement noteElement = wait.until(ExpectedConditions.presenceOfElementLocated(noteXpath));
//
//		if (noteElement != null && noteElement.isDisplayed()) {
//			System.out.println("âœ… Note is present and visible.");
//		} else {
//			System.out.println("â�Œ Note is not present.");
//		} // or
//			// XPath
		Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div")).click();//click on inbox
driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[2]")).click();//click on documents

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

		// Additional assertions can be added here to verify the actions
		// For example, check if the action leads to the expected page or result
		Finish();

	}

	@Test
	public void DiscardAndSignPendingAction() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));

//		Thread.sleep(5000);

//		// Locate the scrollable menu bar
//		WebElement menuBar = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div")));
//
//		// Try to find the target element (may not be in view initially)
//		By pendingActionXpath = By.xpath("//a[normalize-space(text())='Pending Action Inbox']");
//
//		boolean found = false;
//		int maxScrolls = 20; // to prevent infinite loops
//		int scrollAttempt = 0;
//
//		while (!found && scrollAttempt < maxScrolls) {
//			try {
//				WebElement pendingActionButton = menuBar.findElement(pendingActionXpath);
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pendingActionButton);
//				wait.until(ExpectedConditions.elementToBeClickable(pendingActionButton)).click();
//				found = true;
//			} catch (Exception e) {
//				// Scroll the menu bar horizontally or vertically depending on layout
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 50;", menuBar);
//				scrollAttempt++;
//			}
//		}
//
//		if (!found) {
//			throw new NoSuchElementException("Could not find 'Pending Action Inbox' after scrolling.");
//		} // actual
//			// ID,
//			// class,
//		By noteXpath = By.xpath(
//				"//p[contains(.,'Note: Once the action is performed successfully, the document will be moved to inbox.')]");
//
//		WebElement noteElement = wait.until(ExpectedConditions.presenceOfElementLocated(noteXpath));
//
//		if (noteElement != null && noteElement.isDisplayed()) {
//			System.out.println("âœ… Note is present and visible.");
//		} else {
//			System.out.println("â�Œ Note is not present.");
//		} // or
//			// XPath
		Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div")).click();//click on inbox
driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[2]")).click();//click on documents

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

		// Additional assertions can be added here to verify the actions
		// For example, check if the action leads to the expected page or result
		DiscardandSign();

	}

	@Test
	public void DiscardPendingAction() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));

//		Thread.sleep(5000);

//		// Locate the scrollable menu bar
//		WebElement menuBar = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div")));
//
//		// Try to find the target element (may not be in view initially)
//		By pendingActionXpath = By.xpath("//a[normalize-space(text())='Pending Action Inbox']");
//
//		boolean found = false;
//		int maxScrolls = 20; // to prevent infinite loops
//		int scrollAttempt = 0;
//
//		while (!found && scrollAttempt < maxScrolls) {
//			try {
//				WebElement pendingActionButton = menuBar.findElement(pendingActionXpath);
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pendingActionButton);
//				wait.until(ExpectedConditions.elementToBeClickable(pendingActionButton)).click();
//				found = true;
//			} catch (Exception e) {
//				// Scroll the menu bar horizontally or vertically depending on layout
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 50;", menuBar);
//				scrollAttempt++;
//			}
//		}
//
//		if (!found) {
//			throw new NoSuchElementException("Could not find 'Pending Action Inbox' after scrolling.");
//		} // actual
//			// ID,
//			// class,
//		By noteXpath = By.xpath(
//				"//p[contains(.,'Note: Once the action is performed successfully, the document will be moved to inbox.')]");
//
//		WebElement noteElement = wait.until(ExpectedConditions.presenceOfElementLocated(noteXpath));
//
//		if (noteElement != null && noteElement.isDisplayed()) {
//			System.out.println("âœ… Note is present and visible.");
//		} else {
//			System.out.println("â�Œ Note is not present.");
//		} // or
//			// XPath
		Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div")).click();//click on inbox
driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[6]/div/div[2]/a[2]")).click();//click on documents

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

		// Additional assertions can be added here to verify the actions
		// For example, check if the action leads to the expected page or result
		Discard();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[7]/div/button[3]/span[1]/img")).click();
		

	}

	public void signDocument() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//			Thread.sleep(3000);
//			// Click on the "Sign Document" button
//			WebElement signDocumentButton = wait
//					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Sign Document']")));
//			signDocumentButton.click();

			Thread.sleep(2000);
			// Click on the "Upload PDF" button
			try{
				Thread.sleep(2000);
				WebElement uploadPdfButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[4]/div/button)[1]")));
			uploadPdfButton.click();
			Thread.sleep(2000);}
			
			catch(NoSuchElementException Exception){
				Thread.sleep(2000);
				WebElement uploadPdfButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.cssSelector("#defaultBackGround > div.ContentPageWithFooter > div.ContentPage > div > div.UploadBody > div.fileUploadParent > div > div.dropInfo > div.UplPDFImgBtn > div > button")));
			uploadPdfButton.click();
			Thread.sleep(2000);}

			// Use AutoIt to handle the file upload dialog
			// Replace with the correct path to your AutoIt script
			
			Thread.sleep(2000);
			uploadFile(filePath);
			Thread.sleep(2000);

			// Click on the "Sign by me" button
			WebElement signByMeButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(text())='Sign by me']")));
			signByMeButton.click();

			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error signing the document: " + e.getMessage());
		}
	}


	private void uploadFile(String filePath) {
		try {
			Thread.sleep(2000);
			// Set the clipboard with file location
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Create a new Robot instance
			Robot robot = new Robot();

			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press ENTER
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Wait for the upload to complete
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void enterCustomPages(String pages) throws Exception {
		Thread.sleep(4000);
		try {
			driver.findElement(By.xpath("//button[normalize-space(text())='Custom pages']")).click();
		} catch (NoSuchElementException e) {
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#customPage")).click();

		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[text()='All pages']/following-sibling::button)[2]")).click();

		}
		Thread.sleep(2000);
		WebElement customPageTextField = driver.findElement(By.id("range-fieldIdAdd")); // Replace with actual ID
		customPageTextField.clear();
		customPageTextField.sendKeys(pages);
		Thread.sleep(2000);
		WebElement AddButton = driver.findElement(By.id("addCustomBtn"));
		// Replace with actual ID of the submit button
		AddButton.click();
		Thread.sleep(3000);
		seal();
		Thread.sleep(2000);
		handleConfirmation();

	}

	public static void enterCurrentPage() throws Exception {
		Thread.sleep(8000);
		try {
			driver.findElement(By.xpath(
					"//button[normalize-space(text())='Current page']"))
					.click();
		} catch (Exception e) {
			Thread.sleep(4000);

			driver.findElement(By.cssSelector("#append")).click();
		}
		Thread.sleep(2000);
		seal();
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

	public static void changeSignature() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement signaturePadBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signaturePadBtn\"]")));
		signaturePadBtn.click();

		// Wait until the home tab is clickable and click it
		WebElement homeTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-home-tab\"]")));
		homeTab.click();

		// Wait until the radio button is clickable and click it
		WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rd4\"]")));
		radioButton.click();

		// Wait until the adopt upload button is clickable and click it
		WebElement adoptUploadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("adoptUploadBtn")));
		adoptUploadBtn.click();
	}

	private static void handleConfirmation() throws InterruptedException {
		try {
			Thread.sleep(2000); // Small wait to allow the dialog to appear
			driver.findElement(By.xpath("(//button[@type='button']//span)[2]")).click(); // Click
																							// OK in
																							// confirmation
		} catch (NoSuchElementException e) {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[normalize-space(text())='Yes']")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(@class,'ant-btn css-cg4vza')]//span)[2]")).click();
		}
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
		Move1.clickAndHold(seal1).dragAndDropBy(seal1, 120, 110).perform();// position the seal

		js.executeScript("window.scrollBy(0,1000)");

		Move1.clickAndHold(seal1).dragAndDropBy(seal1, 2, 2).perform();// position the seal

	}

	@Test
	public static void performOtpSigning() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("otpSignModeRadio")).click();
		driver.findElement(By.id("generateOtpBtn")).click();// generate OTP
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='mb-3 input-group']//input)[1]")).sendKeys("654321");// mobile otp enter
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='mb-3 input-group']//input)[2]")).sendKeys("654321");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;// scrolling to below

		js.executeScript("window.scrollBy(0,1000)");
		WebElement CancelButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Cancel']")));
		CancelButton.click();

		driver.findElement(By.id("generateOtpBtn")).click();// generate OTP
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"otpmodalrow\"]/div[1]/input")).sendKeys("654321");// mobile otp enter
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"otpmodalrow\"]/div[2]/input")).sendKeys("654321");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,1000)");
		WebElement ProceedButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Proceed']")));
		ProceedButton.click();

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
		
	// Method to perform DSC signing actions
		private void performDSCSigning() throws Exception {
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor) driver;// scrolling to below

			js.executeScript("window.scrollBy(0,1000)");
			try {
				WebElement dscModeRadio = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("selfDscTokenModeRadio")));
				dscModeRadio.click();
			} catch (Exception e) {
				WebElement dscModeRadioFallback = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"selfDscTokenModeRadio\"])[1]")));
				dscModeRadioFallback.click();
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
		private void performAadharSigning() throws Exception {
		    Thread.sleep(2000);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    JavascriptExecutor js = (JavascriptExecutor) driver;  // Scrolling down

		    // Scroll down the page
		    js.executeScript("window.scrollBy(0,1000)");

		    try {
		        // Wait for Aadhar mode radio button to be clickable and click it
		        WebElement AadharModeRadio = wait.until(ExpectedConditions.elementToBeClickable(By.id("aadhaarModeRadio")));
		        AadharModeRadio.click();
		    } catch (Exception e) {
		        // Fallback case for clicking the Aadhar mode radio button using XPath
		        WebElement AadharModeRadioFallback = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"aadhaarModeRadio\"])[1]")));
		        AadharModeRadioFallback.click();
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
		    
		    Thread.sleep(60000);
		}

	private void scrollDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	// Method to click Finish button
	private void clickFinishButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement completeSigningBtn = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.finishSign.hoverclass")));
			completeSigningBtn.click(); // click on Finish
		} catch (NoSuchElementException e) {
			try {
				WebElement completeSigningBtnXPath = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='finishSign hoverclass']")));
				completeSigningBtnXPath.click(); // click on Finish
			} catch (NoSuchElementException ex) {
				WebElement alternativeFinishBtn = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='furturAction']//button)[1]")));
				alternativeFinishBtn.click(); // click on Finish
			}
		}
		Thread.sleep(4000);
		scroll("The signed document can be downloaded from this page, or from the Inbox later.");
	}

	// Method to check in inbox
	private void clickInboxLink() throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the Inbox link to be clickable and click it
		WebElement inboxLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Inbox")));
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

	// Method signature details
	private void sealpositionsdata() throws Exception {
		Thread.sleep(5000);
		// click i button
		driver.findElement(By.cssSelector("#signPageSelectDiv > div.item-text > svg")).click();
		Thread.sleep(2000);
		// Click Cancel button
		driver.findElement(By.cssSelector("body > div:nth-child(8) > div > div > div > button > svg")).click();
	}

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

	@Test
	public void Finish() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver; // scrolling to below
		js.executeScript("window.scrollBy(0,-10000)");
		Thread.sleep(3000);

		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/div/div[2]/button[1]")).click(); // click on Finish
		} catch (NoSuchElementException e) {
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='finishSign hoverclass']")).click(); // click on Finish
			} catch (NoSuchElementException ex) {
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@class='furturAction']//button)[1]")).click(); // click
																														// on
																														// Finish
			}
		}
		Thread.sleep(4000);
//		scroll("The signed document can be downloaded from this page, or from the Inbox later.");
		driver.findElement(By.xpath("//*[@id=\"multipplMsg\"]")).isDisplayed();
	}

	@Test
	public void Discard() throws Exception {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;// scrolling to below
		js.executeScript("window.scrollBy(0,-700)");
		Thread.sleep(1000);
		try {
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#defaultBackGround > div.ContentPageWithFooter > div.ContentPage > div > div > div.pdfPreviewParnt > div.rpv-core__viewer > div:nth-child(1) > div.furturAction > button.discardSign.hoverclass")).click();// click on discard
		} catch (NoSuchElementException e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/div/div[2]/button[3]")).click();// click on discard
		}catch(Exception e) {
			driver.findElement(By.xpath("(//button[@type='button']/following-sibling::button)[3]")).click();
		}		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button[2]")).click();//click cancel
		Thread.sleep(3000);
		try {
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#defaultBackGround > div.ContentPageWithFooter > div.ContentPage > div > div > div.pdfPreviewParnt > div.rpv-core__viewer > div:nth-child(1) > div.furturAction > button.discardSign.hoverclass")).click();// click on discard
		} catch (NoSuchElementException e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/div/div[2]/button[3]")).click();// click on discard
		}catch(Exception e) {
			driver.findElement(By.xpath("(//button[@type='button']/following-sibling::button)[3]")).click();
		}		
		Thread.sleep(1000);

		
		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button[1]")).click();
		// click alert okk
	}


	
	
	
	
}
