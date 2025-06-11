package docuexec.EnduserAllModules;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Watermarkpdf extends Baseclass{
	@Test

	public void OcurrentDAS() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
//    	sealpositionsdata();
		performOtpSigning();
		DiscardandSign();
		performOtpSigning();
		scrollDown(50000);
		scrollDown(5000);
		scrollDown(5000);
		Finish();
//		
		Thread.sleep(2000);
		testLogout();

	}

	@Test

	public void OallDAS() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
//    	sealpositionsdata();
		performOtpSigning();
		DiscardandSign();
		performOtpSigning();
		scrollDown(50000);
		scrollDown(5000);
		scrollDown(5000);
		Finish();
//		
//		Thread.sleep(2000);
//		
		Thread.sleep(2000);
		testLogout();
	}

	@Test
	public void OcustomDAS() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
//    	sealpositionsdata();
		performOtpSigning();
		DiscardandSign();
		performOtpSigning();
		scrollDown(50000);
		scrollDown(5000);
		scrollDown(5000);
		Finish();
//		
		Thread.sleep(2000);
//		
		Thread.sleep(2000);
		testLogout();

	}

	@Test

	public void Ocurrentdiscard() throws Exception {

		testLogin();
		Thread.sleep(4000);
		signDocument();

		enterCurrentPage();
//    	sealpositionsdata();
		performOtpSigning();
		Discard();
		Thread.sleep(2000);
		testLogout();

	}

	

	@Test

	public void OAlldiscard() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
//    	sealpositionsdata();
		performOtpSigning();
		Discard();
		Thread.sleep(2000);
		testLogout();
	}
	@Test

	public void Ocustomdiscard() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
//    	sealpositionsdata();
		performOtpSigning();
		Discard();
		Thread.sleep(2000);
		testLogout();
	}

	@Test

	public void EcurentDAS() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
		// sealpositionsdata();
		performElectronicSigning();
		DiscardandSign();
		performElectronicSigning();
		scrollDown(50000);
		scrollDown(50000);
		scrollDown(50000);
		scrollDown(5000);
		scrollDown(5000);
		Finish();
				Thread.sleep(2000);
		testLogout();

	}

	@Test

	public void EallDAS() throws Exception {

		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
//    	sealpositionsdata();
		performElectronicSigning();
		DiscardandSign();
		performElectronicSigning();
		scrollDown(50000);
		scrollDown(5000);
		scrollDown(5000);
		scrollDown(5000);
		Finish();
		
		Thread.sleep(2000);
		testLogout();
	}

	@Test
	public void EcustomDAS() throws Exception {

		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
//    	sealpositionsdata();
		performElectronicSigning();
		DiscardandSign();
		performElectronicSigning();
		scrollDown(50000);
		scrollDown(5000);
		scrollDown(5000);
		Finish();
		
		Thread.sleep(2000);
		testLogout();

	}

	@Test

	public void Ecurrentdiscard() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
//    	sealpositionsdata();
		performElectronicSigning();
		Thread.sleep(2000);
		Discard();
		Thread.sleep(2000);
		testLogout();
	}

	@Test

	public void EAlldiscard() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
//    	sealpositionsdata();
		performElectronicSigning();
		Thread.sleep(2000);
		Discard();
		Thread.sleep(2000);
		testLogout();
	}

	@Test

	public void Ecustomdiscard() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
