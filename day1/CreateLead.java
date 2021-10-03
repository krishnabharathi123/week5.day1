package week5.day1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{
	@Test(dataProvider="testDatas")
	public void creatingLead(String ComName, String fName, String lName, String phNm) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(ComName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNm);
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider
	public String[][] testDatas() {
		String data[][]=new String[2][4];
		data[0][0]="TestLeaf";
		data[0][1]="Hari";
		data[0][2]="R";
		data[0][3]="99";
		
		data[1][0]="Test";
		data[1][1]="Sheriba";
		data[1][2]="T";
		data[1][3]="98";
		return data;
	}
}






