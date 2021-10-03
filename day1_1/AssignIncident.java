package week5.day1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AssignIncident extends ServiceNowBase {
  @Test
  public void reassigningIncident() throws InterruptedException {
	  driver.findElement(By.xpath("//div[text()='Open']")).click();
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(CreateIncident.incidentCd,Keys.ENTER);
	  driver.findElement(By.xpath("(//tbody)[2]/tr/td[3]/a")).click();
	  driver.findElement(By.id("lookup.incident.assignment_group")).click();
	  Set<String> windowHandles = driver.getWindowHandles();
	  List<String> winList=new ArrayList<String>(windowHandles);
	  driver.switchTo().window(winList.get(1));
	  driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("software",Keys.ENTER);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("(//tr/td[3])[2]/a")).click();
	  
	  driver.switchTo().window(winList.get(0));
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("notes written");
	  driver.findElement(By.xpath("//button[@value='sysverb_update']")).click();
	  String assgnmntGrp= driver.findElement(By.xpath("//td[@class='vt'][8]")).getText();
		 String assgned= driver.findElement(By.xpath("//td[@class='vt'][9]")).getText();
		System.out.println("assignment grp is: "+assgnmntGrp);
		System.out.println("assigned is: "+assgned);
  }
}
