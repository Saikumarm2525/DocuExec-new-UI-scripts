package docuexec.EnduserAllModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyTestListener.class)
public class NewUserLoginTermsConAgree extends Baseclass {

    @Test
    public void NewUserSigningTermsAndCondition() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25)); // Wait object with 25s timeout
        Actions actions = new Actions(driver); // Initialize Actions class for advanced user interactions

        testLogin(); // Login to the DocuExec application

        clickAccountDetails(); // Click "Account Details" in the sidebar
        Thread.sleep(3000);

        // Verify "Full Name" label is visible
        WebElement fullName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Full Name']")));
        Assert.assertTrue(fullName.isDisplayed());

        // Verify "Aadhaar sign units" label is visible
        WebElement signUnits = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Aadhaar sign units']")));
        Assert.assertTrue(signUnits.isDisplayed());

        // Verify "Email-ID" label is visible
        WebElement emailId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Email-ID']")));
        Assert.assertTrue(emailId.isDisplayed());

        // Verify "Mobile" label is visible
        WebElement mobile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Mobile']")));
        Assert.assertTrue(mobile.isDisplayed());
        Thread.sleep(3000);

        // Verify "Free Storage Plan" label is visible
        WebElement freeStoragePlan = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Free Storage Plan']")));
        Assert.assertTrue(freeStoragePlan.isDisplayed());
        Thread.sleep(3000);

        driver.findElement(By.xpath("//h5[@id='consenteSignLink']//i[1]")).click(); // Click the "Consent eSign Link"
        Thread.sleep(3000);

        clickVoucher(); // Click "Vouchers" in the sidebar

        buyVoucher(); // Under Vouchers, click "Buy Vouchers"
        Thread.sleep(5000);

        moveToCheckbox(); // Scroll to the "I agree to terms and conditions in consent" checkbox
        Thread.sleep(5000);

        clickCheckBox(); // Click the checkbox to agree to terms and conditions
        Thread.sleep(3000);

        clickBulkSigning(); // Click "Bulk Signing" in the sidebar

        clickBulkSignUpload(); // Under bulk signing, click "Bulk Sign Upload"
        Thread.sleep(3000);

        clickbulkSignUploadButton(); // Click upload button to upload CSV file
        Thread.sleep(3000);

        uploadCsv(); // Upload the CSV file
        Thread.sleep(5000);

        clickbulkSigningUploadDocument(); // Click upload button to upload the document
        Thread.sleep(5000);

        uploadDocument(); // Upload the document for signing

        clickBulkSignUploadProceed(); // Click "Proceed" button after uploads
        Thread.sleep(1000);

        bulkSignAfterProceedDocTitle(); // Enter document title for email notifications
        Thread.sleep(2000);

        BulkSigningAfterUploadModelSendButton(); // Click "Send for Signing" button
        Thread.sleep(2000);

        // Get and verify the alert message when no signing plan is active
        String bulkSigningnoactive = driver.findElement(By.xpath("//div[text()='No active signing plans, to perform the bulk signing operation!']")).getText();
        bulkSigningnoactive = bulkSigningnoactive.substring(0, bulkSigningnoactive.length() - 3);
        Assert.assertEquals(bulkSigningnoactive, "No active signing plans, to perform the bulk signing operation!");

        driver.findElement(By.xpath("//div[@class='react-confirm-alert-button-group']//button[1]")).click(); // Click "OK" button in the modal
        Thread.sleep(1000);

        closeBulkSigningEmailNotificModel(); // Close email notification modal
        Thread.sleep(1000);

        clickSignDocuments(); // Click "Sign Documents" in the sidebar

        clickSignDocumentsUploadButton(); // Click upload button to add PDF document

        uploadDocument(); // Upload document to sign

        clickSignByMeButton(); // Click "Sign By Me" button
        Thread.sleep(2000);

        // Get and verify the alert message when signing limit is reached
        String signingLimitReachedModel = driver.findElement(By.xpath("(//div[@class='react-confirm-alert']//div)[1]")).getText();
        signingLimitReachedModel = signingLimitReachedModel.substring(0, signingLimitReachedModel.length() - 3);
        Assert.assertEquals(signingLimitReachedModel, "Signing limit reached");

        driver.findElement(By.xpath("//div[@class='react-confirm-alert-button-group']//button[1]")).click(); // Click "OK" to close modal
        Thread.sleep(2000);

        topUp(); // Click "Topup" in sidebar
        Thread.sleep(1000);

        subscriptionTopUpClick(); // Under Topup, click "Subscription Topup"
        Thread.sleep(5000);

        moveToCheckbox(); // Scroll to the terms and conditions checkbox again
        Thread.sleep(5000);

        clickCheckBox(); // Click the checkbox to agree to terms and conditions
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='next-nav']//button[1]")).click(); // Click "Submit" button for topup
        Thread.sleep(4000);

        clickInbox(); // Click "Inbox" in sidebar
        Thread.sleep(5000);

        //issue there need to fix it
        // Verify that the delete button is disabled         
