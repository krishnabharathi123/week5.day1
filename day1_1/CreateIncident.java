package week5.day1_1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident extends ServiceNowBase{
	 public static String incidentCd;
	@Test
	public void creatingNewIncident() {
	driver.findElement(By.xpath("//div[text()='Create New']")).click();
	//driver.findElement(By.xpath("//button[@type='submit'][text()='New']")).click();
	driver.switchTo().frame(0);
	driver.findElement(By.className("input-group-btn")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	Iterator<String> it=windowHandles.iterator();
	String mainWindow=it.next();
	String chindWindow=it.next();
	driver.switchTo().window(chindWindow);
	driver.findElement(By.linkText("System Administrator")).click();
	driver.switchTo().window(mainWindow);
	driver.switchTo().frame(0);
	driver.findElement(By.id("incident.short_description")).sendKeys("hello world");
	incidentCd=driver.findElement(By.name("incident.number")).getAttribute("value");
	System.out.println("Created incident is "+incidentCd);
	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(incidentCd,Keys.ENTER);
	String filteredCd=driver.findElement(By.xpath("(//tbody)[2]/tr/td[3]")).getText();
	System.out.println("Filtered incident is "+filteredCd);
	if(incidentCd.equals(filteredCd)) {
		System.out.println("New incident created successfully");
	}
	else {
		System.out.println("New incident not created");
	}

}
}
