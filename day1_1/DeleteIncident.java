package week5.day1_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends ServiceNowBase {
	@Test
	public void deletingIncidents() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(CreateIncident.incidentCd, Keys.ENTER);
		driver.findElement(By.xpath("(//tbody)[2]/tr/td[3]/a")).click();
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		WebElement search = driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]"));
		search.clear();
		search.sendKeys(CreateIncident.incidentCd, Keys.ENTER);
		System.out.println(driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td")).getText());
	}

}