//        WebElement deleteButton = driver.findElement(By.xpath("(//span[@class='MuiIconButton-label']//img)[2]"));
//        boolean isDisabled = !deleteButton.isEnabled(); // Check if delete button is disabled
//        Assert.assertTrue(isDisabled, "Delete button should be disabled.");
    }
    
    
    
  //new user topUp module
    @Test
    public void subscriptionTopUpNewUsers() throws Exception {
    testLogin();//	 login DocuExec application
    Thread.sleep(5000);
    checkAllTopUpsButtonEnabled();//checks whether all topUps(addOn and plan buttons works)
    Thread.sleep(5000);
    subscribePlanyearlyClassicGetstartedButtonh();//this method subscribes yearly Classic plan(100 rupees)
    Thread.sleep(5000);
    printSingingStorageBeforeTopup();//this method prints singing and storage status before topUp
    signingsAddOn();//makes a topup for signings addOn
    storageAddOn();//makes a topup for storage addOn
    printSingingStorageAfterTopup();//this method prints singing and storage status after topUp
    testLogout();
    }
    
    
  
    
	int time =2000;
	
	 //this method buys the voucher
	@Test
	public void buyVouchers() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		testLogin();
		// Initialize WebDriverWait
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));		
	    Thread.sleep(3000);
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
		driver.findElement(By.id("userCode")).sendKeys("dwqbhwdqkw");//ALPHANUMERICcase
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
	
    
    
	//this method copy the code of the new bought voucher and them redeem it in topUp.
	@Test
	public void newUserVouchersummary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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
	
	
	
	
	
	
	
	
//	//this method makes login
//	@Test
//    public void testLogin() throws InterruptedException {
//     
//            // Open the URL
//            driver.get(url);
//
//            // Wait until the username field is present
//            Thread.sleep(5000); // Wait for page load
//            driver.findElement(By.xpath("(//input[@id='emailMobile'])[1]")).sendKeys(username); // Enter username
//            driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(password); // Enter password
//            Thread.sleep(6000); // Wait before login
//            driver.findElement(By.xpath("(//div[@class='box signUp']//button)[1]")).click(); // Click login
//            Thread.sleep(5000); // Wait after login
//            driver.findElement(By.xpath("//a[normalize-space(text())='Account Details']")).click(); // Click sidebaraccount deatils
//
//            Thread.sleep(2000);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    		
//    		
//   		 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize explicit wait
//   			
//   			// Handle optional modal popup (if present)
//   			try {
//   				WebElement button1 = wait.until(ExpectedConditions
//   						.elementToBeClickable(By.xpath("(//div[@class='ant-modal-content']//button)[1]")));
//   				button1.click();
//   			} catch (Exception e1) {
//   				try {
//   					WebElement button2 = wait
//   							.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']")));
//   					button2.click();
//   				} catch (Exception e2) {
//   					System.out.println("No modal found. Proceeding.");
//   				}
//   			}
//   	     
//            String text = driver.findElement(By.xpath("//span[normalize-space(text())='Current Plan']")).getText();
//			Assert.assertEquals(text, "Current Plan");
//			System.out.println("*************************************************");
//			System.out.println("           Signs Completed status                ");
//			System.out.println("*************************************************");
//			System.out.println(driver.findElement(By.className("signCountStatus")).getText());
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println("*************************************************");
//			System.out.println("           Storage used status                ");
//			System.out.println("*************************************************");
//			System.out.println(driver.findElement(By.className("storageCountStatus")).getText());
//        
//		
//			
//		}
//	   // Initialize Actions class for advanced user interactions

	
		public void clickAccountDetails() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25)); // Wait object with 20s timeout
			 try {
		    	    wait.until(ExpectedConditions.elementToBeClickable(
		    	        By.xpath("(//div[@class='individualMenu']//a)[1]")
		    	    ));
		    	} catch (Exception e1) {
		    	    try {
		    	        wait.until(ExpectedConditions.elementToBeClickable(
		    	            By.xpath("//a[normalize-space(text())='Account Details']")
		    	        ));
		    	    } catch (Exception e2) {
		    	    	
		    	          wait.until(ExpectedConditions.elementToBeClickable(
		    	                By.xpath("(//a[@class='sidebar-link'])[1]")
		    	            ));
		    	        
		    	    }
		    	}

		}
		
		//click Topup in sidebar
		public void topUp() {
			driver.findElement(By.xpath("(//div[@class='sidebar-item']//div)[1]")).click();
		}
		
		//Click Subscription topup feature under Topup
		public void subscriptionTopUpClick() throws InterruptedException {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[text()='eSign TopUp']/following-sibling::a")).click();
		}
		
		// Move to the checkbox("i agree to terms and conditions in consent")
		public void moveToCheckbox() {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//div[@id='pdfContainerdiv']//label[1]"))).perform();
		}
		
		// Click the checkbox("i agree to terms and conditions in consent")
		public void  clickCheckBox() {
			 driver.findElement(By.xpath("//*[@id=\"consentSigningCheckbox\"]")).click();
		}
		