//    	sealpositionsdata();
		performElectronicSigning();
		Thread.sleep(2000);
		Discard();
		Thread.sleep(2000);
		testLogout();
	}

	@Test
	public void ETestcurrentPage() throws Exception {

		testLogin();
		Thread.sleep(4000);
		signDocument();
		Thread.sleep(2000);
		enterCurrentPage();
		performElectronicSigning();
		Thread.sleep(4000);
		scrollDown(-500);
		clickFinishButton();
		Thread.sleep(2000);
		
		testLogout();

	}

	@Test
	public void ETestAllPage() throws Exception {

		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterAllPage();
		performElectronicSigning();
		Thread.sleep(4000);
		scrollDown(-500);
		clickFinishButton();
		Thread.sleep(2000);
		
		testLogout();

	}

	@Test
	public void ETestcustomPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		Thread.sleep(4000);
		enterCustomPages("1,2");
		performElectronicSigning();
		clickFinishButton();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		testLogout();
	}

	@Test
	public void OTestcurrentPage() throws Exception {

		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCurrentPage();
		performOtpSigning();
		Thread.sleep(4000);
		scrollDown(-500);
		clickFinishButton();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		testLogout();
	}

	@Test
	public void OTestAllPage() throws Exception {

		testLogin();
		Thread.sleep(5000);
		signDocument();
		enterCurrentPage();
		performOtpSigning();
		Thread.sleep(4000);
		scrollDown(-500);
		clickFinishButton();
		Thread.sleep(2000);
		
		testLogout();

	}

	@Test
	public void OTestcustomPage() throws Exception {
		testLogin();
		Thread.sleep(4000);
		signDocument();
		enterCustomPages("1,2");
		performOtpSigning();
		Thread.sleep(4000);
		scrollDown(-500);
		clickFinishButton();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		testLogout();
	}
	@Test
	public void DScurrentDAS() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterCurrentPage();
	    // sealpositionsdata();
	    performDSCSigning();  // Replaced with performDSCSigning
	    DiscardandSign();
	    performDSCSigning();  // Replaced with performDSCSigning
	    scrollDown(50000);
	    scrollDown(50000);
	    scrollDown(50000);
	    scrollDown(5000);
	    scrollDown(5000);
	    Finish();
	    
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void DSallDAS() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterAllPage();
	    // sealpositionsdata();
	    performDSCSigning();  // Replaced with performDSCSigning
	    DiscardandSign();
	    performDSCSigning();  // Replaced with performDSCSigning
	    scrollDown(50000);
	    scrollDown(5000);
	    scrollDown(5000);
	    scrollDown(5000);
	    Finish();
	    
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void DSCcustomDAS() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterCustomPages("1,2");
	    // sealpositionsdata();
	    performDSCSigning();  // Replaced with performDSCSigning
	    DiscardandSign();
	    performDSCSigning();  // Replaced with performDSCSigning
	    scrollDown(50000);
	    scrollDown(5000);
	    scrollDown(5000);
	    Finish();
	    
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void DSCcurrentdiscard() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterCurrentPage();
	    // sealpositionsdata();
	    performDSCSigning();  // Replaced with performDSCSigning
	    Thread.sleep(2000);
	    Discard();
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void DSAlldiscard() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterAllPage();
	    // sealpositionsdata();
	    performDSCSigning();  // Replaced with performDSCSigning
	    Thread.sleep(2000);
	    Discard();
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void DSCcustomdiscard() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterCustomPages("1,2");
	    // sealpositionsdata();
	    performDSCSigning();  // Replaced with performDSCSigning
	    Thread.sleep(2000);
	    Discard();
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void DSTestcurrentPage() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    Thread.sleep(2000);
	    enterCurrentPage();
	    performDSCSigning();  // Replaced with performDSCSigning
	    Thread.sleep(4000);
	    scrollDown(-500);
	    clickFinishButton();
	    Thread.sleep(2000);
	    
	    testLogout();
	}

	@Test
	public void DSTestAllPage() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterAllPage();
	    Thread.sleep(2000);
	    performDSCSigning();  // Replaced with performDSCSigning
	    Thread.sleep(4000);
	    scrollDown(-500);
	    clickFinishButton();
	    Thread.sleep(2000);
	    
	    testLogout();
	}

	@Test
	public void DSTestcustomPage() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    Thread.sleep(4000);
	    enterCustomPages("1,2");
	    performDSCSigning();  // Replaced with performDSCSigning
	    clickFinishButton();
	    Thread.sleep(2000);
	    
	    Thread.sleep(2000);
	    testLogout();
	}
	@Test
	public void AcurrentDAS() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterCurrentPage();
	    // sealpositionsdata();
	    performAadharSigning();  // Replaced with performAadharSigning
	    DiscardandSign();
	    performAadharSigning();  // Replaced with performAadharSigning
	    scrollDown(50000);
	    scrollDown(50000);
	    scrollDown(50000);
	    scrollDown(5000);
	    scrollDown(5000);
	    Finish();
	    
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void AallDAS() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterAllPage();
	    // sealpositionsdata();
	    performAadharSigning();  // Replaced with performAadharSigning
	    DiscardandSign();
	    performAadharSigning();  // Replaced with performAadharSigning
	    scrollDown(50000);
	    scrollDown(5000);
	    scrollDown(5000);
	    scrollDown(5000);
	    Finish();
	    
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void AcustomDAS() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterCustomPages("1,2");
	    // sealpositionsdata();
	    performAadharSigning();  // Replaced with performAadharSigning
	    DiscardandSign();
	    performAadharSigning();  // Replaced with performAadharSigning
	    scrollDown(50000);
	    scrollDown(5000);
	    scrollDown(5000);
	    Finish();
	    
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void Acurrentdiscard() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterCurrentPage();
	    // sealpositionsdata();
	    performAadharSigning();  // Replaced with performAadharSigning
	    Thread.sleep(2000);
	    Discard();
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void AAlldiscard() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterAllPage();
	    // sealpositionsdata();
	    performAadharSigning();  // Replaced with performAadharSigning
	    Thread.sleep(2000);
	    Discard();
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void Acustomdiscard() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterCustomPages("1,2");
	    // sealpositionsdata();
	    performAadharSigning();  // Replaced with performAadharSigning
	    Thread.sleep(2000);
	    Discard();
	    Thread.sleep(2000);
	    testLogout();
	}

	@Test
	public void ATestcurrentPage() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    Thread.sleep(2000);
	    enterCurrentPage();
	    performAadharSigning();  // Replaced with performAadharSigning
	    Thread.sleep(4000);
	    scrollDown(-500);
	    clickFinishButton();
	    Thread.sleep(2000);
	    
	    testLogout();
	}

	@Test
	public void ATestAllPage() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    enterAllPage();
	    Thread.sleep(2000);
	    performAadharSigning();  // Replaced with performAadharSigning
	    Thread.sleep(4000);
	    scrollDown(-500);
	    clickFinishButton();
	    Thread.sleep(2000);
	    
	    testLogout();
	}

	@Test
	public void ATestcustomPage() throws Exception {
	    testLogin();
	    Thread.sleep(4000);
	    signDocument();
	    Thread.sleep(4000);
	    enterCustomPages("1,2");
	    performAadharSigning();  // Replaced with performAadharSigning
	    clickFinishButton();
	    Thread.sleep(2000);
	    
	    Thread.sleep(2000);
	    testLogout();
	}


	public void signDocument() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			Thread.sleep(3000);
			// Click on the "Sign Document" button
			WebElement signDocumentButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Sign Document']")));
			signDocumentButton.click();

			Thread.sleep(2000);
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

			clickWatermarkCheckbox();

			//click On Water mark preview button
			WebElement WatermarkPreview= wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[4]/div[2]/div/div)[1]")));
			WatermarkPreview.click();
			
			// Click on the "Sign by me" button
			WebElement signByMeButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"next-button\"]/span)[1]")));
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
	public void clickWatermarkCheckbox() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//click add water mark check box
	    WebElement watermarkCheckbox = driver.findElement(By.xpath("(//*[@id=\"WATRMRKCHEKBOX\"])[1]"));
	    if (!watermarkCheckbox.isSelected()) {
	        watermarkCheckbox.click();
	    }
	    //enter the text
	    WebElement textarea = driver.findElement(By.xpath("(//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[6]/div/textarea)[1]"));
	    textarea.clear(); // Optional: clears existing text
	    textarea.sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    
	    //click Add water mark pdf  //*[@id="defaultBackGround"]/main/div[2]/div/div[4]/div/div/div[2]/div[2]/button
	    WebElement ProceedWaterMarkButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[6]/div/div[2]/div[1])[1]")));
	    ProceedWaterMarkButton.click();
	}
	public static void enterCustomPages(String pages) throws Exception {
		Thread.sleep(4000);
		Thread.sleep(4000);

		try {
			driver.findElement(By.xpath("//button[normalize-space(text())='Custom pages']")).click();
		} catch (NoSuchElementException e) {
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#customPage")).click();

		}
		catch (Exception e) {
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
		Thread.sleep(4000);
		Thread.sleep(4000);

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
		Thread.sleep(4000);
		Thread.sleep(4000);

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
			driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button[1]")).click(); // Click
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
		Move1.clickAndHold(seal1).dragAndDropBy(seal1, 2, 240).perform();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		Move1.clickAndHold(seal1).dragAndDropBy(seal1, 320, 110).perform();// position the seal

		js.executeScript("window.scrollBy(0,1000)");

		Move1.clickAndHold(seal1).dragAndDropBy(seal1, 10, 10).perform();// position the seal

	}

	@Test
	public static void performOtpSigning() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("otpSignModeRadio")).click();
		driver.findElement(By.id("generateOtpBtn")).click();// generate OTP
		Thread.sleep(3000);
		driver.findElement(By.name("mobileotp")).sendKeys("654321");// mobile otp enter
		driver.findElement(By.name("emailotp")).sendKeys("654321");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;// scrolling to below

		js.executeScript("window.scrollBy(0,1000)");
		WebElement CancelButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Cancel']")));
		CancelButton.click();

		driver.findElement(By.id("generateOtpBtn")).click();// generate OTP
		Thread.sleep(3000);
		driver.findElement(By.name("mobileotp")).sendKeys("654321");// mobile otp enter
		driver.findElement(By.name("emailotp")).sendKeys("654321");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,1000)");
		WebElement ProceedButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Proceed']")));
		ProceedButton.click();

		try {
			
//			WebElement checkbox=wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(/html/body/div[2]/div/div/div/div[4]/div[1]/div/label/input)[1]")));
//		checkbox.click();
			WebElement proceed = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//span[normalize-space(text())='PROCEED']")));
			proceed.click();
		} catch (Exception e) {
//			WebElement checkbox=wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("(/html/body/div[2]/div/div/div/div[4]/div[1]/div/label/input)[1]")));
//			checkbox.click();
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
			
//			WebElement checkbox=wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(/html/body/div[2]/div/div/div/div[4]/div[1]/div/label/input)[1]")));
//		checkbox.click();
			WebElement proceed = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//span[normalize-space(text())='PROCEED']")));
			proceed.click();
		} catch (Exception e) {
//			WebElement checkbox=wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("(/html/body/div[2]/div/div/div/div[4]/div[1]/div/label/input)[1]")));
//			checkbox.click();
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
				
//				WebElement checkbox=wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("(/html/body/div[2]/div/div/div/div[4]/div[1]/div/label/input)[1]")));
//			checkbox.click();
				WebElement proceed = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//span[normalize-space(text())='PROCEED']")));
				proceed.click();
			} catch (Exception e) {
//				WebElement checkbox=wait.until(ExpectedConditions
//						.elementToBeClickable(By.xpath("(/html/body/div[2]/div/div/div/div[4]/div[1]/div/label/input)[1]")));
//				checkbox.click();
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
				
//				WebElement checkbox=wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("(/html/body/div[2]/div/div/div/div[4]/div[1]/div/label/input)[1]")));
//			checkbox.click();
				WebElement proceed = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//span[normalize-space(text())='PROCEED']")));
				proceed.click();
			} catch (Exception e) {
//				WebElement checkbox=wait.until(ExpectedConditions
//						.elementToBeClickable(By.xpath("(/html/body/div[2]/div/div/div/div[4]/div[1]/div/label/input)[1]")));
//				checkbox.click();
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
				WebElement completeSigningBtnXPath = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='finishSign hoverclass']")));
				completeSigningBtnXPath.click(); // click on Finish
			} catch (NoSuchElementException ex) {
				WebElement alternativeFinishBtn = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='furturAction']//button)[1]")));
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
			driver.findElement(By.cssSelector("button.discardAndSign.hoverclass")).click();// click on preview btn
		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='discardAndSign hoverclass']")).click();// click on preview btn
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='furturAction']//button)[2]")).click();// clicking
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
			driver.findElement(By.cssSelector("button.finishSign.hoverclass")).click(); // click on Finish
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
		scroll("The signed document can be downloaded from this page, or from the Inbox later.");
	}

	@Test
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
		driver.findElement(By.xpath("(//div[@class='furturAction']//button)[3]")).click();
		// click alert okk
	}
}
