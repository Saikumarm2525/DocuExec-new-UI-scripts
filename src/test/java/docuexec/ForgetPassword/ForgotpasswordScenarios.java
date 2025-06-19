package docuexec.ForgetPassword;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class ForgotpasswordScenarios extends Baseclass {
	@Test
	public void forgotPassword() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// Initialize WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Navigate to the staging URL
		driver.get(Stagingurl);

		// Maximize the window (if needed)
		driver.manage().window().maximize();

		// Enter username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

		// Click the "Forgot" button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
				.click();

		// Click the "Get OTP" button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
				.click();

		// Handle the popup, assuming it needs a click on the "OK" button
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

		// Enter OTP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

		// Enter new password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys(password);

		// Enter confirm password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys(password);

		Thread.sleep(2000);
		// Click the "Reset Password" button to submit the form
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//div[normalize-space(text())='Reset Password']")))
				.click();

		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("Password updated successfully") ? "Password updated successfully"
				: message;

		System.out.println("forgotpassword normal flow" + successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "Password updated successfully";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

		// Click OK on the message
		WebElement okButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton.click();
		softAssert.assertAll();

	}
//
//	@Test
//	public void PasswordMissingUppercase() throws Exception {
//		SoftAssert softAssert = new SoftAssert();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Navigate to the staging URL
//		driver.get(uaturl);
//		driver.manage().window().maximize();
//
//		// Enter username
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
//
//		// Click the "Forgot" button
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='loginForm']/div[3]/div[2]/button")))
//				.click();
//
//		// Click the "Get OTP" button
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='getOTPForm']/div[2]/div/button")))
//				.click();
//
//		// Handle the popup
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();
//
//		// Enter OTP
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("otp"))).sendKeys(wotp);
//
//		// Enter new password
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("valid1password@");
//
//		// Enter confirm password
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repassword"))).sendKeys("valid1password@");
//
//		// Wait and submit
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(By
//				.xpath("(/html/body/div/div/div[3]/div[2]/div/div/div[1]/div/form[2]/div[2]/div[4]/div[1]/button)[1]")))
//				.click();
//
//		// Verify error message
//		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
//		String message = Emessage.getText().trim();
//		softAssert.assertEquals(message, "Password must contain at least one uppercase letter");
//
//		// Close the message
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button"))).click();
//		softAssert.assertAll();
//	}

	@Test
	public void PasswordMissingUppercase() throws Exception {
	    SoftAssert softAssert = new SoftAssert();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    // Navigate to the staging URL
	    driver.get(Stagingurl);
	    driver.manage().window().maximize();

		// Enter username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

		// Click the "Forgot" button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
				.click();

		// Click the "Get OTP" button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
				.click();

		// Handle the popup, assuming it needs a click on the "OK" button
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

		// Enter OTP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

		// Enter new password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("password@123");

		// Enter confirm password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("password@123");

	    Thread.sleep(4000);
	 // Click the "Reset Password" button to submit the form
	 		wait.until(ExpectedConditions.elementToBeClickable(By
	 				.xpath("//div[@id='fwResendCounter']/following-sibling::div[1]")))
	 				.click();
	 		Thread.sleep(3000);
	    try {
	        // Handle the first toast message for validation of error message
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Wait for the toast message indicating missing uppercase character
	        WebElement toastMessage = wait1.until(
	        	    ExpectedConditions.visibilityOfElementLocated(
	        	        By.xpath("//div[@id='notification-wrapper']/div[1]/span[1]") // fixed selector
	        	    )
	        	);

	        	String toastMessageText = toastMessage.getText().trim();
	        	System.out.println("Actual Toast Message: [" + toastMessageText + "]");

	        	String expectedSuccessMessage = "Password should contain atleast 1 Capital letter, 1 Small letter, 1 Numeric and 1 Special character";
	        	System.out.println("Expected Toast Message: [" + expectedSuccessMessage + "]");

	        	softAssert.assertEquals(toastMessageText, expectedSuccessMessage);

	        	softAssert.assertAll(); // don't forget this


	    } catch (Exception e) {
	        System.out.println("An error occurred while verifying the toast message: " + e.getMessage());
	    }

	    // Final assertion to validate all soft assertions
	    softAssert.assertAll();
	}


	@Test
	public void PasswordMissingSpecialCharacter() throws Exception {
		  SoftAssert softAssert = new SoftAssert();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		    // Navigate to the staging URL
		    driver.get(Stagingurl);
		    driver.manage().window().maximize();

			// Enter username
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

			// Click the "Forgot" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
					.click();

			// Click the "Get OTP" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
					.click();

			// Handle the popup, assuming it needs a click on the "OK" button
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

			// Enter OTP
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

			// Enter new password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("Password123");

			// Enter confirm password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("Password123");

		    Thread.sleep(4000);
		 // Click the "Reset Password" button to submit the form
		 		wait.until(ExpectedConditions.elementToBeClickable(By
		 				.xpath("//div[@id='fwResendCounter']/following-sibling::div[1]")))
		 				.click();
		 		Thread.sleep(3000);
		    try {
		        // Handle the first toast message for validation of error message
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		        // Wait for the toast message indicating missing uppercase character
		        WebElement toastMessage = wait1.until(
		        	    ExpectedConditions.visibilityOfElementLocated(
		        	        By.xpath("//div[@id='notification-wrapper']/div[1]/span[1]") // fixed selector
		        	    )
		        	);

		        	String toastMessageText = toastMessage.getText().trim();
		        	System.out.println("Actual Toast Message: [" + toastMessageText + "]");

		        	String expectedSuccessMessage = "Password should contain atleast 1 Capital letter, 1 Small letter, 1 Numeric and 1 Special character";
		        	System.out.println("Expected Toast Message: [" + expectedSuccessMessage + "]");

		        	softAssert.assertEquals(toastMessageText, expectedSuccessMessage);

		        	softAssert.assertAll(); // don't forget this


		    } catch (Exception e) {
		        System.out.println("An error occurred while verifying the toast message: " + e.getMessage());
		    }

		    // Final assertion to validate all soft assertions
		    softAssert.assertAll();
	}

	@Test
	public void PasswordMissingNumeric() throws Exception {
		 SoftAssert softAssert = new SoftAssert();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		    // Navigate to the staging URL
		    driver.get(Stagingurl);
		    driver.manage().window().maximize();

			// Enter username
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

			// Click the "Forgot" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
					.click();

			// Click the "Get OTP" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
					.click();

			// Handle the popup, assuming it needs a click on the "OK" button
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

			// Enter OTP
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

			// Enter new password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("Password@");

			// Enter confirm password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("Password@");

		    Thread.sleep(4000);
		 // Click the "Reset Password" button to submit the form
		 		wait.until(ExpectedConditions.elementToBeClickable(By
		 				.xpath("//div[@id='fwResendCounter']/following-sibling::div[1]")))
		 				.click();
		 		Thread.sleep(3000);
		    try {
		        // Handle the first toast message for validation of error message
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		        // Wait for the toast message indicating missing uppercase character
		        WebElement toastMessage = wait1.until(
		        	    ExpectedConditions.visibilityOfElementLocated(
		        	        By.xpath("//div[@id='notification-wrapper']/div[1]/span[1]") // fixed selector
		        	    )
		        	);

		        	String toastMessageText = toastMessage.getText().trim();
		        	System.out.println("Actual Toast Message: [" + toastMessageText + "]");

		        	String expectedSuccessMessage = "Password should contain atleast 1 Capital letter, 1 Small letter, 1 Numeric and 1 Special character";
		        	System.out.println("Expected Toast Message: [" + expectedSuccessMessage + "]");

		        	softAssert.assertEquals(toastMessageText, expectedSuccessMessage);

		        	softAssert.assertAll(); // don't forget this


		    } catch (Exception e) {
		        System.out.println("An error occurred while verifying the toast message: " + e.getMessage());
		    }

		    // Final assertion to validate all soft assertions
		    softAssert.assertAll();
	}

	@Test
	public void PasswordMissingLowercase() throws Exception {
		 SoftAssert softAssert = new SoftAssert();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		    // Navigate to the staging URL
		    driver.get(Stagingurl);
		    driver.manage().window().maximize();

			// Enter username
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

			// Click the "Forgot" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
					.click();

			// Click the "Get OTP" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
					.click();

			// Handle the popup, assuming it needs a click on the "OK" button
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

			// Enter OTP
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

			// Enter new password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("PASSWORD@123");

			// Enter confirm password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("PASSWORD@123");

		    Thread.sleep(4000);
		 // Click the "Reset Password" button to submit the form
		 		wait.until(ExpectedConditions.elementToBeClickable(By
		 				.xpath("//div[@id='fwResendCounter']/following-sibling::div[1]")))
		 				.click();
		 		Thread.sleep(3000);
		    try {
		        // Handle the first toast message for validation of error message
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		        // Wait for the toast message indicating missing uppercase character
		        WebElement toastMessage = wait1.until(
		        	    ExpectedConditions.visibilityOfElementLocated(
		        	        By.xpath("//div[@id='notification-wrapper']/div[1]/span[1]") // fixed selector
		        	    )
		        	);

		        	String toastMessageText = toastMessage.getText().trim();
		        	System.out.println("Actual Toast Message: [" + toastMessageText + "]");

		        	String expectedSuccessMessage = "Password should contain atleast 1 Capital letter, 1 Small letter, 1 Numeric and 1 Special character";
		        	System.out.println("Expected Toast Message: [" + expectedSuccessMessage + "]");

		        	softAssert.assertEquals(toastMessageText, expectedSuccessMessage);

		        	softAssert.assertAll(); // don't forget this


		    } catch (Exception e) {
		        System.out.println("An error occurred while verifying the toast message: " + e.getMessage());
		    }

		    // Final assertion to validate all soft assertions
		    softAssert.assertAll();
	}
	@Test
	public void PasswordWithOnlySpecialCharacter() throws Exception {
		 SoftAssert softAssert = new SoftAssert();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		    // Navigate to the staging URL
		    driver.get(Stagingurl);
		    driver.manage().window().maximize();

			// Enter username
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

			// Click the "Forgot" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
					.click();

			// Click the "Get OTP" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
					.click();

			// Handle the popup, assuming it needs a click on the "OK" button
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

			// Enter OTP
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

			// Enter new password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("@@@@@");

			// Enter confirm password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("@@@@@");

		    Thread.sleep(4000);
		 // Click the "Reset Password" button to submit the form
		 		wait.until(ExpectedConditions.elementToBeClickable(By
		 				.xpath("//div[@id='fwResendCounter']/following-sibling::div[1]")))
		 				.click();
		 		Thread.sleep(3000);
		    try {
		        // Handle the first toast message for validation of error message
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		        // Wait for the toast message indicating missing uppercase character
		        WebElement toastMessage = wait1.until(
		        	    ExpectedConditions.visibilityOfElementLocated(
		        	        By.xpath("//div[@id='notification-wrapper']/div[1]/span[1]") // fixed selector
		        	    )
		        	);

		        	String toastMessageText = toastMessage.getText().trim();
		        	System.out.println("Actual Toast Message: [" + toastMessageText + "]");

		        	String expectedSuccessMessage = "Password should contain atleast 1 Capital letter, 1 Small letter, 1 Numeric and 1 Special character";
		        	System.out.println("Expected Toast Message: [" + expectedSuccessMessage + "]");

		        	softAssert.assertEquals(toastMessageText, expectedSuccessMessage);

		        	softAssert.assertAll(); // don't forget this


		    } catch (Exception e) {
		        System.out.println("An error occurred while verifying the toast message: " + e.getMessage());
		    }

		    // Final assertion to validate all soft assertions
		    softAssert.assertAll();
	}
	@Test
	public void PasswordWithOnlyNumericals() throws Exception {
		 SoftAssert softAssert = new SoftAssert();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		    // Navigate to the staging URL
		    driver.get(Stagingurl);
		    driver.manage().window().maximize();

			// Enter username
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

			// Click the "Forgot" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
					.click();

			// Click the "Get OTP" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
					.click();

			// Handle the popup, assuming it needs a click on the "OK" button
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

			// Enter OTP
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

			// Enter new password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("111111");

			// Enter confirm password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("111111");

		    Thread.sleep(4000);
		 // Click the "Reset Password" button to submit the form
		 		wait.until(ExpectedConditions.elementToBeClickable(By
		 				.xpath("//div[@id='fwResendCounter']/following-sibling::div[1]")))
		 				.click();
		 		Thread.sleep(3000);
		    try {
		        // Handle the first toast message for validation of error message
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		        // Wait for the toast message indicating missing uppercase character
		        WebElement toastMessage = wait1.until(
		        	    ExpectedConditions.visibilityOfElementLocated(
		        	        By.xpath("//div[@id='notification-wrapper']/div[1]/span[1]") // fixed selector
		        	    )
		        	);

		        	String toastMessageText = toastMessage.getText().trim();
		        	System.out.println("Actual Toast Message: [" + toastMessageText + "]");

		        	String expectedSuccessMessage = "Password should contain atleast 1 Capital letter, 1 Small letter, 1 Numeric and 1 Special character";
		        	System.out.println("Expected Toast Message: [" + expectedSuccessMessage + "]");

		        	softAssert.assertEquals(toastMessageText, expectedSuccessMessage);

		        	softAssert.assertAll(); // don't forget this


		    } catch (Exception e) {
		        System.out.println("An error occurred while verifying the toast message: " + e.getMessage());
		    }

		    // Final assertion to validate all soft assertions
		    softAssert.assertAll();
	}
	@Test
	public void PasswordWithDifferentDataOnConfirmpassword() throws Exception {
		 SoftAssert softAssert = new SoftAssert();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		    // Navigate to the staging URL
		    driver.get(Stagingurl);
		    driver.manage().window().maximize();

			// Enter username
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

			// Click the "Forgot" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
					.click();

			// Click the "Get OTP" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
					.click();

			// Handle the popup, assuming it needs a click on the "OK" button
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

			// Enter OTP
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

			// Enter new password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("Password@123");

			// Enter confirm password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("Password@321");

		    Thread.sleep(4000);
		 // Click the "Reset Password" button to submit the form
		 		wait.until(ExpectedConditions.elementToBeClickable(By
		 				.xpath("//div[@id='fwResendCounter']/following-sibling::div[1]")))
		 				.click();
		 		Thread.sleep(3000);
		    try {
		        // Handle the first toast message for validation of error message
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		        // Wait for the toast message indicating missing uppercase character
		        WebElement toastMessage = wait1.until(
		        	    ExpectedConditions.visibilityOfElementLocated(
		        	        By.xpath("//div[@id='notification-wrapper']/div[1]/span[1]") // fixed selector
		        	    )
		        	);

		        	String toastMessageText = toastMessage.getText().trim();
		        	System.out.println("Actual Toast Message: [" + toastMessageText + "]");

		        	String expectedSuccessMessage = "Password and Confirm Password Should match";
		        	System.out.println("Expected Toast Message: [" + expectedSuccessMessage + "]");

		        	softAssert.assertEquals(toastMessageText, expectedSuccessMessage);

		        	softAssert.assertAll(); // don't forget this


		    } catch (Exception e) {
		        System.out.println("An error occurred while verifying the toast message: " + e.getMessage());
		    }

		    // Final assertion to validate all soft assertions
		    softAssert.assertAll();
	}
	@Test
	public void PasswordWithInvalidOTP() throws Exception {
		 SoftAssert softAssert = new SoftAssert();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		    // Navigate to the staging URL
		    driver.get(Stagingurl);
		    driver.manage().window().maximize();

			// Enter username
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);

			// Click the "Forgot" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
					.click();

			// Click the "Get OTP" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
					.click();

			// Handle the popup, assuming it needs a click on the "OK" button
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();

			// Enter OTP
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);

			// Enter new password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("Password@123");

			// Enter confirm password
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("Password@123");

		    Thread.sleep(4000);
		 // Click the "Reset Password" button to submit the form
		 		wait.until(ExpectedConditions.elementToBeClickable(By
		 				.xpath("//div[@id='fwResendCounter']/following-sibling::div[1]")))
		 				.click();
		 		Thread.sleep(3000);

	    // Verify error message for invalid OTP
	    WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/p")));
	    String message = Emessage.getText().trim();

	    // Check if the message contains "Invalid OTP, Enter Correct OTP" and extract it
	    String errorMessage = message.contains("Invalid OTP, Enter Correct OTP") ? "Invalid OTP, Enter Correct OTP" : message;

	    System.out.println("forgotpassword invalid OTP flow: " + errorMessage);

	    // Assertion to check if the error message is as expected
	    String expectedErrorMessage = "Password updated successfully";
	    softAssert.assertEquals(errorMessage, expectedErrorMessage); // For TestNG

	    // Click OK on the message
	    WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
	    okButton.click();
	}
	
	
