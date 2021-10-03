package week5.day1_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends ServiceNowBase {
  @Test
  public void updatingIncidents() throws InterruptedException{
	  driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(CreateIncident.incidentCd,Keys.ENTER);
	  driver.findElement(By.xpath("(//tbody)[2]/tr/td[3]/a")).click();
	  Select urgency=new Select(driver.findElement(By.name("incident.urgency")));
	  urgency.selectByValue("1");
	  Select state=new Select(driver.findElement(By.name("incident.state")));
	  state.selectByVisibleText("In Progress");
	  //Thread.sleep(1000);
	  driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("notes written");
	  driver.findElement(By.xpath("//button[@value='sysverb_update']")).click();
	 String priority= driver.findElement(By.xpath("//td[@class='vt'][5]")).getText();
	 String stateval= driver.findElement(By.xpath("//td[@class='vt'][6]")).getText();
	System.out.println("Priority is: "+priority);
	System.out.println("State is: "+stateval);
  }
}
