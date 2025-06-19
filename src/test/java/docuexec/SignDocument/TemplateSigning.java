package docuexec.SignDocument;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import docuexec.EnduserAllModules.MyTestListener;

@Listeners(MyTestListener.class)
public class TemplateSigning extends SignByme_AllModesSigning {

	//this method automates the process of template signing all pages electronic 
	@Test
	public void templateSigningElectronicSigningFinish() throws Exception {
		templateSigning();
		enterAllPage();
		performElectronicSigning();	
	    Finish();
	    Thread.sleep(2000);
	    testLogout();		
	}
	
	//this method automates the process of template signing all pages electronic discard and resign.
	@Test
	public void templateSigningElectronicSigningDiscardAndResign() throws Exception {
		templateSigning();
		enterAllPage();
		performElectronicSigning();	
		 DiscardandSign();
		 performElectronicSigning();	
		 Finish();
	    Thread.sleep(2000);
	    testLogout();		
	}
	
	//this method automates template signing all pages electronic discard
	@Test
	public void templateSigningElectronicSigningDiscardSign() throws Exception {
		templateSigning();
		enterAllPage();
		performElectronicSigning();	
		Discard();		
	    Thread.sleep(2000);
	    testLogout();		
	}

	//this method automates the process of template signing all pages OTP 
		@Test
		public void templateSigningotpSigningFinish() throws Exception {
			templateSigning();
			enterAllPage();
			performOtpSigning();
			Thread.sleep(4000);
		    Finish();
		    Thread.sleep(2000);
		    testLogout();	
		}
	
	public void templateSigning() throws Exception {
		testLogin();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[7]/a")).click();//click on dropdown
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[1]/div[2]/div[7]/a")).click();//click on view template sidebar
		Thread.sleep(5000);
		driver.findElement(By.xpath("//b[normalize-space(text())='BC_employes']")).click();;//click on hr template
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='toggle101']/following-sibling::div)[2]")).click();//click on the template image(Rental Agreement)
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"cityFrmInptField\"]")).sendKeys("bangalore");//enter city
		
		driver.findElement(By.xpath("//*[@id=\"stateFrmInptField\"]")).sendKeys("karna");//eneter state
	
		WebElement dateInput = driver.findElement(By.id("dateFrmInptField"));
        dateInput.clear(); // Optional
        dateInput.sendKeys("16-05-2025"); // format: yyyy-MM-dd
       
		driver.findElement(By.xpath("//*[@id=\"lessorNameFrmInptField\"]")).sendKeys("Ram");//enter lessor Name
	Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"lessorAddressFrmInptField\"]")).sendKeys("afg");//enter lessor Address
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"totalLeaseYearFrmInptField\"]")).sendKeys("5");//enter lessor years
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"startDateFrmInptField\"]")).sendKeys("2025-02-26");//startdate
		
		driver.findElement(By.xpath("//*[@id=\"lesseeNameFrmInptField\"]")).sendKeys("2025-02-26");//startdate
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"lesseeAddressFrmInptField\"]")).sendKeys("2025-02-26");//startdate
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"NameFrmInptField\"]")).sendKeys("rah");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"Phone_NumberFrmInptField\"]")).sendKeys("9797979797");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"monthlyRentAmountFrmInptField\"]")).sendKeys("168");;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"meterNumberFrmInptField\"]")).sendKeys("6396932");;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"advanceAmountFrmInptField\"]")).sendKeys("200");;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"usrNameFrmInptField\"]")).sendKeys("90987");;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"usrPhoneNumberFrmInptField\"]")).sendKeys("3627839280");;
		Thread.sleep(3000);
		  WebElement dropdownElement = driver.findElement(By.id("CatogoryDropDown"));

	        // Create Select object
	        Select dropdown = new Select(dropdownElement);

	        // ✅ Select by visible text
	        dropdown.selectByVisibleText("one");
	        
	        Thread.sleep(3000);
	        WebElement dropdownElement2 = driver.findElement(By.id("genderDropDown"));

	        // Create Select object
	        Select dropdown2 = new Select(dropdownElement2);

	        // ✅ Select by visible text
	        dropdown2.selectByVisibleText("three");
	        Thread.sleep(3000);
	        
//	        driver.findElement(By.xpath("//*[@id=\"##atchmt##aadhaarImage##\"]")).sendKeys("C:\\Users\\saikumarm\\Downloads\\SampleJPGImage_50kbmb");;
	        Robot robot = new Robot();
	        StringSelection string = new StringSelection("C:\\Users\\saikumarm\\Downloads\\SampleJPGImage_50kbmb");
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);

	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_V);
	        Thread.sleep(2000);

	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"tmpInptFormParDiv\"]/form/div[12]/button")).click();//proceed button
		
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[1]/button[1]")).click();//edit from details
		
		driver.findElement(By.xpath("//*[@id=\"tmpInptFormParDiv\"]/form/div[12]/button")).click();//proceed button
		
		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/div[2]/div[1]/div/div[2]/div[1]/button[2]")).click();//proceed button
		
	}
	
	}
	