//	//PasswordWithInvalidcredentials
//	@Test
//	public void PasswordWithInvalidcredentials() throws Exception {
//		SoftAssert softAssert = new SoftAssert();
//
//		// Initialize WebDriverWait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Navigate to the staging URL
//		driver.get(Stagingurl);
//
//		// Maximize the window (if needed)
//		driver.manage().window().maximize();
//
//		// Enter username
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
//
//		// Click the "Forgot" button
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/span")))
//				.click();
//
//		// Click the "Get OTP" button
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"forgotPassword-bttn\"]")))
//				.click();
//
//		// Handle the popup, assuming it needs a click on the "OK" button
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("//*[@id='react-confirm-alert']/div/div/div/div/button"))).click();
//
//		// Enter OTP
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwOTP"))).sendKeys(wotp);
//		
//		// Enter new password
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwPassword"))).sendKeys("Test@123");
//
//				// Enter confirm password
//      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fpwConfirmPassword"))).sendKeys("Test@321");
//		
//        Thread.sleep(2000);
//   	 // Click the "Reset Password" button to submit the form
//   	 		wait.until(ExpectedConditions.elementToBeClickable(By
//   	 				.xpath("//div[normalize-space(text())='Reset Password']")))
//   	 				.click();
//
//		Thread.sleep(3000);
//		  WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
//		    String message = Emessage.getText().trim();
//
//		    // Check if the message contains the specific text and extract it
//		    String errorMessage = message.contains("Invalid credentials") ? "Invalid credentials" : message;
//
//		    System.out.println("forgotpassword invalid credentials flow: " + errorMessage);
//
//		    // Assertion to check if the error message is as expected
//		    String expectedErrorMessage = "OTP sent to registered email ID and mobile number.";
//		    softAssert.assertEquals(errorMessage, expectedErrorMessage); // For TestNG
//
//		    // Click OK on the message
//		    WebElement okButton = wait.until(ExpectedConditions
//		            .elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
//		    okButton.click();
//
//		    // Assert all to validate the soft assertions
//		    softAssert.assertAll();
//	}
//	
}