//		Click Vouchers in sidebar.
	public void clickVoucher() {
		driver.findElement(By.xpath("//div[normalize-space(text())='Vouchers']")).click();
			
		}

	//Under vouchers click Buy Vouchers
	public void buyVoucher() {
		driver.findElement(By.xpath("//a[normalize-space(text())='Buy Vouchers']")).click();
	}


	//Click bulk sign in the sidebar
	public void clickBulkSigning() {
		 driver.findElement(By.xpath("//div[normalize-space(text())='Bulk Signing']")).click();
	}

	//Under bulk sign click bulk sign upload
	public void clickBulkSignUpload() {
		driver.findElement(By.xpath("//a[normalize-space(text())='Bulk Signing Upload']")).click();	
	}


	//click upload button to upload csv file 
	public void clickbulkSignUploadButton() {
		 driver.findElement(By.xpath("(//div[@class='fileNameAndSize']//input)[1]")).click();
	}

	//click upload button for document upload
	public void clickbulkSigningUploadDocument() {
		 driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[3]/input")).click();
	}

	//click proceed
	public void clickBulkSignUploadProceed() {
		 driver.findElement(By.xpath("//div[@class='next-nav']//button[1]")).click();
	}

	//give document title in signing details for email notification
	public void bulkSignAfterProceedDocTitle() {
		driver.findElement(By.xpath("(//div[@class='notifyIntFild']//input)[2]")).sendKeys("myfile");
	}


	//click send for signing
	public void BulkSigningAfterUploadModelSendButton() {
		driver.findElement(By.xpath("//span[normalize-space(text())='Send for signing']")).click();
	}

	//closing the signing details for email notification model in bulk signing
	public void closeBulkSigningEmailNotificModel() {
		driver.findElement(By.xpath("//div[@class='modalcloseCross']//img[1]")).click();
	}

	//click sign documents in sidebar
	public void clickSignDocuments() {
		 driver.findElement(By.xpath("(//div[@class='individualMenu']//a)[2]")).click();	
	}

	//click upload PDF button
	public void clickSignDocumentsUploadButton() {
		driver.findElement(By.xpath("//div[@class='UPLPDFIMGBTN']//button[1]")).click();
	}

	//click sign by me button
	public void clickSignByMeButton() {
		 driver.findElement(By.xpath("(//div[@class='SignByme']//div)[1]")).click();
	}


		// Logs in and uploads a csv file by interacting with the file upload
		// dialog.
		public void uploadCsv() throws Exception {
			Thread.sleep(3000);
			// Copy file path to system clipboard for pasting in the native file dialog
			StringSelection filePathSelection = new StringSelection(csvfilepath); // Copies the file path to the system
																				// clipboard
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null); // Sets clipboard content
																									// to file path
			Thread.sleep(3000); // Wait to ensure file dialog opens

			// Simulate Ctrl+V and Enter to paste path and confirm file selection
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(3000); // Wait for file upload to complete
		}

		//clicks the finish button in sign documents after singing a document
		public void clickFinishButtonSignDocuments() {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			 try {
				    // Try first XPath
				    WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(
				        By.xpath("//button[@class='finishSign hoverclass']")));   
				    button1.click();
				   
				}  catch (Exception e2) {
					// Try secound XPath
				    	WebElement button3 = wait.until(ExpectedConditions.elementToBeClickable(
					            By.xpath("(//div[@class='furturAction']//button)[1]")));  
					        button3.click();
				    }
		}
	   
		//clicks the inbox
		public void clickInbox() {
			driver.findElement(By.xpath("//a[normalize-space(text())='Inbox']")).click();
		}
		
		//clicks the delete symbol in a row in actions in inbox
		public void clickDeleteActionsInbox() {
			driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiIconButton-root')]/following-sibling::span[1]")).click();
		}
		
		// Logs in and uploads a document file by interacting with the file upload
		// dialog.
		public void uploadDocument() throws Exception {

			Thread.sleep(3000);
			
			// Copy file path to system clipboard for pasting in the native file dialog
			StringSelection filePathSelection = new StringSelection(filePath); // Copies the file path to the system
																				// clipboard
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null); // Sets clipboard content
																									// to file path

			Thread.sleep(3000); // Wait to ensure file dialog opens
			
			// Simulate Ctrl+V and Enter to paste path and confirm file selection
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000); // Wait for file upload to complete
		}
	    
		//This method clicks the signingsAddOn GetStartedButton 
		public void signingsAddOnGetStartedButton() {
			driver.findElement(By.xpath("(//div[@class='getStarted__sub']//button)[1]")).click();
		}
		
		// Verifies that the "No Active Plan" warning modal appears when clicking "Add On" without an active plan
		public void noactivePlanWaringModel() {
			String text = driver.findElement(By.xpath("(//div[@class='react-confirm-alert']//div)[1]")).getText();
			text=text.substring(0,text.length()-3);  
			Assert.assertEquals(text,"Add-On plans can only be purchased if you have an active plan.");
		}
		
		//This method clicks the ok button in the "No Active Plan" warning modal
		public void noactivePlanWaringModelOk() {
			driver.findElement(By.xpath("//div[@class='react-confirm-alert-button-group']//button[1]")).click();
		}
		
		//This method clicks the storageAddOn GetStartedButton 
			public void storageAddOnGetStartedButton() {
				driver.findElement(By.xpath("//button[@value='S001']")).click();	
	}
			
			// Verifies that the "No Active Plan" warning modal appears when clicking "Add On" without an active plan
			public void noactivePlanWaringModelStorage() {
				String text =driver.findElement(By.xpath("(//div[@class='react-confirm-alert']//div)[1]")).getText();
				text=text.substring(0,text.length()-3);  
				Assert.assertEquals(text,"Add-On plans can only be purchased if you have an active plan.");
			}
			
			//clicks the Halfyearly Classic Getstarted Button 
					public void HalfyearlyClassicGetstartedButton() {
						driver.findElement(By.xpath("(//div[@class='getStarted__sub']//button)[3]")).click();
					}
					
					//clicks the yearly Classic Getstarted Button twenty five rupee
					public void yearlyClassicGetstartedButtontf() {
						driver.findElement(By.xpath("//button[@value='P004']")).click();
					}
					//clicks the yearly Classic Getstarted Button hundred ruppee
					public void yearlyClassicGetstartedButtonh() {
						driver.findElement(By.xpath("//button[@value='P002']")).click();
					}			
		
					
					//clicks the yearly Classic Getstarted Button hundred ruppee
					public void yearlyPremiumButton() {
						driver.findElement(By.xpath("//button[@value='P003']")).click();
					}

					//This method checks whether the pln displayed in account details is current plan
					public void checkplanAccountDetails() {
						String text = driver.findElement(By.xpath("//span[normalize-space(text())='Current Plan']")).getText();
						Assert.assertEquals(text, "Current Plan");
						
						try {
							String upcomingPlan=driver.findElement(By.xpath("//div[@class='infoCardHeader-inactive']//span[1]")).getText();
							Assert.assertEquals(upcomingPlan,"Upcoming Plan" );
						}catch(Exception e){
							System.out.println("No Upcoming plan displayed");
						}
					}	
			
					//This method click pay button
					public void payButtonclick() {
						driver.findElement(By.xpath("(//div[@class='PayBtnDiv']//div)[1]")).click();	
						
					}
					

					//verifies whether text displayed is correct in model after clicking pay button
					public void topUpAfterPayModal() {
						
						String text =driver.findElement(By.xpath("(//div[@class='react-confirm-alert']//div)[1]")).getText();
						text=text.substring(0,text.length()-3);  
						Assert.assertEquals(text,"Request initiated successfully");
					}
		//This button clicks printButton		
		public void clickPrintButton() throws AWTException, InterruptedException
		{
			driver.findElement(By.xpath("//div[@class='PrintBtn buttonHover']//span[1]")).click();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);

	        // Small delay to allow focus to go to the right window
	        Thread.sleep(1000);

	        // Press and release the Escape key
	        robot.keyPress(KeyEvent.VK_ESCAPE);
	        robot.keyRelease(KeyEvent.VK_ESCAPE);

			
		}
		
		//This method has feature from closing reminder model in account details to clicking dropdown in inbox
		public void clickDropDownInbox() throws InterruptedException {				
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			
			 wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize explicit wait
				
				// Handle optional modal popup (if present)
				try {
					WebElement button1 = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("(//div[@class='ant-modal-content']//button)[1]")));
					button1.click();
				} catch (Exception e1) {
					try {
						WebElement button2 = wait
								.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']")));
						button2.click();
					} catch (Exception e2) {
						System.out.println("No modal found. Proceeding.");
					}
				}
		     
				Thread.sleep(5000);
			 
			 // Create an explicit wait with a timeout of 20 seconds
		   
				driver.findElement(By.xpath("(//div[@class='individualMenu']//a)[3]")).click();//clicks inbox in sidebar
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//div[@class='ant-select-selector']//span)[2]")).click();
		   
		}
		
		//This method checks whether all addons and subsciption buttons are working are not
		public void checkAllTopUpsButtonEnabled() throws InterruptedException, AWTException
		{
			topUp();//clicks topup in the sidebar
			subscriptionTopUpClick();//clicks the subscription topup under topup in sidebar
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class='getStarted__sub']//button)[1]")).isEnabled(); //This method clicks the signingsAddOn GetStartedButton 
			Thread.sleep(3000);		
			driver.findElement(By.xpath("//button[@value='S001']")).isEnabled();	//This method clicks the storageAddOn GetStartedButton 
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class='getStarted__sub']//button)[3]")).isEnabled();//clicks the Halfyearly Classic Getstarted Button 
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@value='P004']")).isEnabled();//clicks the yearly Classic twenty five Getstarted Button
			Thread.sleep(1000);		
			driver.findElement(By.xpath("//button[@value='P002']")).isEnabled();//clicks the yearly Classic hundred Getstarted Button		
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@value='P003']")).isEnabled();//clicks the yearly premium hundred Getstarted Button
			Thread.sleep(3000);
		
		}
		
		//this method subscribes yearly Classic plan(100 rupees)
		public void subscribePlanyearlyClassicGetstartedButtonh() throws InterruptedException {
			yearlyClassicGetstartedButtonh();//clicks the yearly Classic hundred Getstarted Button
			Thread.sleep(1000);
			payButtonclick();//clicks the pay button after selecting a addon and plans
			Thread.sleep(6000);
			topUpAfterPayModal();//verifies whether text displayed is correct in model after clicking pay button
			driver.findElement(By.xpath("//div[@class='react-confirm-alert-button-group']//button[1]")).click();//press ok button for the model

		}
		//makes a topUp for signings addOn
		public void signingsAddOn() throws InterruptedException {
//			topUp();//clicks topup in the sidebar
			subscriptionTopUpClick();//clicks the subscription topup under topup in sidebar
			Thread.sleep(3000);
			signingsAddOnGetStartedButton(); //This method clicks the signingsAddOn GetStartedButton 
			Thread.sleep(3000);
			payButtonclick();//clicks the pay button after selecting a addon and plans
			Thread.sleep(3000);
			topUpAfterPayModal();//verifies whether text displayed is correct in model after clicking pay button
			driver.findElement(By.xpath("//div[@class='react-confirm-alert-button-group']//button[1]")).click();//press ok button for the model

		}
		
		//makes a topUp for storage addOn
			public void storageAddOn() throws InterruptedException {
//				topUp();//clicks topup in the sidebar
				subscriptionTopUpClick();//clicks the subscription topup under topup in sidebar
				Thread.sleep(3000);
				storageAddOnGetStartedButton();//This method clicks the storageAddOn GetStartedButton
				Thread.sleep(3000);
				payButtonclick();//clicks the pay button after selecting a addon and plans
				Thread.sleep(3000);
				topUpAfterPayModal();//verifies whether text displayed is correct in model after clicking pay button
				driver.findElement(By.xpath("//div[@class='react-confirm-alert-button-group']//button[1]")).click();//press ok button for the model

			}
			
			//this method prints singing and storage status before topUp
			public void printSingingStorageBeforeTopup() throws InterruptedException {
				driver.findElement(By.xpath("//a[normalize-space(text())='Account Details']")).click(); // Click sidebar menu//press account details in sidebar
				Thread.sleep(3000);
				checkplanAccountDetails();//This method checks whether the pln displayed in account details is current plan
				System.out.println("*************************************************");
				System.out.println("           Signs Completed status                ");
				System.out.println("*************************************************");
				System.out.println(driver.findElement(By.className("signCountStatus")).getText());
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("*************************************************");
				System.out.println("           Storage used status                ");
				System.out.println("*************************************************");
				System.out.println(driver.findElement(By.className("storageCountStatus")).getText());
			}
			
			//this method prints singing and storage status after topUp
			public void printSingingStorageAfterTopup() throws InterruptedException {
				driver.findElement(By.xpath("//a[normalize-space(text())='Account Details']")).click(); // Click sidebar menu//press account details in sidebar
				Thread.sleep(3000);
				checkplanAccountDetails();//This method checks whether the pln displayed in account details is current plan
				System.out.println("*************************************************");
				System.out.println("           Signs Completed status                ");
				System.out.println("*************************************************");
				System.out.println(driver.findElement(By.className("signCountStatus")).getText());
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("*************************************************");
				System.out.println("           Storage used status                ");
				System.out.println("*************************************************");
				System.out.println(driver.findElement(By.className("storageCountStatus")).getText());
			}
			
			//this method close the remainder modal in account details when logged in
			public void accountDetailsRemainderClose() throws InterruptedException {
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				 wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize explicit wait
				wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize explicit wait
				Thread.sleep(3000); // Allow UI to stabilize after login
				// Handle optional modal popup (if present)
				try {
					WebElement button1 = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("(//div[@class='ant-modal-content']//button)[1]")));
					button1.click();
				} catch (Exception e1) {
					try {
						WebElement button2 = wait
								.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']")));
						button2.click();
					} catch (Exception e2) {
						System.out.println("No modal found. Proceeding.");
					}
				}
			}
			
			//This method checks whether all addons and subsciption buttons are working are not
			public void checkAllVoucherButtonEnabled() throws InterruptedException, AWTException
			{
				driver.findElement(By.xpath("(//div[@class='sidebar-item']//div)[3]")).click();//click voucher in sidebar
				driver.findElement(By.xpath("//div[@class='sidebar-children']//a[1]")).click();//click Buy voucher under voucher
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@class='getStarted__sub']//button)[1]")).isEnabled(); //This method clicks the signingsAddOn GetStartedButton 
				Thread.sleep(3000);		
				driver.findElement(By.xpath("//button[@value='S001']")).isEnabled();	//This method clicks the storageAddOn GetStartedButton 
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@class='getStarted__sub']//button)[3]")).isEnabled();//clicks the Halfyearly Classic Getstarted Button 
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@value='P004']")).isEnabled();//clicks the yearly Classic twenty five Getstarted Button
				Thread.sleep(1000);		
				driver.findElement(By.xpath("//button[@value='P002']")).isEnabled();//clicks the yearly Classic hundred Getstarted Button		
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@value='P003']")).isEnabled();//clicks the yearly premium hundred Getstarted Button
				Thread.sleep(3000);
			
			}
		

}
