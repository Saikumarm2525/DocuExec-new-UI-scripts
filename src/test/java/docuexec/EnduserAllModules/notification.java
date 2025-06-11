package docuexec.EnduserAllModules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class notification extends Baseclass {

	@Test
	public void IwillDoItLater() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testLogin();
		driver.findElement(By.xpath("")).click();

        // Click the button to show the popup
        driver.findElement(By.xpath("(/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/button[1])[1]")).click();

        // Wait for the popup to be visible and click the OK button
        
//		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
		WebElement Emessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"react-confirm-alert\"]/div)[1]")));
		String message = Emessage.getText().trim();

		// Check if the message contains the specific text and extract it
		String successMessage = message.contains("You can complete the signing later from the 'Pending Signatures' menu.")
				? "You can complete the signing later from the 'Pending Signatures' menu."
				: message;

		System.out.println(successMessage);
		// Assertion to check if the success message is as expected
		String expectedSuccessMessage = "You can complete the signing later from the 'Pending Signatures' menu.";

		softAssert.assertEquals(successMessage, expectedSuccessMessage); // For TestNG

		// Click OK on the message
		WebElement okButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")));
		okButton.click();
		softAssert.assertAll();
		testLogout();
	}
	
	
}
