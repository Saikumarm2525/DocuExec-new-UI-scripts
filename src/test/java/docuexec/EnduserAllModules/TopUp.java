package docuexec.EnduserAllModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyTestListener.class)
public class TopUp extends Baseclass {

//new user topUp module
@Test
public void subscriptionTopUpNewUsers() throws Exception {
testlogin();//	 login DocuExec application
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

private void testlogin() {
	// TODO Auto-generated method stub
	
}
@Test
public void subscriptionTopUpOldUsers() throws Exception
{
	testlogin();//	 login DocuExec application
	accountDetailsRemainderClose();////this method close the remainder modal in account details when logged in
	topUp();//clicks the topUp in sidebar	
	subscriptionTopUpClick();//clicks the subscription topup under topup in sidebar
	Thread.sleep(4000);
	subscribePlanyearlyClassicGetstartedButtonh();//this method subscribes yearly Classic plan(100 rupees)
	Thread.sleep(5000);
	// Step 1: Print existing and updated values
	printSingingStorageBeforeTopup(); // stores value in existingstorageCountStatusText
	signingsAddOn(); // simulate adding signing
	storageAddOn();  // simulate adding storage
	printSingingStorageAfterTopup(); // stores value in updatedstorageCountStatusText


	validateTopUp();
	// Final Step: Logout
testLogout();

	}
String updatedstorageCountStatusText;
String existingstorageCountStatusText;
String ExistingsignCountStatusText;
String updatedsignCountStatusText;

// Extract storage limit number after "of" from "31.46 MB of 38.0 MB used"
    private double getStorageLimitFromText(String storageText) {
        Pattern pattern = Pattern.compile("of\\s+(\\d+(\\.\\d+)?)\\s+MB");
        java.util.regex.Matcher matcher = pattern.matcher(storageText);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1));
        } else {
            throw new IllegalArgumentException("Unable to extract storage limit from text: " + storageText);
        }
    }

    // Extract sign limit number after "of" from "180 of 390 Sign used"
    private int getSignLimitFromText(String signText) {
        Pattern pattern = Pattern.compile("of\\s+(\\d+)");
        java.util.regex.Matcher matcher = pattern.matcher(signText);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new IllegalArgumentException("Unable to extract sign limit from text: " + signText);
        }
    }

    public void printSingingStorageBeforeTopup() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space(text())='Account Details']")).click();
        Thread.sleep(3000);

        System.out.println("*************************************************");
        System.out.println("           Signs Completed status                ");
        System.out.println("*************************************************");
        ExistingsignCountStatusText = driver.findElement(By.className("signCountStatus")).getText();
        System.out.println(ExistingsignCountStatusText);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("           Storage used status                ");
        System.out.println("*************************************************");
        existingstorageCountStatusText = driver.findElement(By.className("storageCountStatus")).getText();
        System.out.println(existingstorageCountStatusText);
    }

    public void printSingingStorageAfterTopup() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space(text())='Account Details']")).click();
        Thread.sleep(3000);

        System.out.println("*************************************************");
        System.out.println("           Signs Completed status                ");
        System.out.println("*************************************************");
        updatedsignCountStatusText = driver.findElement(By.className("signCountStatus")).getText();
        System.out.println(updatedsignCountStatusText);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("           Storage used status                ");
        System.out.println("*************************************************");
        updatedstorageCountStatusText = driver.findElement(By.className("storageCountStatus")).getText();
        System.out.println(updatedstorageCountStatusText);
    }

    public void validateTopUp() {
        try {
            double beforeLimit = getStorageLimitFromText(existingstorageCountStatusText);
            double afterLimit = getStorageLimitFromText(updatedstorageCountStatusText);

            System.out.println("Before Storage Limit: " + beforeLimit);
            System.out.println("After Storage Limit: " + afterLimit);

            if (afterLimit == beforeLimit + 1.0) {
                System.out.println("✅ Storage limit increased by 1 MB as expected.");
            } else {
                System.out.println("❌ Storage limit did not increase by 1 MB.");
                System.out.println("Expected: " + (beforeLimit + 1.0) + ", but got: " + afterLimit);
            }

            int beforeSignLimit = getSignLimitFromText(ExistingsignCountStatusText);
            int afterSignLimit = getSignLimitFromText(updatedsignCountStatusText);

            System.out.println("Before Sign Limit: " + beforeSignLimit);
            System.out.println("After Sign Limit: " + afterSignLimit);

            if (afterSignLimit == beforeSignLimit + 20) {
                System.out.println("✅ Sign count limit increased by 20 as expected.");
            } else {
                System.out.println("❌ Sign count limit did not increase by 20.");
                System.out.println("Expected: " + (beforeSignLimit + 20) + ", but got: " + afterSignLimit);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error in validation: " + e.getMessage());
        }
    }



	
// Initialize Actions class for advanced user interactions


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
	
//	Click Vouchers in sidebar.
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
//		topUp();//clicks topup in the sidebar
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
//			topUp();//clicks topup in the sidebar
			subscriptionTopUpClick();//clicks the subscription topup under topup in sidebar
			Thread.sleep(3000);
			storageAddOnGetStartedButton();//This method clicks the storageAddOn GetStartedButton
			Thread.sleep(3000);
			payButtonclick();//clicks the pay button after selecting a addon and plans
			Thread.sleep(3000);
			topUpAfterPayModal();//verifies whether text displayed is correct in model after clicking pay button
			driver.findElement(By.xpath("//div[@class='react-confirm-alert-button-group']//button[1]")).click();//press ok button for the model

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


