package docuexec.EnduserAllModules;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.junit.Assert;

public class ProfileUpdates extends Baseclass {

	@Test
	public void changepasswordProceed() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		testLogin(); // login
		WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));

		// Click on name to edit
		WebElement ProfileElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='userProfile hoverclass']//img[1]")));
		ProfileElement.click();

		
		try {
			// Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();
		} catch (Exception e) {
			System.out.println("Normal Flow");
		}
		// Click on change password
		WebElement changePasswordButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Change Password']")));
		changePasswordButton.click();

		// Enter new password
		WebElement newPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space(text())='New Password']/following::input)[1]")));
		newPasswordField.sendKeys(password);

		//view pass
		driver.findElement(By.xpath("(//div[@class='imgLogoDiv']//i)[1]")).click();
		// Re-enter password
		WebElement rePasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space(text())='Confirm Password']/following::input)[1]")));
		rePasswordField.sendKeys(password);
		//view pass
		driver.findElement(By.xpath("(//div[@class='imgLogoDiv']//i)[2]")).click();
		// Click proceed button
		WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='actionBtn']//span)[1]")));
		verifyButton.click();

		try {
			// Click OK
			WebElement confirmOkButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			confirmOkButton.click();
		} catch (Exception e) {
			WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".confirmBtn"))); // Fixed
																														// CSS
																														// selector
			confirmBtn.click();
		}

		// Enter OTP
		WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"changePasswordOTP\"]")));
		otpField.sendKeys(otp);

		// Click on submit button
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
		submitButton.click();

		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("Password changed successfully") ? "Password changed successfully"
				: message;

		System.out.println("change password:" + successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "Password changed successfully";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

		// Click OK on the message
		WebElement okButton1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton1.click();

		softAssert.assertAll();
//		Thread.sleep(4000);
	
		testLogout();

	}
	
	
	@Test
	public void changepasswordCancel() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		testLogin(); // login
		WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));

		// Click on name to edit
		WebElement ProfileElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='userProfile hoverclass']//img[1]")));
		ProfileElement.click();

		
		try {
			// Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();
		} catch (Exception e) {
			System.out.println("Normal Flow");
		}
		// Click on change password
		WebElement changePasswordButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Change Password']")));
		changePasswordButton.click();

		// Enter new password
		WebElement newPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space(text())='New Password']/following::input)[1]")));
		newPasswordField.sendKeys(password);

		//view pass
		driver.findElement(By.xpath("(//div[@class='imgLogoDiv']//i)[1]")).click();
		// Re-enter password
		WebElement rePasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space(text())='Confirm Password']/following::input)[1]")));
		rePasswordField.sendKeys(password);
		//view pass
		driver.findElement(By.xpath("(//div[@class='imgLogoDiv']//i)[2]")).click();
		// Click cancel button
		WebElement CancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Cancel']")));
		CancelButton.click();

		
	
		testLogout();

	}

	@Test
	public void Editname() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		testLogin(); // login

		WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));

		// Click on name to edit
				WebElement ProfileElement = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='userProfile hoverclass']//img[1]")));
				ProfileElement.click();

		Thread.sleep(2000);
		try { // Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();

			driver.findElement(By.xpath("//div[@class='userImageAndHeadingBtnEDit buttonHover']//span[1]")).click();// Edit profile button click
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//div[@title='Edit']//img)[1]")).click();// edit full name
			driver.findElement(By.xpath("(//div[@class='modalInputEditPro']//input)[1]")).clear();// clear the name field
			driver.findElement(By.xpath("(//div[@class='modalInputEditPro']//input)[1]")).sendKeys(name);// enter full name
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click save changes btn
			Thread.sleep(3000);
			try {
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();// click
																												// ok
			} catch (Exception e) {
				driver.findElement(By.cssSelector("confirmBtn")).click();// click ok
			}
			driver.findElement(By.xpath("(//span[normalize-space(text())='Mobile OTP']/following::input)[1]")).sendKeys(otp);// entering mobile OTP
			driver.findElement(By.xpath("//span[normalize-space(text())='Email OTP']/following::input")).sendKeys(otp);// entering email OTP
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click submitchanges btn
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@class='userImageAndHeadingBtnEDit buttonHover']//span[1]")).click();// Edit profile button click
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//div[@title='Edit']//img)[1]")).click();// edit full name
			driver.findElement(By.xpath("(//div[@class='modalInputEditPro']//input)[1]")).clear();// clear the name field
			driver.findElement(By.xpath("(//div[@class='modalInputEditPro']//input)[1]")).sendKeys(name);// enter full name
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click save changes btn
			Thread.sleep(3000);
			try {
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();// click
																												// ok
			} catch (Exception e1) {
				driver.findElement(By.cssSelector("confirmBtn")).click();// click ok
			}
			driver.findElement(By.xpath("(//span[normalize-space(text())='Mobile OTP']/following::input)[1]")).sendKeys(otp);// entering mobile OTP
			driver.findElement(By.xpath("//span[normalize-space(text())='Email OTP']/following::input")).sendKeys(otp);// entering email OTP
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click submitchanges btn
		}
		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("Profile updated successfully") ? "Profile updated successfully"
				: message;

		System.out.println(successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "Profile updated successfully";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

		// Click OK on the message
		WebElement okButton1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton1.click();

		softAssert.assertAll();
		Thread.sleep(2000);
		
//		driver.navigate().to(uaturl + "/accountInfo");

	}

	@Test
	public void Editmail() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		testLogin(); // login

		WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));

		// Click on name to edit
				WebElement ProfileElement = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='userProfile hoverclass']//img[1]")));
				ProfileElement.click();

		Thread.sleep(2000);
		try { // Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();

			driver.findElement(By.xpath("(//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[2]/div[3]/div[2]/div/img)[1]")).click();// Edit profile button click
			Thread.sleep(2000);


			driver.findElement(By.xpath("(//*[@id=\"profileEmailID\"])[1]")).click();// edit full email
			driver.findElement(By.xpath("(//*[@id=\"profileEmailID\"])[1]")).clear();// clear the email field
			driver.findElement(By.xpath("(//*[@id=\"profileEmailID\"])[1]")).sendKeys(mail);// enter mail
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click save changes btn
			Thread.sleep(3000);
			try {
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();// click
																												// ok
			} catch (Exception e) {
				driver.findElement(By.cssSelector("confirmBtn")).click();// click ok
			}
			driver.findElement(By.xpath("(//span[normalize-space(text())='Mobile OTP']/following::input)[1]")).sendKeys(otp);// entering mobile OTP
			driver.findElement(By.xpath("//span[normalize-space(text())='Email OTP']/following::input")).sendKeys(otp);// entering email OTP
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click submitchanges btn
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@class='userImageAndHeadingBtnEDit buttonHover']//span[1]")).click();// Edit profile button click
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//div[@title='Edit']//img)[1]")).click();// edit full name
			driver.findElement(By.xpath("(//div[@class='modalInputEditPro']//input)[1]")).clear();// clear the name field
			driver.findElement(By.xpath("(//div[@class='modalInputEditPro']//input)[1]")).sendKeys(name);// enter full name
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click save changes btn
			Thread.sleep(3000);
			try {
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();// click
																												// ok
			} catch (Exception e1) {
				driver.findElement(By.cssSelector("confirmBtn")).click();// click ok
			}
			driver.findElement(By.xpath("(//span[normalize-space(text())='Mobile OTP']/following::input)[1]")).sendKeys(otp);// entering mobile OTP
			driver.findElement(By.xpath("//span[normalize-space(text())='Email OTP']/following::input")).sendKeys(otp);// entering email OTP
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click submitchanges btn
		}
		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("Profile updated successfully") ? "Profile updated successfully"
				: message;

		System.out.println(successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "Profile updated successfully";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

		// Click OK on the message
		WebElement okButton1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton1.click();

		softAssert.assertAll();
		Thread.sleep(2000);
		
//		driver.navigate().to(uaturl + "/accountInfo");

	}

	@Test
	public void Editmobilenumber() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		testLogin(); // login

		WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));

		// Click on name to edit
				WebElement ProfileElement = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='userProfile hoverclass']//img[1]")));
				ProfileElement.click();

		Thread.sleep(2000);
		try { // Click OK on the message
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
			okButton.click();

			driver.findElement(By.xpath("(//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[2]/div[2]/div[2]/div/img)[1]")).click();// Edit profile button click
			Thread.sleep(2000);


			driver.findElement(By.xpath("(//*[@id=\"mobileNumber\"])[1]")).click();// edit full name
			driver.findElement(By.xpath("(//*[@id=\"mobileNumber\"])[1]")).clear();// clear the name field
			driver.findElement(By.xpath("(//*[@id=\"mobileNumber\"])[1]")).sendKeys(mob);// enter full name
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click save changes btn
			Thread.sleep(3000);
			try {
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();// click
																												// ok
			} catch (Exception e) {
				driver.findElement(By.cssSelector("confirmBtn")).click();// click ok
			}
			driver.findElement(By.xpath("(//span[normalize-space(text())='Mobile OTP']/following::input)[1]")).sendKeys(otp);// entering mobile OTP
			driver.findElement(By.xpath("//span[normalize-space(text())='Email OTP']/following::input")).sendKeys(otp);// entering email OTP
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click submitchanges btn
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@class='userImageAndHeadingBtnEDit buttonHover']//span[1]")).click();// Edit profile button click
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//div[@title='Edit']//img)[1]")).click();// edit full name
			driver.findElement(By.xpath("(//div[@class='modalInputEditPro']//input)[1]")).clear();// clear the name field
			driver.findElement(By.xpath("(//div[@class='modalInputEditPro']//input)[1]")).sendKeys(name);// enter full name
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click save changes btn
			Thread.sleep(3000);
			try {
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();// click
																												// ok
			} catch (Exception e1) {
				driver.findElement(By.cssSelector("confirmBtn")).click();// click ok
			}
			driver.findElement(By.xpath("(//span[normalize-space(text())='Mobile OTP']/following::input)[1]")).sendKeys(otp);// entering mobile OTP
			driver.findElement(By.xpath("//span[normalize-space(text())='Email OTP']/following::input")).sendKeys(otp);// entering email OTP
			driver.findElement(By.xpath("(//div[@class='actionBtn']//span)[1]")).click();// click submitchanges btn
		}
		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("Profile updated successfully") ? "Profile updated successfully"
				: message;

		System.out.println(successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "Profile updated successfully";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

		// Click OK on the message
		WebElement okButton1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton1.click();

		softAssert.assertAll();
		Thread.sleep(2000);
		
		testLogout();
	}

	@Test
	public void DeleteAccount() throws Exception {
		testLogin();//login
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'UserDetailCustom dropdown-toggle')]")).click();//click on name
		
		
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/span[1]/div/div/button[1]")).click();// click on
																									// deleteaccount
		Thread.sleep(2000);
		driver.findElement(By.id("accountDeteChckBox")).click();// click agree check box
		driver.findElement(By.xpath("(//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div/div[3]/div/span)[1]")).click();// clicking proceed btn
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();// click ok
		} catch (Exception e) {
			driver.findElement(By.cssSelector("confirmBtn")).click();// click ok
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"DelteAccuntOTP\"]")).sendKeys(otp); // entering Otp
		driver.findElement(By.xpath("(//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[3]/div/div[3]/div[1]/span)[1]")).click();// click delete/submit btn
	}
}
