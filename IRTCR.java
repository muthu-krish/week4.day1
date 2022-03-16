package week4day1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.Chromedriver;

import io.github.bonigarcia.wdm.WebDrivermanager;

public class IRTCR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDrivermanager.chromedriver().setup();
		Chromedriver driver = new Chromedriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	    driver.findElement(By.xpath("//a[contains(text(),' FLIGHTS ')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());

	     driver.findElement(By.xpath("//button[text()='Allow']")).click();
	     driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
	     String text = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getText();
	     System.out.println(text);
	}

}
